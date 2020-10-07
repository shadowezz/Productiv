package seedu.address.model.meeting.meeting;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a Meeting's to in the meeting book.
 */
public class To {
    public static final String MESSAGE_CONSTRAINTS =
            "Tos should be in the format of MM/DD/YYYY or MM/DD/YYYY HH:mm, and should not be blank."
                    + "Note: Single digit month, day, and minute can start with a leading zero.";

    /*
     * Format should be MM/DD/YYYY or MM/DD/YY HH:mm
     * Single digit month, day, and minute can start with a leading zero.
     * Solution below adapted from https://stackoverflow.com/a/51231
     */
    // TODO: change back
    // public static final String VALIDATION_REGEX = "[0-9]{2}/[0-9]{2}/[0-9]{4} [0-23]{2}:[0-59]{2}";
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final Date value;

    public final String valueString;

    /**
     * Constructs a {@code To}.
     *
     * @param to A valid To.
     */

    //    // Todo: Discuss with team
    //    public To(String to) throws ParseException {
    //        requireNonNull(to);
    //        checkArgument(isValidTo(to), MESSAGE_CONSTRAINTS);
    //        valueString = to;
    //        value = DateParser.parseDate(to);
    //    }

    // Todo: Discuss with team
    public To(String to) {
        requireNonNull(to);
        checkArgument(isValidTo(to), MESSAGE_CONSTRAINTS);
        valueString = to;
        value = new Date();
    }

    /**
     * Returns true if a given string is a valid To.
     */
    public static boolean isValidTo(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    // TODO: abstract?
    @Override
    public String toString() {
        return new SimpleDateFormat("MMM d yyyy").format(value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof To
                && value.equals(((To) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
