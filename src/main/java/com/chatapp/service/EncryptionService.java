package com.chatapp.service;

import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    public String encrypt(String message, String key) {
        return xor(message, key);
    }

    public String decrypt(String message, String key) {
        return xor(message, key);
    }

    private String xor(String text, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            result.append((char) (text.charAt(i) ^ key.charAt(i % key.length())));
        }

        return result.toString();
    }
}
