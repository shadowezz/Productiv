package seedu.address.model.deliverable.deliverable;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a deliverable's milestone in the deliverable book.
 * Guarantees: immutable; is valid as declared in {@link #isValidMilestone(String)}
 */
public class Milestone {

    public static final String MESSAGE_CONSTRAINTS
            = "Milestone can only take numerical values separated by dots.";

    /*
     * Milestone can only take numerical values separated with dots.
     * First and last characters must both be numbers.
     */
    public static final String VALIDATION_REGEX = "^\\d+(\\.\\d+)*$";

    public static final String PREFIX = "v";

    public final String value;

    /**
     * Constructs a {@code Milestone}.
     *
     * @param milestone A valid milestone.
     */
    public Milestone(String milestone) {
        requireNonNull(milestone);
        checkArgument(isValidMilestone(milestone), MESSAGE_CONSTRAINTS);
        value = PREFIX + milestone;
    }

    /**
     * Returns true if a given string is a valid milestone.
     */
    public static boolean isValidMilestone(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Milestone)
                && value.equals(((Milestone) other).value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
