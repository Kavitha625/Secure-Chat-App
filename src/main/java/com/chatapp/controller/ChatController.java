package com.chatapp.controller;

import com.chatapp.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChatController {

    @Autowired
    private EncryptionService service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/process")
    public String process(
            @RequestParam String message,
            @RequestParam String key,
            @RequestParam String mode,
            Model model) {

        String output;

        if (mode.equals("encrypt")) {
            output = service.encrypt(message, key);
        } else {
            output = service.decrypt(message, key);
        }

        model.addAttribute("result", output);

        return "index";
    }
}
