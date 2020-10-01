package seedu.address.model.meeting;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;

// TODO: Need to check and fix
public class ModelMeetingManager implements ModelMeeting {
    private static final Logger logger = LogsCenter.getLogger(ModelMeetingManager.class);

    private final MeetingBook meetingBook;

    // TODO: May need to add userPrefs
    /**
     * Initializes a ModelMeetingManager with the given meetingBook WITHOUT userPrefs.
     */
    public ModelMeetingManager(MeetingBook meetingBook) {
        super();
        requireAllNonNull(meetingBook);

        logger.fine("Initializing with meeting book: " + meetingBook);
        this.meetingBook = new MeetingBook();
    }

    @Override
    public void addMeeting(Meeting meeting) {
        meetingBook.addMeeting(meeting);
    }

    @Override
    public boolean hasMeeting(Meeting person) {
        requireNonNull(person);
        return meetingBook.hasMeeting(person);
    }

    @Override
    public MeetingBook getMeetingBook() {
        return meetingBook;
    }
}
