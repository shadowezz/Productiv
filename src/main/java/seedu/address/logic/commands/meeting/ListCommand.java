package seedu.address.logic.commands.meeting;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.meeting.ModelMeeting.PREDICATE_SHOW_ALL_MEETINGS;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.meeting.ModelMeeting;

public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all meetings!";

    @Override
    public CommandResult execute(ModelMeeting modelMeeting) {
        requireNonNull(modelMeeting);
        modelMeeting.updateFilteredMeetingList(PREDICATE_SHOW_ALL_MEETINGS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
