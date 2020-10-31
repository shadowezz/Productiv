package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * API of general Storage component.
 */
public interface Storage {

    public Path getUserPrefsFilePath();

    public Path getBookFilePath();

    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;
}
