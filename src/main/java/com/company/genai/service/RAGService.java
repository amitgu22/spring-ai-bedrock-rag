package com.company.genai.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RAGService {

    private final ChatService chatService;

    public RAGService(ChatService chatService) {
        this.chatService = chatService;
    }

    public String askWithContext(String question) {

        // TODO: Replace with OpenSearch similarity search
        List<String> documents = List.of(
                "Refunds are processed within 7 working days.",
                "Customer complaints are categorized as Billing, Technical, or Service."
        );

        String augmentedPrompt = """
                Answer the question strictly using the context below.

                Context:
                %s

                Question:
                %s
                """.formatted(String.join("\n", documents), question);

        return chatService.ask(augmentedPrompt);
    }
}
