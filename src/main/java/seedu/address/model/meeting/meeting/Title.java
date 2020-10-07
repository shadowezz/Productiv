package seedu.address.model.meeting.meeting;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

// TODO : discuss immutability (update the rest upon decision)
/**
 * Represents a Meeting's title in the meeting book.
 * Guarantees: immutable; is valid as declared in {@link #isValidTitle(String)}
 */
public class Title {

    public static final String MESSAGE_CONSTRAINTS =
            "Title can take any values, and it must not be blank.";

    /*
     * The first character of the address must not be a whitespace,
     * " " (a blank string) is not a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s]";
    public final String value;

    /**
     * Constructs a {@code Title}.
     *
     * @param title A valid title.
     */
    public Title(String title) {
        requireNonNull(title);
        checkArgument(isValidTitle(title), MESSAGE_CONSTRAINTS);
        value = title;
    }

    /**
     * Returns true if a given string is a valid title.
     */
    public static boolean isValidTitle(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Title
                && value.equals(((Title) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
