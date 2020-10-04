package seedu.address.logic.commands.meeting;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.meeting.ModelMeeting;
import seedu.address.model.meeting.meeting.Meeting;

/**
 * Deletes a meeting given the specified index.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";
    public static final String MESSAGE_DELETE_MEETING_SUCCESS = "Meeting Deleted: %1$s";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes a meeting.";
    public static final String MESSAGE_MEETING_DISPLAYED_INDEX = "The meeting index provided is invalid";

    private final Index targetIndex;

    /**
     * Construct command given index of meeting to delete.
     * @param targetIndex specified index of meeting to delete.
     */
    public DeleteCommand(Index targetIndex) {
        requireNonNull(targetIndex);
        this.targetIndex = targetIndex;
    }


    @Override
    public CommandResult execute(ModelMeeting modelMeeting) throws CommandException {
        requireNonNull(modelMeeting);
        //TODO: Add getFilteredMeetingList
        //List<Meeting> lastShownList = modelMeeting.getFilteredMeetingList();
        List<Meeting> lastShownList = new ArrayList<Meeting>();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(MESSAGE_MEETING_DISPLAYED_INDEX);
        }

        Meeting meetingToDelete = lastShownList.get(targetIndex.getZeroBased());
        //TODO: Add deleteMeeting method here.
        //modelMeeting.deleteMeeting(meetingToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_MEETING_SUCCESS, meetingToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommand) // instanceof handles nulls
                && targetIndex.equals(((DeleteCommand) other).targetIndex);
    }
}
