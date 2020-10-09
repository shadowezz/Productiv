package seedu.address.storage.meeting;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.model.util.Description;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.meeting.meeting.Contacts;
import seedu.address.model.meeting.meeting.From;
import seedu.address.model.meeting.meeting.Location;
import seedu.address.model.meeting.meeting.Meeting;
import seedu.address.model.util.Title;
import seedu.address.model.meeting.meeting.To;


/**
 * Jackson-friendly version of {@link Meeting}.
 */
public class JsonAdaptedMeeting {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Meeting's %s field is missing!";

    private final String title;
    private final String description;
    private final String from;
    private final String to;
    private final String contacts;
    private final String location;

    /**
     * Constructs a {@code JsonAdaptedMeeting} with the given meeting details.
     */
    @JsonCreator
    public JsonAdaptedMeeting(@JsonProperty("title") String title, @JsonProperty("description") String description,
                             @JsonProperty("from") String from, @JsonProperty("to") String to,
                             @JsonProperty("contacts") String contacts, @JsonProperty("location") String location) {
        this.title = title;
        this.description = description;
        this.from = from;
        this.to = to;
        this.contacts = contacts;
        this.location = location;
    }

    /**
     * Converts a given {@code Meeting} into this class for Jackson use.
     */
    public JsonAdaptedMeeting(Meeting source) {
        title = source.getTitle().value;
        description = source.getDescription().value;
        from = source.getFrom().valueString;
        to = source.getTo().valueString;
        contacts = source.getContacts().value;
        location = source.getLocation().value;
    }

    /**
     * Converts this Jackson-friendly adapted meeting object into the model's {@code Meeting} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted meeting.
     */
    public Meeting toModelType() throws IllegalValueException {
        // Title
        if (title == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Title.class.getSimpleName()));
        }
        if (!Title.isValidTitle(title)) {
            throw new IllegalValueException(Title.MESSAGE_CONSTRAINTS);
        }
        final Title modelTitle = new Title(title);

        // Description
        if (description == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Description.class.getSimpleName()));
        }
        if (!Description.isValidDescription(description)) {
            throw new IllegalValueException(Description.MESSAGE_CONSTRAINTS);
        }
        final Description modelDescription = new Description(description);

        // From
        if (from == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, From.class.getSimpleName()));
        }
        if (!From.isValidFrom(from)) {
            throw new IllegalValueException(From.MESSAGE_CONSTRAINTS);
        }
        final From modelFrom = new From(from);

        // To
        if (to == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, To.class.getSimpleName()));
        }
        if (!To.isValidTo(to)) {
            throw new IllegalValueException(To.MESSAGE_CONSTRAINTS);
        }
        final To modelTo = new To(to);

        // Contacts
        if (contacts == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Contacts.class.getSimpleName()));
        }
        if (!Contacts.isValidContacts(contacts)) {
            throw new IllegalValueException(Contacts.MESSAGE_CONSTRAINTS);
        }
        final Contacts modelContacts = new Contacts(contacts);

        // Location
        if (location == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Location.class.getSimpleName()));
        }
        if (!Location.isValidLocation(location)) {
            throw new IllegalValueException(Location.MESSAGE_CONSTRAINTS);
        }
        final Location modelLocation = new Location(location);

        return new Meeting(modelTitle, modelDescription, modelFrom, modelTo, modelContacts, modelLocation);
    }
}
