package seedu.address.model.deliverable.deliverable;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a Deliverable's deadline in the deliverable book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDeadline(String)}
 */
public class Deadline {

    public static final String MESSAGE_CONSTRAINTS = "Deadlines must be in DD-MM-YYYY HH:MM format";

    public final String value;

    public final LocalDateTime dateTimeValue;

    /**
     * Constructs a {@code Deadline}.
     *
     * @param deadline A valid deadline.
     */
    public Deadline(String deadline) {
        requireNonNull(deadline);
        if (deadline.equals("NIL")) {
            dateTimeValue = LocalDateTime.MAX;
        } else {
            checkArgument(isValidDeadline(deadline), MESSAGE_CONSTRAINTS);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            dateTimeValue = LocalDateTime.parse(deadline, formatter);
        }
        value = deadline;
    }

    /**
     * Constructs an empty deadline.
     */
    public static Deadline createEmptyDeadline() {
        return new Deadline("NIL");
    }

    /**
     * Returns true if a given string is a valid deadline.
     */
    public static boolean isValidDeadline(String test) {
        //TODO Filter out more invalid dates, e.g. 30 Feb, 31 Sep, etc.
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(test, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Deadline) // instanceof handles nulls
                && value.equals((((Deadline) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}

