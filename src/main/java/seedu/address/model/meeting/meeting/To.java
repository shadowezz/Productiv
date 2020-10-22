package seedu.address.model.meeting.meeting;

import seedu.address.model.util.DateTime;

/**
 * Represents a Meeting's to in the meeting book.
 */
public class To extends DateTime {

    /**
     * Constructs a {@code To}.
     *
     * @param to A valid To.
     */
    public To(String to) {
        super(to);
    }

    /**
     * Returns true if a given string is a valid To.
     */
    public static boolean isValidTo(String test) {
        return isValidDateTime(test);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof To
                && value.equals(((To) other).value));
    }

}
