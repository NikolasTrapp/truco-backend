package com.nikolastrapp.truco.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSockerController {

    @MessageMapping("/chat")
    @SendTo("/topic/app")
    public String greeting() throws Exception {
        return "Hello, how are you my dear?";
    }
}
