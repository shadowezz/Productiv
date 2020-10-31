package seedu.address.storage;

import java.nio.file.Path;

/**
 * API of general book storage component.
 */
public interface BookStorage {
    /**
     * Returns the file path of the data file.
     */
    Path getBookFilePath();
}
