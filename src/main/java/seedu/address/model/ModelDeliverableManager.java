package seedu.address.model;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.deliverable.deliverable.Deliverable;

/**
 * Represents the in-memory model of the meeting book data
 */
public class ModelDeliverableManager implements ModelDeliverable {

    private static final Logger logger = LogsCenter.getLogger(ModelPersonManager.class);

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {

    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return null;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return null;
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {

    }

    @Override
    public Path getDeliverableBookFilePath() {
        return null;
    }

    @Override
    public void setDeliverableBookFilePath(Path deliverableBookFilePath) {

    }

    @Override
    public void setDeliverableBook(ReadOnlyDeliverableBook deliverableBook) {

    }

    @Override
    public ReadOnlyAddressBook getMeetingBook() {
        return null;
    }

    @Override
    public boolean hasDeliverable(Deliverable deliverable) {
        return false;
    }

    @Override
    public void deleteDeliverable(Deliverable target) {

    }

    @Override
    public void addDeliverable(Deliverable deliverable) {

    }

    @Override
    public void setDeliverable(Deliverable target, Deliverable editedDeliverable) {

    }

    @Override
    public ObservableList<Deliverable> getFilteredDeliverableList() {
        return null;
    }

    @Override
    public void updateFilteredDeliverableList(Predicate<Deliverable> predicate) {

    }
}
