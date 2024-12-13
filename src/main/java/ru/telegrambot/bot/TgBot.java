package ru.telegrambot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.validation.constraints.NotNull;

@Component
public class TgBot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(@NotNull Update update) {
        long chatId;
        String userName;
        String receivedMessage;


        if(update.hasMessage() && update.getMessage().hasText()) {
            chatId = update.getMessage().getChatId();
            userName = update.getMessage().getFrom().getFirstName();
            receivedMessage = update.getMessage().getText();

            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));
            message.setText(userName + ": " + receivedMessage);

            try {
                execute(message);
            } catch (TelegramApiException e) {

                e.printStackTrace();
            }
        }
    }
}
