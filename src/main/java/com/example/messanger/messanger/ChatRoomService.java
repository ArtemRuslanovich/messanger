package com.example.messanger.messanger;

import com.example.messanger.messanger.ChatRoom;
import com.example.messanger.messanger.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @Autowired
    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    // Method to create a new chat room
    public ChatRoom createChatRoom(String name) {
        ChatRoom newChatRoom = new ChatRoom(name);
        return chatRoomRepository.save(newChatRoom);
    }

    // Method to find a chat room by its ID
    public Optional<ChatRoom> findChatRoomById(String id) {
        return chatRoomRepository.findById(id);
    }

    // Method to get all chat rooms
    public List<ChatRoom> findAllChatRooms() {
        return chatRoomRepository.findAll();
    }

    // Method to add a user to a chat room
    public boolean addUserToChatRoom(String chatRoomId, User user) {
        Optional<ChatRoom> chatRoomOpt = chatRoomRepository.findById(chatRoomId);
        if (chatRoomOpt.isPresent()) {
            ChatRoom chatRoom = chatRoomOpt.get();
            chatRoom.addUser(user);
            chatRoomRepository.save(chatRoom);
            return true;
        }
        return false;
    }

    // Method to remove a user from a chat room
    public boolean removeUserFromChatRoom(String chatRoomId, User user) {
        Optional<ChatRoom> chatRoomOpt = chatRoomRepository.findById(chatRoomId);
        if (chatRoomOpt.isPresent()) {
            ChatRoom chatRoom = chatRoomOpt.get();
            chatRoom.removeUser(user);
            chatRoomRepository.save(chatRoom);
            return true;
        }
        return false;
    }
}
