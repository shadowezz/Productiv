package seedu.address.logic.parser.util;

import java.util.Optional;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.util.Contacts;
import seedu.address.model.util.OptionalDescription;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserCommon {

    /**
     * Parses a {@code Optional<String> description} into a {@code Description}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static OptionalDescription parseDescription(Optional<String> description) throws ParseException {
        if (description.isEmpty()) {
            return new OptionalDescription(description);
        }
        String trimmedDescription = description.get().trim();
        if (!OptionalDescription.isValidDescription(trimmedDescription)) {
            throw new ParseException(OptionalDescription.MESSAGE_CONSTRAINTS);
        }
        return new OptionalDescription(trimmedDescription);
    }

    /**
     * Parses a {@code Optional<String> contacts} into an {@code Contacts}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code contacts} is invalid.
     */
    public static Contacts parseContacts(Optional<String> contacts) throws ParseException {
        if (contacts.isEmpty()) {
            return new Contacts(contacts);
        }
        String trimmedContacts = contacts.get().trim();
        if (!Contacts.isValidContacts(trimmedContacts)) {
            throw new ParseException(Contacts.MESSAGE_CONSTRAINTS);
        }
        return new Contacts(trimmedContacts);
    }
}
