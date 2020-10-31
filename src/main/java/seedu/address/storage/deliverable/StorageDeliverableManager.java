package seedu.address.storage.deliverable;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.deliverable.ReadOnlyDeliverableBook;
import seedu.address.storage.StorageManager;
import seedu.address.storage.UserPrefsStorage;

/**
 * Manages storage of DeliverableBook data in local storage.
 */
public class StorageDeliverableManager extends StorageManager implements StorageDeliverable {

    private static final Logger logger = LogsCenter.getLogger(StorageDeliverableManager.class);
    private DeliverableBookStorage deliverableBookStorage;

    /**
     * Creates a {@code StorageDeliverableManager} with the given {@code DeliverableBookStorage}
     * and {@code UserPrefsStorage}.
     */
    public StorageDeliverableManager(DeliverableBookStorage deliverableBookStorage, UserPrefsStorage userPrefsStorage) {
        super(userPrefsStorage);
        this.deliverableBookStorage = deliverableBookStorage;
    }

    // ================ DeliverableBook methods ==============================

    @Override
    public Path getBookFilePath() {
        return deliverableBookStorage.getBookFilePath();
    }

    @Override
    public Optional<ReadOnlyDeliverableBook> readDeliverableBook() throws DataConversionException, IOException {
        return readDeliverableBook(deliverableBookStorage.getBookFilePath());
    }

    public Optional<ReadOnlyDeliverableBook> readDeliverableBook(Path filePath)
            throws DataConversionException, IOException {
        logger.fine("Attempting to read data from deliverable file: " + filePath);
        return deliverableBookStorage.readDeliverableBook(filePath);
    }

    @Override
    public void saveDeliverableBook(ReadOnlyDeliverableBook deliverableBook) throws IOException {
        saveDeliverableBook(deliverableBook, deliverableBookStorage.getBookFilePath());
    }

    public void saveDeliverableBook(ReadOnlyDeliverableBook deliverableBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data deliverable file: " + filePath);
        deliverableBookStorage.saveDeliverableBook(deliverableBook, filePath);
    }
}
