package seedu.address.model.util;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Optional;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.person.Name;

/**
 * Represents a Meeting's contacts in the meeting book.
 */
public class Contacts {
    public static final String EMPTY_CONTACTS_FIELD = "-";
    public static final String MESSAGE_CONSTRAINTS =
            "Contacts can only take numerical values separated with commas";

    /*
     * Contacts can only take numerical values separated with commas.
     * First character should not be a blank string.
     *
     * @@author claraadora-reused
     * Reused from https://stackoverflow.com/a/1396228 with minor modifications
     */
    public static final String VALIDATION_REGEX = "([a-zA-Z]+)(,\\s*[a-zA-Z]+)*";

    /*
     * Represents the value of Contacts.
     */
    public final Optional<String> value;

    /**
     * Constructs a {@code Contacts}.
     *
     * @param contacts A valid Optional of contact name strings.
     */
    public Contacts(Optional<String> contacts) {
        if (contacts.isPresent()) {
            checkArgument(isValidContacts(contacts.get()), MESSAGE_CONSTRAINTS);
        }
        value = contacts;
    }

//    public static Name parseName(String name) throws ParseException {
//        requireNonNull(name);
//        String trimmedName = name.trim();
//        if (!Name.isValidName(trimmedName)) {
//            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
//        }
//        return new Name(trimmedName);
//    }

    /**
     * Constructs a {@code Contacts}.
     *
     * @param contacts A valid Optional of contact name strings.
     */
    public Contacts(String contacts) {
        requireNonNull(contacts);
        checkArgument(isValidContacts(contacts), MESSAGE_CONSTRAINTS);
        value = Optional.of(contacts);
    }

    /**
     * Returns true if a given string is a valid contacts.
     */
    public static boolean isValidContacts(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value.orElse(EMPTY_CONTACTS_FIELD);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Contacts
                && value.equals(((Contacts) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
