package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.deliverable.deliverable.Deliverable;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyDeliverableBook {
    /**
     * Returns an unmodifiable view of the deliverables list.
     * This list will not contain any duplicate deliverables.
     */
    ObservableList<Deliverable> getDeliverableList();
}
