# spring-ai-bedrock-rag


🚀 Spring AI + AWS Bedrock + RAG (Enterprise GenAI Microservice)
This project demonstrates enterprise-grade integration of Generative AI into the Spring ecosystem using Spring AI, AWS Bedrock, RAG (Retrieval Augmented Generation), and Kafka.
It is designed from a Lead Java / Cloud Architect perspective, focusing on security, scalability, governance, and real-world use cases.
________________________________________
✨ Key Highlights
•	✅ Spring Boot 3 + Java 17
•	✅ Spring AI abstraction layer
•	✅ AWS Bedrock (Claude / Titan compatible)
•	✅ Retrieval Augmented Generation (RAG)
•	✅ Event-driven GenAI using Kafka
•	✅ PII masking & prompt governance
•	✅ Cloud & BFSI-ready architecture
________________________________________
🧠 Why This Project Matters
Most GenAI demos stop at calling ChatGPT APIs.
This project goes further by showing: - How GenAI fits into microservices - How to avoid hallucinations using RAG - How to secure customer data (PII masking) - How to control cost and audit prompts - How GenAI works in real enterprise workflows
________________________________________
🏗️ High-Level Architecture
Client / API Consumer
      |
      v
Spring Boot REST API
      |
      v
Spring AI (ChatClient)
      |
      +--> AWS Bedrock (Claude / Titan)
      |
      +--> Embeddings
               |
               v
        Vector Store (OpenSearch)
               |
               v
          Retrieved Context
               |
               v
         Augmented Prompt
               |
               v
           Final AI Answer
________________________________________
📁 Project Structure
spring-ai-bedrock-rag
 ├── controller     → REST APIs
 ├── service        → GenAI, RAG, PII logic
 ├── ai             → Bedrock configuration
 ├── kafka          → Event-driven GenAI
 ├── audit          → Prompt auditing hooks
 └── resources      → Config & prompt templates
________________________________________
🔹 Component-Level Explanation
1️⃣ GenAIController
Responsibility - Exposes REST endpoints for GenAI interactions - /ai/chat → Direct LLM calls - /ai/rag → Context-aware answers using RAG
Why it exists - Keeps API layer thin - Delegates intelligence to service layer
________________________________________
2️⃣ ChatService
Responsibility - Central GenAI gateway - Applies PII masking before sending prompts - Invokes Spring AI ChatClient
Why it exists - Single place for AI governance - Easy to add caching, rate limits, or retries
________________________________________
3️⃣ PiiMaskingService
Responsibility - Masks Aadhaar, account numbers, sensitive data
Why it exists - Mandatory for BFSI & enterprise compliance - Prevents raw customer data from reaching LLMs
________________________________________
4️⃣ RAGService (Retrieval Augmented Generation)
Responsibility - Retrieves relevant documents via vector similarity - Builds augmented prompt with enterprise context
Why it exists - Prevents hallucinations - Keeps GenAI grounded in internal knowledge
________________________________________
5️⃣ Kafka ComplaintConsumer
Responsibility - Consumes complaint events - Auto-summarizes, detects sentiment, categorizes
Why it exists - Demonstrates event-driven GenAI - Shows GenAI beyond REST APIs
________________________________________
6️⃣ BedrockConfig
Responsibility - Configures Spring AI ChatClient - Abstracts LLM provider from business logic
Why it exists - Model/provider can be switched without code changes
________________________________________
7️⃣ Prompt Audit Layer
Responsibility - Tracks prompt usage - Enables audit, debugging, and compliance
Why it exists - GenAI is probabilistic → auditability is critical
________________________________________
🔐 Security & Governance
•	✔ PII masking before prompts
•	✔ No customer data stored in prompts
•	✔ IAM-based Bedrock access
•	✔ Prompt auditing hooks
Enterprise takeaway: > GenAI must be governed like any other critical system.
________________________________________
💰 Cost Optimization Strategies
•	Prompt compression
•	Token limits
•	Caching AI responses
•	Async processing
•	Batch embeddings
________________________________________
🚀 Deployment Guide (AWS)
Prerequisites
•	AWS Account
•	Bedrock access enabled
•	IAM Role with bedrock:InvokeModel
•	Kafka (MSK / local)
•	OpenSearch (for RAG)
________________________________________
1️⃣ Configure AWS Credentials
Use IAM Role (recommended) or:
aws configure
________________________________________
2️⃣ Build Application
mvn clean package
________________________________________
3️⃣ Run Locally
java -jar target/spring-ai-bedrock-rag-1.0.0.jar
________________________________________
4️⃣ Deploy on AWS
Options - EC2 + ALB - ECS Fargate - EKS
Recommended: ECS Fargate for managed scaling
________________________________________
🧪 Sample API Calls
Chat
POST /ai/chat
Body: "Summarize this complaint..."
RAG
POST /ai/rag
Body: "What is the refund policy?"

