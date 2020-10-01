package seedu.address.storage.deliverable;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyUserPrefsDeliverable;
import seedu.address.model.UserPrefsDeliverable;

/**
 * A class to access UserPrefsDeliverable stored in the hard disk as a json file
 * Not used.
 */
public class JsonUserPrefsDeliverableStorage implements UserPrefsDeliverableStorage {

    private Path filePath;

    public JsonUserPrefsDeliverableStorage(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public Path getUserPrefsDeliverableFilePath() {
        return filePath;
    }

    @Override
    public Optional<UserPrefsDeliverable> readUserPrefsDeliverable() throws DataConversionException, IOException {
        return readUserPrefsDeliverable(filePath);
    }

    /**
     * Similar to {@link #readUserPrefsDeliverable()}
     * @param prefsDeliverableFilePath location of the data. Cannot be null.
     * @throws DataConversionException if the file format is not as expected.
     */
    public Optional<UserPrefsDeliverable> readUserPrefsDeliverable(Path prefsDeliverableFilePath)
            throws DataConversionException {
        return JsonUtil.readJsonFile(prefsDeliverableFilePath, UserPrefsDeliverable.class);
    }

    @Override
    public void saveUserPrefsDeliverable(ReadOnlyUserPrefsDeliverable userPrefsDeliverable) throws IOException {
        JsonUtil.saveJsonFile(userPrefsDeliverable, filePath);
    }
}
