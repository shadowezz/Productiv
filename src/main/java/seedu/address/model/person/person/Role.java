package seedu.address.model.person.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Represents a Person's role in the address book.
 * Guarantees: immutable;
 */
public class Role {

    public static final String MESSAGE_CONSTRAINTS =
            "Role should only be a " + getMessageConstraints();
    public static final String VALIDATION_REGEX = getValidationRegex();
    public final RoleEnum value;

    /**
     * Constructs a {@code Role}.
     *
     * @param role A valid role.
     */
    public Role(String role) {
        requireNonNull(role);
        checkArgument(isValidRole(role), MESSAGE_CONSTRAINTS);
        value = Arrays.stream(RoleEnum.values()).filter(x -> x.getArgument().equals((role))).findFirst().get();
    }

    private static final String getMessageConstraints() {
        return Arrays.stream(RoleEnum.values()).map(role -> role.toString() + " (" + role.getArgument() + ")").collect(Collectors.joining(" or "));
    }

    private static final String getValidationRegex() {
        return Arrays.stream(RoleEnum.values()).map(role -> role.getArgument()).collect(Collectors.joining("|"));
    }

    /**
     * Returns true if a given string is a valid role.
     */
    public static boolean isValidRole(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Role // instanceof handles nulls
                && value.equals(((Role) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
