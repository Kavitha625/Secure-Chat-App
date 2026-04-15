package com.chatapp.controller;

import com.chatapp.model.ChatMessage;
import com.chatapp.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatWebSocketController {

    @Autowired
    private EncryptionService service;

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/send")
    public void send(ChatMessage message) {

        String result;

        if ("encrypt".equals(message.getMode())) {
            result = service.encrypt(message.getContent(), message.getKey());
        } else {
            result = service.decrypt(message.getContent(), message.getKey());
        }

        template.convertAndSend("/topic/messages", result);
    }
}

