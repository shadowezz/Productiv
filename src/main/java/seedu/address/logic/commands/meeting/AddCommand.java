package seedu.address.logic.commands.meeting;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.meeting.ModelMeeting;
import seedu.address.model.meeting.meeting.Meeting;

public class AddCommand extends Command {
    public static final String COMMAND_WORD = "add";
    public static final String MESSAGE_DUPLICATE_MEETING = "This meeting already exists in the meeting book";
    public static final String MESSAGE_SUCCESS = "New meeting added: %1$s";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a meeting.";

    private final Meeting toAdd;

    /**
     * Creates a MeetingCommand to add the specified {@code Meeting}
     */
    public AddCommand(Meeting meeting) {
        requireNonNull(meeting);
        toAdd = meeting;
    }

    @Override
    public CommandResult execute(ModelMeeting modelMeeting) throws CommandException {
        requireNonNull(modelMeeting);

        if (modelMeeting.hasMeeting(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_MEETING);
        }

        modelMeeting.addMeeting(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && toAdd.equals(((AddCommand) other).toAdd));
    }
}
