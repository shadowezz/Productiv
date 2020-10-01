package seedu.address.testutil;

import seedu.address.model.deliverable.deliverable.Deliverable;

/**
 * A utility class to help with building Deliverable objects.
 */
public class DeliverableBuilder {

    public static final int DEFAULT_NUMBER = 1;

    private int number;

    /**
     * Creates a {@code DeliverableBuilder} with the default details.
     */
    public DeliverableBuilder() {
        number = DEFAULT_NUMBER;
    }

    /**
     * Initializes the DeliverableBuilder with the data of {@code deliverableToCopy}.
     */
    public DeliverableBuilder(Deliverable deliverableToCopy) {
        number = deliverableToCopy.getNumber();
    }

    /**
     * Sets the number of the {@code Deliverable} that we are building.
     */
    public DeliverableBuilder withNumber(int number) {
        this.number = number;
        return this;
    }

    public Deliverable build() {
        return new Deliverable(number);
    }

}
