package seedu.address.model.meeting.util;

import java.time.LocalDateTime;
import java.util.Comparator;

import seedu.address.model.event.TimeEvent;

/**
 * Represents a Comparator for Meeting which sorts by From.
 */
public class TimeEventComparator implements Comparator<TimeEvent> {
    /**
     * Compares Meetings by From in ascending order.
     */
    public int compare(TimeEvent a, TimeEvent b) {
        LocalDateTime timeA = a.getIndicatorTime();
        LocalDateTime timeB = b.getIndicatorTime();

        return timeA.compareTo(timeB);
    }
}
