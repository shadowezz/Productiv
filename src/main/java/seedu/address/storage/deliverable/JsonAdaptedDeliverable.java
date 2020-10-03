package seedu.address.storage.deliverable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.deliverable.deliverable.Deadline;
import seedu.address.model.deliverable.deliverable.Deliverable;
import seedu.address.model.deliverable.deliverable.Description;
import seedu.address.model.deliverable.deliverable.Title;

/**
 * Jackson-friendly version of {@link Deliverable}.
 * To be updated.
 */
public class JsonAdaptedDeliverable {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Deliverable's %s field is missing!";

    private final String title;
    private final String description;
    private final String deadline;
    private final String contacts;

    /**
     * Constructs a {@code JsonAdaptedDeliverable} with the given deliverable details
     */
    @JsonCreator
    public JsonAdaptedDeliverable(@JsonProperty("title") String title, @JsonProperty("description") String description,
                             @JsonProperty("deadline") String deadline, @JsonProperty("contacts") String contacts) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.contacts = contacts;
    }

    /**
     * Converts a given {@code Deliverable} into this class for Jackson use.
     */
    public JsonAdaptedDeliverable(Deliverable source) {
        title = source.getTitle().title;
        description = source.getDescription().value;
        deadline = source.getDeadline().value;
        contacts = source.getContacts();
    }

    /**
     * Converts this Jackson-friendly adapted deliverable object into the model's {@code Deliverable} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted deliverable.
     */
    public Deliverable toModelType() throws IllegalValueException {
        if (title == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Title.class.getSimpleName()));
        }
        if (!Title.isValidTitle(title)) {
            throw new IllegalValueException(Title.MESSAGE_CONSTRAINTS);
        }
        final Title modelTitle = new Title(title);

        if (!Description.isValidDescription(description)) {
            throw new IllegalValueException(Description.MESSAGE_CONSTRAINTS);
        }
        final Description modelDescription = new Description(description);

        if (!Deadline.isValidDeadline(deadline)) {
            throw new IllegalValueException(Deadline.MESSAGE_CONSTRAINTS);
        }
        final Deadline modelDeadline = new Deadline(deadline);

        return new Deliverable(modelTitle, modelDescription, modelDeadline, contacts);
    }
}
