package com.ai.Gemini.AI.chat.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    @Value("${api.url}")
    String apiUrl;
    @Value("${api.key}")
    String apiKey;
    public String getAnswer(String question) {
       return "";
    }
}
