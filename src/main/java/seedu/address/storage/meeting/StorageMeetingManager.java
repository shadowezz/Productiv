package seedu.address.storage.meeting;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.meeting.ReadOnlyMeetingBook;
import seedu.address.storage.StorageManager;
import seedu.address.storage.UserPrefsStorage;
import seedu.address.storage.person.StoragePersonManager;

/**
 * Manages storage of MeetingBook data in local storage.
 */
public class StorageMeetingManager extends StorageManager implements StorageMeeting {

    private static final Logger logger = LogsCenter.getLogger(StoragePersonManager.class);
    private MeetingBookStorage meetingBookStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code MeetingBookStorage} and {@code UserPrefStorage}.
     */
    public StorageMeetingManager(MeetingBookStorage meetingBookStorage, UserPrefsStorage userPrefsStorage) {
        super(userPrefsStorage);
        this.meetingBookStorage = meetingBookStorage;
    }

    // ================ MeetingBook methods ==============================

    public Path getBookFilePath() {
        return meetingBookStorage.getBookFilePath();
    }

    @Override
    public Optional<ReadOnlyMeetingBook> readMeetingBook() throws DataConversionException, IOException {
        return readMeetingBook(meetingBookStorage.getBookFilePath());
    }

    public Optional<ReadOnlyMeetingBook> readMeetingBook(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return meetingBookStorage.readMeetingBook(filePath);
    }

    @Override
    public void saveMeetingBook(ReadOnlyMeetingBook meetingBook) throws IOException {
        saveMeetingBook(meetingBook, meetingBookStorage.getBookFilePath());
    }

    public void saveMeetingBook(ReadOnlyMeetingBook meetingBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        meetingBookStorage.saveMeetingBook(meetingBook, filePath);
    }

}
