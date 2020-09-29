package seedu.address.model.deliverable.deliverable;

import java.util.Objects;

/**
 * Represents a Deliverable in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Deliverable {

    //identity fields
    private final int number;

    /**
     * Every field must be present and not null.
     */
    public Deliverable(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    /**
     * Returns true if both deliverables have the same number.
     */
    public boolean isSameDeliverable(Deliverable otherDeliverable) {
        if (otherDeliverable == this) {
            return true;
        }

        return otherDeliverable != null
                && otherDeliverable.getNumber() == getNumber();
    }

    /**
     * Returns true if both deliverables have the same number.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Deliverable)) {
            return false;
        }

        Deliverable otherDeliverable = (Deliverable) other;
        return otherDeliverable.getNumber() == getNumber();
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Deliverable")
                .append(" Number: ")
                .append(getNumber());
        return builder.toString();
    }

}
