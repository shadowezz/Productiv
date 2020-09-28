package seedu.address.logic.parser.mode;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.logic.parser.person.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.person.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.person.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.person.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.person.CliSyntax.PREFIX_TAG;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import seedu.address.logic.commands.mode.Command;
import seedu.address.logic.commands.mode.SwitchCommand;
import seedu.address.logic.commands.person.AddCommand;
import seedu.address.logic.commands.person.HelpCommand; // take this out of Person
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.person.ParserUtil;
import seedu.address.model.person.person.Address;
import seedu.address.model.person.person.Email;
import seedu.address.model.person.person.Name;
import seedu.address.model.person.person.Person;
import seedu.address.model.person.person.Phone;
import seedu.address.model.person.person.tag.Tag;

/**
 * Parses user input.
 */
public class ModeParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final String BASIC_COMMAND_FORMAT = "switch";

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
//        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!userInput.startsWith(BASIC_COMMAND_FORMAT)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String argument = userInput.length() <= BASIC_COMMAND_FORMAT.length() ? "" :
                userInput.substring(BASIC_COMMAND_FORMAT.length() + 1);

        return new SwitchCommandParser().parse(argument);

    }

    public boolean isSwitchCommand(String userInput) {
        return userInput.startsWith(BASIC_COMMAND_FORMAT);
    }

}
