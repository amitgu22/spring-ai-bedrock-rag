package com.company.genai.service;

import org.springframework.stereotype.Service;

@Service
public class PiiMaskingService {

    public String mask(String input) {
        if (input == null) return null;

        // Mask Aadhaar / Account numbers (example)
        return input
                .replaceAll("\\b\\d{12}\\b", "XXXX-PII")
                .replaceAll("\\b\\d{16}\\b", "XXXX-PII");
    }
}
