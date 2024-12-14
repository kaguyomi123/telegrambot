package command;

import org.junit.jupiter.api.DisplayName;
import ru.telegrambot.command.Command;
import ru.telegrambot.command.HelpCommand;

import static ru.telegrambot.command.CommandName.HELP;
import static ru.telegrambot.command.HelpCommand.HELP_MESSAGE;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}
