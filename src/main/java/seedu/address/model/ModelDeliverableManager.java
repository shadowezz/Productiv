package seedu.address.model;

import static java.util.Objects.requireNonNull;
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

    private static final Logger logger = LogsCenter.getLogger(ModelDeliverableManager.class);
    private final DeliverableBook deliverableBook;
    private final UserPrefsDeliverable userPrefsDeliverable;
    private final FilteredList<Deliverable> filteredDeliverables;

    /**
     * Initializes a ModelDeliverableManager with the given addressBook and userPrefs.
     */
    public ModelDeliverableManager(ReadOnlyDeliverableBook deliverableBook, ReadOnlyUserPrefsDeliverable userPrefsDeliverable) {
        super();
        requireAllNonNull(deliverableBook, userPrefsDeliverable);

        logger.fine("Initializing with deliverable book: " + deliverableBook + " and user prefs " + userPrefsDeliverable);

        this.deliverableBook = new DeliverableBook(deliverableBook);
        this.userPrefsDeliverable = new UserPrefsDeliverable(userPrefsDeliverable);
        filteredDeliverables = new FilteredList<>(this.deliverableBook.getDeliverableList());
    }

    public ModelDeliverableManager() {
        this(new DeliverableBook(), new UserPrefsDeliverable());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefsDeliverable userPrefsDeliverable) {
        requireNonNull(userPrefsDeliverable);
        this.userPrefsDeliverable.resetData(userPrefsDeliverable);
    }

    @Override
    public ReadOnlyUserPrefsDeliverable getUserPrefsDeliverable() {
        return userPrefsDeliverable;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefsDeliverable.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefsDeliverable.setGuiSettings(guiSettings);
    }

    @Override
    public Path getDeliverableBookFilePath() {
        return userPrefsDeliverable.getDeliverableBookFilePath();
    }

    @Override
    public void setDeliverableBookFilePath(Path deliverableBookFilePath) {
        requireNonNull(deliverableBookFilePath);
        userPrefsDeliverable.setDeliverableBookFilePath(deliverableBookFilePath);
    }

    //=========== AddressBook ================================================================================

    @Override
    public void setDeliverableBook(ReadOnlyDeliverableBook deliverableBook) {
        this.deliverableBook.resetData(deliverableBook);
    }

    @Override
    public ReadOnlyDeliverableBook getDeliverableBook() {
        return deliverableBook;
    }

    @Override
    public boolean hasDeliverable(Deliverable deliverable) {
        requireNonNull(deliverable);
        return deliverableBook.hasDeliverable(deliverable);
    }

    @Override
    public void deleteDeliverable(Deliverable target) {
        deliverableBook.removeDeliverable(target);
    }

    @Override
    public void addDeliverable(Deliverable deliverable) {
        deliverableBook.addDeliverable(deliverable);
        updateFilteredDeliverableList(PREDICATE_SHOW_ALL_DELIVERABLES);
    }

    @Override
    public void setDeliverable(Deliverable target, Deliverable editedDeliverable) {
        requireAllNonNull(target, editedDeliverable);
        deliverableBook.setDeliverable(target, editedDeliverable);
    }

    //=========== Filtered Person List Accessors =============================================================

    @Override
    public ObservableList<Deliverable> getFilteredDeliverableList() {
        return filteredDeliverables;
    }

    @Override
    public void updateFilteredDeliverableList(Predicate<Deliverable> predicate) {
        requireNonNull(predicate);
        filteredDeliverables.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelDeliverableManager)) {
            return false;
        }

        // state check
        ModelDeliverableManager other = (ModelDeliverableManager) obj;
        return deliverableBook.equals(other.deliverableBook)
                && userPrefsDeliverable.equals(other.userPrefsDeliverable)
                && filteredDeliverables.equals(other.filteredDeliverables);
    }
}
