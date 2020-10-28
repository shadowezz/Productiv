package seedu.address.model.deliverable.util;

import java.time.LocalDateTime;
import java.util.Comparator;

import seedu.address.model.event.TimeEvent;

/**
 * Represents a Comparator for Deliverable which sorts by Deadline.
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
