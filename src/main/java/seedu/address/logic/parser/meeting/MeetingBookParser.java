package seedu.address.logic.parser.meeting;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.Arrays;

import seedu.address.logic.commands.meeting.Command;
import seedu.address.logic.commands.mode.SwitchCommand;
import seedu.address.logic.commands.person.AddCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */

// TODO: Check if MeetingParser (instead of AddCommandParser etc) should implement Parser
public class MeetingBookParser {

    // TODO: Move the function to higher hierarchy to be used by other parsers
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

        case AddCommand.COMMAND_WORD:
            final String argument = afterFirstWord(userInput, SwitchCommand.MESSAGE_USAGE);
            return new AddCommandParser().parse(argument);

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
    public boolean isMeetingCommand(String userInput) {
        return userInput.startsWith(Command.COMMAND_WORD);
    }

}
