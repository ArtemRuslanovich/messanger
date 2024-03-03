package com.example.messanger.messanger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
//import com.example.messanger.messanger.Message;

@Controller
public class MessageController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public MessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat")
    public void handleChatMessage(Message message) {
        // Используем SimpMessagingTemplate для отправки сообщения конкретному получателю
        messagingTemplate.convertAndSendToUser(
            message.getTo(), "/queue/messages", message);
    }
}
