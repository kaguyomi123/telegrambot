package ru.telegrambot.service;

public interface SendBotMessageService {
    void sendMessage(String chatId, String message);
}
