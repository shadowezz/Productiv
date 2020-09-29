package seedu.address.logic;

import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.meeting.Command;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.meeting.MeetingBookParser;
import seedu.address.model.ModelMeeting;
import seedu.address.storage.StorageMeeting;

/**
 * Manages the logic for the meeting feature.
 */
public class LogicMeetingManager implements LogicMeeting {
    // public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicMeetingManager.class);

    private final ModelMeeting modelMeeting;
    private final StorageMeeting storageMeeting;
    private final MeetingBookParser meetingParser;
    // TODO: Add storage

    /**
     * Constructs a {@code LogicMeetingManager} with the given {@code ModelMeeting} and {@code Storage}.
     */
    public LogicMeetingManager(ModelMeeting modelMeeting, StorageMeeting storageMeeting) {
        this.modelMeeting = modelMeeting;
        this.storageMeeting = storageMeeting;
        this.meetingParser = new MeetingBookParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = meetingParser.parseCommand(commandText);
        commandResult = command.execute(modelMeeting);

        //try {
        //    storageMeeting.saveAddressBook(modelMeeting.getMeetingBook());
        // } catch (IOException ioe) {
        //    throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        // }

        return commandResult;
    }

    public boolean isMeetingCommand(String commandText) {
        return meetingParser.isMeetingCommand(commandText);
    }

}
