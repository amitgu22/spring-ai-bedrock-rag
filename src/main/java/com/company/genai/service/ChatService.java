package com.company.genai.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;
    private final PiiMaskingService piiMaskingService;

    public ChatService(ChatClient chatClient, PiiMaskingService piiMaskingService) {
        this.chatClient = chatClient;
        this.piiMaskingService = piiMaskingService;
    }

    public String ask(String prompt) {
        String safePrompt = piiMaskingService.mask(prompt);
        return chatClient.call(safePrompt);
    }
}
