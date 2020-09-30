package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyDeliverableBook;
import seedu.address.model.ReadOnlyUserPrefsDeliverable;
import seedu.address.model.UserPrefsDeliverable;
import seedu.address.storage.deliverable.DeliverableBookStorage;
import seedu.address.storage.deliverable.UserPrefsDeliverableStorage;

/**
 * Manages storage of DeliverableBook data in local storage.
 */
public class StorageDeliverableManager implements StorageDeliverable {

    private static final Logger logger = LogsCenter.getLogger(StoragePersonManager.class);
    private DeliverableBookStorage deliverableBookStorage;
    private UserPrefsDeliverableStorage userPrefsDeliverableStorage;

    /**
     * Creates a {@code StorageDeliverableManager} with the given {@code DeliverableBookStorage} and {@code UserPrefsDeliverableStorage}.
     */
    public StorageDeliverableManager(DeliverableBookStorage deliverableBookStorage, UserPrefsDeliverableStorage userPrefsDeliverableStorage) {
        this.deliverableBookStorage = deliverableBookStorage;
        this.userPrefsDeliverableStorage = userPrefsDeliverableStorage;
    }

    // ================ UserPrefs methods ==============================
    @Override
    public Path getUserPrefsDeliverableFilePath() {
        return userPrefsDeliverableStorage.getUserPrefsDeliverableFilePath();
    }

    @Override
    public Optional<UserPrefsDeliverable> readUserPrefsDeliverable() throws DataConversionException, IOException {
        return userPrefsDeliverableStorage.readUserPrefsDeliverable();
    }

    @Override
    public void saveUserPrefsDeliverable(ReadOnlyUserPrefsDeliverable userPrefsDeliverable) throws IOException {
        userPrefsDeliverableStorage.saveUserPrefsDeliverable(userPrefsDeliverable);
    }

    // ================ AddressBook methods ==============================

    @Override
    public Path getDeliverableBookFilePath() {
        return deliverableBookStorage.getDeliverableBookFilePath();
    }

    @Override
    public Optional<ReadOnlyDeliverableBook> readDeliverableBook() throws DataConversionException, IOException {
        return readDeliverableBook(deliverableBookStorage.getDeliverableBookFilePath());
    }

    @Override
    public Optional<ReadOnlyDeliverableBook> readDeliverableBook(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from deliverable file: " + filePath);
        return deliverableBookStorage.readDeliverableBook(filePath);
    }

    @Override
    public void saveDeliverableBook(ReadOnlyDeliverableBook deliverableBook) throws IOException {
        saveDeliverableBook(deliverableBook, deliverableBookStorage.getDeliverableBookFilePath());
    }

    @Override
    public void saveDeliverableBook(ReadOnlyDeliverableBook deliverableBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data deliverable file: " + filePath);
        deliverableBookStorage.saveDeliverableBook(deliverableBook, filePath);
    }
}
