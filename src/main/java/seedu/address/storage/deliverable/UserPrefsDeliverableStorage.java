package seedu.address.storage.deliverable;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyUserPrefsDeliverable;
import seedu.address.model.UserPrefsDeliverable;

/**
 * Represents a storage for {@link UserPrefsDeliverable}.
 * Not used.
 */
public interface UserPrefsDeliverableStorage {
    /**
     * Returns the file path of the UserPrefsDeliverable data file.
     */
    Path getUserPrefsDeliverableFilePath();

    /**
     * Returns UserPrefsDeliverable data from storage.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<UserPrefsDeliverable> readUserPrefsDeliverable() throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyUserPrefsDeliverable} to the storage.
     * @param userPrefsDeliverable cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveUserPrefsDeliverable(ReadOnlyUserPrefsDeliverable userPrefsDeliverable) throws IOException;
}
