package seedu.address.logic;

import static java.util.Objects.requireNonNull;

import java.util.logging.Logger;

import seedu.address.commons.ModeEnum;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.mode.Command;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.mode.ModeParser;

/**
 * The main LogicManager of the app.
 */
public class LogicGeneralManager implements LogicGeneral {
    private final Logger logger = LogsCenter.getLogger(LogicGeneralManager.class);
    private final ModeParser modeParser;

    private final LogicPerson logicPerson;
    private final LogicDeliverable logicDeliverable;
    private final LogicMeeting logicMeeting;

    /**
     * Main Manager of the app.
     *
     * @param logicPerson
     * @param logicDeliverable
     * @param logicMeeting
     */
    public LogicGeneralManager(LogicPerson logicPerson, LogicDeliverable logicDeliverable, LogicMeeting logicMeeting) {
        this.modeParser = new ModeParser();
        this.logicPerson = logicPerson;
        this.logicDeliverable = logicDeliverable;
        this.logicMeeting = logicMeeting;
    }

    @Override
    public CommandResult execute(String commandText, ModeEnum mode) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult = null;

        // catch all general commands and pass to modeParser
        if (isModeCommand(commandText) || mode == ModeEnum.DASHBOARD) {
            Command command = modeParser.parseCommand(commandText);
            commandResult = command.execute();
        } else {
            switch (mode) {
            case PERSON:
                commandResult = logicPerson.execute(commandText);
                break;
            case DELIVERABLE:
                commandResult = logicDeliverable.execute(commandText);
                break;
            case MEETING:
                commandResult = logicMeeting.execute(commandText);
                break;
            default:
                assert false : "from default: " + ModeEnum.getModeOptions();
            }
        }

        requireNonNull(commandResult);

        return commandResult;
    }

    public boolean isModeCommand(String commandText) throws ParseException {
        return modeParser.isModeCommand(commandText);
    }

}
