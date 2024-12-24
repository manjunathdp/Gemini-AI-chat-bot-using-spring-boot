package com.ai.Gemini.AI.chat.bot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AIController {
    @Autowired
    AIService aiService;

    @PostMapping("/ask")
    ResponseEntity<String> getAnswer(@RequestBody Map<String, String> payload) {
        String answer = aiService.getAnswer(payload.get("question"));
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

}
