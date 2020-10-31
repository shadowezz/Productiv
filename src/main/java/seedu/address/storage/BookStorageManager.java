package seedu.address.storage;

import java.nio.file.Path;

/**
 * A class to store the file path of a particular book in local storage.
 */
public class BookStorageManager implements BookStorage {

    protected Path filePath;

    public BookStorageManager(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public Path getBookFilePath() {
        return filePath;
    }
}
