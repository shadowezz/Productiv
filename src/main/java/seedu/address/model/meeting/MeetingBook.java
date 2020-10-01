package seedu.address.model.meeting;

import static java.util.Objects.requireNonNull;

import java.util.List;

public class MeetingBook {
    // TODO: Discuss whether there is a need for meeting, address, contact, etc books
    // TODO: Change after discussion
    private List<Meeting> meetings;

    public MeetingBook() {}

    /**
     * Replaces the contents of the meeting list with {@code meetings}.
     * {@code persons} must not contain duplicate meetings.
     */
    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    /**
     * Adds a meeting to the meeting book.
     * The meeting must not already exist in the meeting book.
     */
    public void addMeeting(Meeting m) {
        meetings.add(m);
    }

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasMeeting(Meeting meeting) {
        requireNonNull(meeting);
        return meetings.contains(meeting);
    }
}
