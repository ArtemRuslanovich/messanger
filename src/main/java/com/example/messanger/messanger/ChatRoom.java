package com.example.messanger.messanger;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class ChatRoom {
    private String id;
    private String name;
    private Set<User> users = new HashSet<>();

    public ChatRoom(String name) {
        this.id = UUID.randomUUID().toString(); // Генерация уникального идентификатора для комнаты
        this.name = name;
    }

    // Добавление пользователя в чат-комнату
    public void addUser(User user) {
        this.users.add(user);
    }

    // Удаление пользователя из чат-комнаты
    public void removeUser(User user) {
        this.users.remove(user);
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }
}
