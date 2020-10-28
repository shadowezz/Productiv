package seedu.address.model.deliverable.util;

import java.time.LocalDateTime;
import java.util.Comparator;

import seedu.address.model.deliverable.deliverable.Deliverable;

/**
 * Represents a Comparator for Deliverable which sorts by Deadline.
 */
public class DeliverableComparator implements Comparator<Deliverable> {
    /**
     * Compares Deliverables by Deadline in chronological order.
     */
    public int compare(Deliverable a, Deliverable b) {
        LocalDateTime aDeadline = a.getDeadlineLocalDateTime();
        LocalDateTime bDeadline = b.getDeadlineLocalDateTime();

        return aDeadline.compareTo(bDeadline);
    }
}
