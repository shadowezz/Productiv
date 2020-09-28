package seedu.address.logic.parser.mode;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.Arrays;

import seedu.address.logic.commands.mode.Command;
import seedu.address.logic.commands.mode.ExitCommand;
import seedu.address.logic.commands.mode.HelpCommand;
import seedu.address.logic.commands.mode.SwitchCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class ModeParser {

    private String afterFirstWord(String userInput, String usage) throws ParseException {
        final String[] words = userInput.split(" ");

        if (words.length <= 1) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, usage));
        }
        return String.join("", Arrays.copyOfRange(words, 1, words.length));
    }

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {

        final String commandWord = userInput.split(" ")[0];

        switch (commandWord) {

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case SwitchCommand.COMMAND_WORD:
            final String argument = afterFirstWord(userInput, SwitchCommand.MESSAGE_USAGE);
            return new SwitchCommandParser().parse(argument);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }

    }

    /**
     * Checks if user input is a mode command.
     *
     * @param userInput full user input string
     * @return whether the user input is a mode command
     */
    public boolean isModeCommand(String userInput) {
        return userInput.startsWith(SwitchCommand.COMMAND_WORD) || userInput.startsWith(ExitCommand.COMMAND_WORD)
                || userInput.startsWith(HelpCommand.COMMAND_WORD);
    }

}
