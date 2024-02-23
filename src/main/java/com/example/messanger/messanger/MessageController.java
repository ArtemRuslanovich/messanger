package com.example.messanger.messanger;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MessageController {
    
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message handleChatMessage(@RequestBody Message message) {
        return message;
    }
}
