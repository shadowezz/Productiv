package seedu.address.logic.parser.mode;

import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import seedu.address.logic.commands.mode.Command;
import seedu.address.logic.commands.mode.ExitCommand;
import seedu.address.logic.commands.mode.HelpCommand;
import seedu.address.logic.commands.mode.SwitchCommand;
import seedu.address.logic.parser.TokenizedUserInput;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class ModeParser {
    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        TokenizedUserInput tokenizedUserInput = TokenizedUserInput.getCommandWordArgumentsFromUserInput(userInput);
        String commandWord = tokenizedUserInput.getCommandWord();
        String arguments = tokenizedUserInput.getArguments();

        switch (commandWord) {

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case SwitchCommand.COMMAND_WORD:
            return new SwitchCommandParser().parse(arguments);

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
    public boolean isModeCommand(String userInput) throws ParseException {
        TokenizedUserInput tokenizedUserInput = TokenizedUserInput.getCommandWordArgumentsFromUserInput(userInput);
        String commandWord = tokenizedUserInput.getCommandWord();
        return commandWord.startsWith(SwitchCommand.COMMAND_WORD) || commandWord.startsWith(ExitCommand.COMMAND_WORD)
                || commandWord.startsWith(HelpCommand.COMMAND_WORD);
    }

}
