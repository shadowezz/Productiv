package seedu.address.storage.deliverable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.deliverable.deliverable.Deliverable;

/**
 * Jackson-friendly version of {@link Deliverable}.
 * To be updated.
 */
public class JsonAdaptedDeliverable {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Deliverable's %s field is missing!";

    private final int number;

    /**
     * Constructs a {@code JsonAdaptedDeliverable} with the given deliverable details
     */
    @JsonCreator
    public JsonAdaptedDeliverable(@JsonProperty("number") int number) {
        this.number = number;
    }

    /**
     * Converts a given {@code Deliverable} into this class for Jackson use.
     */
    public JsonAdaptedDeliverable(Deliverable source) {
        number = source.getNumber();
    }

    /**
     * Converts this Jackson-friendly adapted deliverable object into the model's {@code Deliverable} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted deliverabe.
     */
    public Deliverable toModelType() throws IllegalValueException {
        return new Deliverable(number);
    }
}
