package com.company.genai.kafka;

import com.company.genai.service.ChatService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ComplaintConsumer {

    private final ChatService chatService;

    public ComplaintConsumer(ChatService chatService) {
        this.chatService = chatService;
    }

    @KafkaListener(topics = "complaints")
    public void consume(String complaint) {

        String summaryPrompt = """
                Summarize the following customer complaint in 3 bullets
                and identify sentiment (Positive/Neutral/Negative):

                %s
                """.formatted(complaint);

        String aiResponse = chatService.ask(summaryPrompt);

        // Persist summary, sentiment, category
        System.out.println("AI Response: " + aiResponse);
    }
}
