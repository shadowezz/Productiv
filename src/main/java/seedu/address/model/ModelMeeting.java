package seedu.address.model;

import seedu.address.model.meeting.Meeting;
import seedu.address.model.meeting.MeetingBook;

/**
 * The API of the Model component.
 */
public interface ModelMeeting {
    /**
     * Adds the given meeting.
     * {@code meeting} must not already exist.
     */
    void addMeeting(Meeting meeting);

    /**
     * Returns true if a meeting with the same identity as {@code meeting} exists in the meeting book.
     */
    boolean hasMeeting(Meeting meeting);

    /** Returns the MeetingBook */
    MeetingBook getMeetingBook();
}
