package seedu.address.model.meeting.util;

import java.time.LocalDateTime;
import java.util.Comparator;

import seedu.address.model.meeting.meeting.Meeting;

public class MeetingComparator implements Comparator<Meeting> {
    public int compare(Meeting a, Meeting b) {
        LocalDateTime aFrom = a.getFromLocalDateTime();
        LocalDateTime bFrom = b.getFromLocalDateTime();

        return aFrom.compareTo(bFrom);
    }
}
