package seedu.address.logic.parser.deliverable;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.deliverable.CliSyntax.PREFIX_NUMBER;

import java.util.stream.Stream;

import seedu.address.logic.commands.deliverable.AddCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.deliverable.deliverable.Deliverable;


/**
 * Parses input arguments and creates a new AddCommand object for deliverable
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public AddCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(userInput, PREFIX_NUMBER);

        if (!arePrefixesPresent(argMultimap, PREFIX_NUMBER)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        int number = Integer.parseInt(argMultimap.getValue(PREFIX_NUMBER).get());
        Deliverable deliverable = new Deliverable(number);
        return new AddCommand(deliverable);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
