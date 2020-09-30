package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyDeliverableBook;
import seedu.address.model.ReadOnlyUserPrefsDeliverable;
import seedu.address.model.UserPrefsDeliverable;
import seedu.address.storage.deliverable.DeliverableBookStorage;
import seedu.address.storage.deliverable.UserPrefsDeliverableStorage;

/**
 * API of the Storage component for Deliverable
 */
public interface StorageDeliverable extends DeliverableBookStorage, UserPrefsDeliverableStorage {
    @Override
    Optional<UserPrefsDeliverable> readUserPrefsDeliverable() throws DataConversionException, IOException;

    @Override
    void saveUserPrefsDeliverable(ReadOnlyUserPrefsDeliverable userPrefsDeliverable) throws IOException;

    @Override
    Path getDeliverableBookFilePath();

    @Override
    Optional<ReadOnlyDeliverableBook> readDeliverableBook() throws DataConversionException, IOException;

    @Override
    void saveDeliverableBook(ReadOnlyDeliverableBook deliverableBook) throws IOException;
}
