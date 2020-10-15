package seedu.address.logic.parser.deliverable;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.deliverable.CliSyntax.PREFIX_CONTACTS;
import static seedu.address.logic.parser.deliverable.CliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.deliverable.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.deliverable.CliSyntax.PREFIX_MILESTONE;
import static seedu.address.logic.parser.deliverable.CliSyntax.PREFIX_TITLE;

import java.util.stream.Stream;

import seedu.address.logic.commands.deliverable.AddCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.deliverable.deliverable.Deadline;
import seedu.address.model.deliverable.deliverable.Deliverable;
import seedu.address.model.deliverable.deliverable.Milestone;
import seedu.address.model.util.Description;
import seedu.address.model.util.Title;

/**
 * Parses input arguments and creates a new AddCommand object for deliverable
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_TITLE, PREFIX_MILESTONE,
                PREFIX_DESCRIPTION, PREFIX_DEADLINE, PREFIX_CONTACTS);

        if (!arePrefixesPresent(argMultimap, PREFIX_TITLE, PREFIX_MILESTONE) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        Title title = ParserUtil.parseTitle(argMultimap.getValue(PREFIX_TITLE).get());
        Milestone milestone = ParserUtil.parseMilestone(argMultimap.getValue(PREFIX_MILESTONE).get());
        Description description = argMultimap.getValue(PREFIX_DESCRIPTION).isEmpty()
                ? Description.createEmptyDescription()
                : ParserUtil.parseDescription(argMultimap.getValue(PREFIX_DESCRIPTION).get());
        Deadline deadline = argMultimap.getValue(PREFIX_DEADLINE).isEmpty()
                ? Deadline.createEmptyDeadline()
                : ParserUtil.parseDeadline(argMultimap.getValue(PREFIX_DEADLINE).get());
        String contacts = argMultimap.getValue(PREFIX_CONTACTS).isEmpty()
                ? "NIL"
                : ParserUtil.parseContacts(argMultimap.getValue(PREFIX_CONTACTS).get());

        Deliverable deliverable = new Deliverable(title, milestone, description, deadline, contacts);

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
