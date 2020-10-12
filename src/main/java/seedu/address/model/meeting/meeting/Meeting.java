package seedu.address.model.meeting.meeting;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.util.Description;
import seedu.address.model.util.Title;

/**
 * Represents a Meeting in the meeting book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Meeting {

    private final Title title;
    private final Description description;
    private final From from;
    private final To to;
    private final Contacts contacts;
    private final Location location;

    /**
     * Every field must be present and not null.
     */
    public Meeting(Title title, Description description, From from, To to, Contacts contacts, Location location) {
        requireAllNonNull(title, description, from, to, contacts, location);
        this.title = title;
        this.description = description;
        this.from = from;
        this.to = to;
        this.contacts = contacts;
        this.location = location;
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public From getFrom() {
        return from;
    }

    public To getTo() {
        return to;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public Location getLocation() {
        return location;
    }

    /**
     * Returns true if both meetings have the same identity.
     */
    public boolean isSameMeeting(Meeting otherMeeting) {
        if (otherMeeting == this) {
            return true;
        }

        return otherMeeting != null
                && otherMeeting.getTitle().equals(getTitle())
                && otherMeeting.getDescription().equals(getDescription())
                && otherMeeting.getFrom().equals(getFrom())
                && otherMeeting.getTo().equals(getTo())
                && otherMeeting.getContacts().equals(getContacts())
                && otherMeeting.getLocation().equals(getLocation());
    }

    /**
     * Returns true if both meetings have the same identity.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Meeting)) {
            return false;
        }

        Meeting otherMeeting = (Meeting) other;
        return otherMeeting.getTitle().equals(getTitle())
                && otherMeeting.getDescription().equals(getDescription())
                && otherMeeting.getFrom().equals(getFrom())
                && otherMeeting.getTo().equals(getTo())
                && otherMeeting.getContacts().equals(getContacts())
                && otherMeeting.getLocation().equals(getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, from, to, contacts, location);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append(" Title: ")
                .append(getDescription())
                .append(" Description: ")
                .append(getFrom())
                .append(" From: ")
                .append(getTo())
                .append(" To: ")
                .append(getContacts())
                .append(" Contacts: ")
                .append(getLocation())
                .append(" Location: ");
        return builder.toString();
    }

}
