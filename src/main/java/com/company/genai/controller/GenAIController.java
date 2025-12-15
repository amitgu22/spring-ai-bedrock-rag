package com.company.genai.controller;

import com.company.genai.service.ChatService;
import com.company.genai.service.RAGService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class GenAIController {

    private final ChatService chatService;
    private final RAGService ragService;

    public GenAIController(ChatService chatService, RAGService ragService) {
        this.chatService = chatService;
        this.ragService = ragService;
    }

    @PostMapping("/chat")
    public String chat(@RequestBody String prompt) {
        return chatService.ask(prompt);
    }

    @PostMapping("/rag")
    public String rag(@RequestBody String question) {
        return ragService.askWithContext(question);
    }
}
