package com.example.messanger.messanger;

import com.example.messanger.messanger.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {
    // Find a chat room by its name
    Optional<ChatRoom> findByName(String name);

    // Check if a chat room with a given name exists
    boolean existsByName(String name);

    // Custom method to find chat rooms by a part of their name (like search functionality)
    List<ChatRoom> findByNameContainingIgnoreCase(String namePart);
}