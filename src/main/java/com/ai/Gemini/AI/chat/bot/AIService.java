package com.ai.Gemini.AI.chat.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class AIService {

    @Value("${api.url}")
    String apiUrl;
    @Value("${api.key}")
    String apiKey;

    private final WebClient webClient;

    public AIService(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }


    public String getAnswer(String question) {
//        {
//            "contents": [{"parts":[{"text":"Explain how AI works"}]}]
//        }
        Map<String, Object> responseBody = Map.of(
                "contents", new Object[]{
                        Map.of(
                                "parts", new Object[]{
                                        Map.of(
                                                "text", question
                                        )
                                }
                        )
                }
        );


        return webClient.post()
                .uri(apiUrl + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(responseBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
