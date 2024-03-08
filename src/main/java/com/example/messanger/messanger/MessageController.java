package com.example.messanger.messanger;

import com.example.messanger.messanger.Message;
import com.example.messanger.messanger.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private ChatRoomService chatRoomService;

    @MessageMapping("/chatrooms/{roomId}/message")
    @SendTo("/topic/chatrooms/{roomId}")
    public Message sendMessage(@DestinationVariable String roomId, Message message) {
        // Additional logic to handle the message
        return message;
    }
}