package seedu.address.storage.meeting;

import java.io.IOException;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.meeting.ReadOnlyMeetingBook;
import seedu.address.storage.Storage;

/**
 * API of the Storage component for Meeting
 */
// TODO: build and change to MeetingBookStorage
public interface StorageMeeting extends Storage {

    Optional<ReadOnlyMeetingBook> readMeetingBook() throws DataConversionException, IOException;

    void saveMeetingBook(ReadOnlyMeetingBook meetingBook) throws IOException;

}
