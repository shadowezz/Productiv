package seedu.address.testutil;

import seedu.address.model.deliverable.deliverable.Deadline;
import seedu.address.model.deliverable.deliverable.Deliverable;
import seedu.address.model.util.Description;
import seedu.address.model.util.Title;

/**
 * A utility class to help with building Deliverable objects.
 */
public class DeliverableBuilder {

    public static final String DEFAULT_TITLE = "Login screen";
    public static final String DEFAULT_DESCRIPTION = "Must include username and password fields";
    public static final String DEFAULT_DEADLINE = "12-12-2020 23:59";
    public static final String DEFAULT_CONTACTS = "2,4";

    private Title title;
    private Description description;
    private Deadline deadline;
    private String contacts;

    /**
     * Creates a {@code DeliverableBuilder} with the default details.
     */
    public DeliverableBuilder() {
        title = new Title(DEFAULT_TITLE);
        description = new Description(DEFAULT_DESCRIPTION);
        deadline = new Deadline(DEFAULT_DEADLINE);
        contacts = DEFAULT_CONTACTS;
    }

    /**
     * Initializes the DeliverableBuilder with the data of {@code deliverableToCopy}.
     */
    public DeliverableBuilder(Deliverable deliverableToCopy) {
        title = deliverableToCopy.getTitle();
        description = deliverableToCopy.getDescription();
        deadline = deliverableToCopy.getDeadline();
        contacts = deliverableToCopy.getContacts();
    }

    /**
     * Sets the {@code Title} of the {@code Deliverable} that we are building.
     */
    public DeliverableBuilder withTitle(String title) {
        this.title = new Title(title);
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code Deliverable} that we are building.
     */
    public DeliverableBuilder withDescription(String description) {
        this.description = new Description(description);
        return this;
    }

    /**
     * Sets the {@code Deadline} of the {@code Deliverable} that we are building.
     */
    public DeliverableBuilder withDeadline(String deadline) {
        this.deadline = new Deadline(deadline);
        return this;
    }

    /**
     * Sets the {@code Contacts} of the {@code Deliverable} that we are building.
     */
    public DeliverableBuilder withContacts(String contacts) {
        this.contacts = contacts;
        return this;
    }

    public Deliverable build() {
        return new Deliverable(title, description, deadline, contacts);
    }

}
