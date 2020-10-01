package seedu.address.model.person.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.StringUtil.getStringJoinedBySeparator;

import java.util.Arrays;

/**
 * Represents a Person's role in the address book.
 * Guarantees: immutable;
 */
public class Role {

    public static final String MESSAGE_CONSTRAINTS =
            "Role should only be a " + getStringJoinedBySeparator(Arrays.stream(RoleEnum.values())
                    .map(role -> role.getArgument() + " (" + role.toString() + ")"), " or ");
    public static final String VALIDATION_REGEX =
            getStringJoinedBySeparator(Arrays.stream(RoleEnum.values()).map(role -> role.getArgument()), "|");
    public final RoleEnum value;

    /**
     * Constructs a {@code Role}.
     *
     * @param role A valid role.
     */
    public Role(String role) {
        requireNonNull(role);
        checkArgument(isValidRole(role), MESSAGE_CONSTRAINTS);
        RoleEnum roleEnum = RoleEnum.getEnumByArgument(role);
        requireNonNull(roleEnum);
        value = roleEnum;
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
