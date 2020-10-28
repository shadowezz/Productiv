package seedu.address.model.meeting.util;

import java.time.LocalDateTime;
import java.util.Comparator;

import seedu.address.model.meeting.meeting.Meeting;

/**
 * Represents a Comparator for Meeting which sorts by From.
 */
public class MeetingComparator implements Comparator<Meeting> {
    /**
     * Compares Meetings by From in chronological order.
     */
    public int compare(Meeting a, Meeting b) {
        LocalDateTime aFrom = a.getFromLocalDateTime();
        LocalDateTime bFrom = b.getFromLocalDateTime();

        return aFrom.compareTo(bFrom);
    }
}
