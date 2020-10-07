package seedu.address.logic.commands.meeting;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.meeting.CliSyntax.PREFIX_CONTACTS;
import static seedu.address.logic.parser.meeting.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.meeting.CliSyntax.PREFIX_FROM;
import static seedu.address.logic.parser.meeting.CliSyntax.PREFIX_TITLE;
import static seedu.address.logic.parser.meeting.CliSyntax.PREFIX_TO;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.meeting.ModelMeeting;
import seedu.address.model.meeting.meeting.Meeting;

public class AddCommand extends Command {
    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a meeting to the meeting book."
            + "Parameters: "
            + PREFIX_TITLE + "NAME "
            + PREFIX_DESCRIPTION + "PHONE "
            + PREFIX_FROM + "EMAIL "
            + PREFIX_TO + "ADDRESS "
            + PREFIX_CONTACTS + "CONTACTS"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TITLE + "Discuss user requirements with biz associates "
            + PREFIX_DESCRIPTION + "Refer to the reviewed user stories during discussion "
            + PREFIX_FROM + "2020-12-31 12:00"
            + PREFIX_TO + "2020-12-31 14:00 "
            + PREFIX_CONTACTS + "1 3 5 ";

    public static final String MESSAGE_SUCCESS = "New meeting added: %1$s";
    public static final String MESSAGE_DUPLICATE_MEETING = "This meeting already exists in the meeting book";

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
        return other == this
                || (other instanceof AddCommand
                && toAdd.equals(((AddCommand) other).toAdd));
    }
}
