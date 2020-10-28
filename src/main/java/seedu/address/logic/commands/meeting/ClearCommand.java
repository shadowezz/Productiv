package seedu.address.logic.commands.meeting;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.meeting.MeetingBook;
import seedu.address.model.meeting.ModelMeeting;

/**
 * Clears the meeting book.
 */
public class ClearCommand extends Command {
    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Meeting book has been cleared!";


    @Override
    public CommandResult execute(ModelMeeting modelMeeting) {
        requireNonNull(modelMeeting);
        modelMeeting.setMeetingBook(new MeetingBook());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}