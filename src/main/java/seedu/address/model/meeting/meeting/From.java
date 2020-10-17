package seedu.address.model.meeting.meeting;

import seedu.address.model.util.DateTime;

/**
 * Represents a Meeting's from in the meeting book.
 */
public class From extends DateTime {

    /**
     * Constructs a {@code To}.
     *
     * @param from A valid To.
     */
    public From(String from) {
        super(from);
    }

    /**
     * Returns true if a given string is a valid from.
     */
    public static boolean isValidFrom(String test) {
        return isValidDateTime(test);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof From
                && value.equals(((From) other).value));
    }

}
