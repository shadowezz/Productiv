package seedu.address.model.deliverable.deliverable;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.util.Description;
import seedu.address.model.util.Title;

/**
 * Represents a Deliverable in the deliverable book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Deliverable {

    // Identity fields
    private final Title title;

    // Data fields
    private final Description description;
    private final Deadline deadline;

    // TODO: Amend this to Person[] and point to respective contacts.
    private final String contacts;

    /**
     * Only title field must be present.
     */
    public Deliverable(Title title, Description description, Deadline deadline, String contacts) {
        requireAllNonNull(title);
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.contacts = contacts;
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public Deadline getDeadline() {
        return deadline;
    }

    public String getContacts() {
        return contacts;
    }

    /**
     * Returns true if both deliverables share the same title.
     * This defines a weaker notion of equality between two deliverables.
     */
    public boolean isSameDeliverable(Deliverable otherDeliverable) {
        if (otherDeliverable == this) {
            return true;
        }

        return otherDeliverable != null
                && otherDeliverable.getTitle().equals(getTitle());
    }

    /**
     * Returns true if both deliverables have the same identity and data fields.
     * This defines a stronger notion of equality between two deliverables.
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
        return otherDeliverable.getTitle().equals(getTitle())
                && otherDeliverable.getDescription().equals(getDescription())
                && otherDeliverable.getDeadline().equals(getDeadline())
                && otherDeliverable.getContacts().equals(getContacts());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, description, deadline, contacts);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append(" Description: ")
                .append(getDescription())
                .append(" Deadline: ")
                .append(getDeadline())
                .append(" Contacts: ")
                .append(getContacts());
        return builder.toString();
    }

}
