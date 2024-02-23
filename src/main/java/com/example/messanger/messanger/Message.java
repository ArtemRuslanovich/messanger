package com.example.messanger.messanger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private String from;
    private String to;
    private String text;
    private String time;

    public Message() {
        this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public Message(String from, String to, String text) {
        this();
        this.from = from;
        this.to = to;
        this.text = text;
    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }


    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getTime() {
        return time;
    }
}
