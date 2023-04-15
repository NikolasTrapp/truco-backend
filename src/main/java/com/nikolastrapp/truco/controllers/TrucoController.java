package com.nikolastrapp.truco.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrucoController {

        @Autowired
        private SimpMessagingTemplate messagingTemplate;

        @RequestMapping("/send-message")
        public void sendMessage() {
            messagingTemplate.convertAndSend("/my-websocket", "Hello, world!");
        }


}
