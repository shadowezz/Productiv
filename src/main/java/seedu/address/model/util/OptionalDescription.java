package seedu.address.model.util;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Optional;

/**
 * Represents a Deliverable's description in the deliverable book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDescription(String)}
 */

// TODO: to be renamed
public class OptionalDescription {

    public static final String EMPTY_DESCRIPTION_FIELD = "-";
    public static final String MESSAGE_CONSTRAINTS = "Descriptions can take any values, and it should not be blank";

    /*
     * The first character of the description must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final Optional<String> value;

    /**
     * Constructs a {@code Description}.
     *
     * @param description A valid description.
     */
    public OptionalDescription(Optional<String> description) {
        if (description.isPresent()) {
            checkArgument(isValidDescription(description.get()), MESSAGE_CONSTRAINTS);
        }
        value = description;
    }

    /**
     * Constructs a {@code Description}.
     *
     * @param description A valid description.
     */
    public OptionalDescription(String description) {
        requireNonNull(description);
        checkArgument(isValidDescription(description), MESSAGE_CONSTRAINTS);
        value = Optional.of(description);
    }

    /**
     * Returns true if a given string is a valid deadline.
     */
    public static boolean isValidDescription(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value.orElse(EMPTY_DESCRIPTION_FIELD);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof OptionalDescription) // instanceof handles nulls
                && value.equals((((OptionalDescription) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
