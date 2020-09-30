package seedu.address.model.person.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.stream.Collectors;

/**
 * Represents a Person's role in the address book.
 * Guarantees: immutable;
 */
public class Role {

    public enum RoleEnum {
        DEVELOPER {
            @Override
            public String toString() {
                return "dev";
            }
        },
        STAKEHOLDER {
            @Override
            public String toString() {
                return "stk";
            }
        }
    }

    public static final String MESSAGE_CONSTRAINTS =
            "Role should only be a developer (" + RoleEnum.DEVELOPER + ") or stakeholder (" + RoleEnum.STAKEHOLDER +")";
    public static final String VALIDATION_REGEX = RoleEnum.DEVELOPER + "|" + RoleEnum.STAKEHOLDER;
    public final RoleEnum value;

    /**
     * Constructs a {@code Role}.
     *
     * @param role A valid role.
     */
    public Role(String role) {
        requireNonNull(role);
        checkArgument(isValidRole(role), MESSAGE_CONSTRAINTS);
        value = Enum.valueOf(RoleEnum.class, role);
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
