package ru.telegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegrambot.service.SendBotMessageService;

public class UnknownCommand implements Command {
    public static final String UNKNOWN_MESSAGE = "Не понимаю вас \uD83D\uDE1F; напишите /help, чтобы узнать список команд.";

    private final SendBotMessageService sendBotMessageService;

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
