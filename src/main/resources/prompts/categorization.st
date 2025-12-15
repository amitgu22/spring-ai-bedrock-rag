You are an AI assistant helping classify customer complaints in an enterprise system.

Based on the complaint text below, categorize it into ONE of the following categories:

- Billing
- Technical
- Service
- Account
- Refund
- Other

Also provide a one-line justification for the chosen category.

Complaint Text:
{complaintText}

Respond strictly in the following JSON format:
{
  "category": "<Category>",
  "reason": "<Short justification>"
}
