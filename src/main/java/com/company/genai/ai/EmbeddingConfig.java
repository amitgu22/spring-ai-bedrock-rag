package com.company.genai.ai;

import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Embedding configuration used for RAG (vector similarity search).
 * This can be backed by:
 * - AWS Bedrock Titan Embeddings
 * - OpenSearch
 * - PGVector
 * - Redis Vector Store
 */
@Configuration
public class EmbeddingConfig {

    @Bean
    public EmbeddingClient embeddingClient(EmbeddingModel embeddingModel) {
        return new EmbeddingClient(embeddingModel);
    }
}
