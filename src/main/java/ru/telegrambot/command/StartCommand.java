package ru.telegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegrambot.service.SendBotMessageService;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    public final static String START_MESSAGE = "yo";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
