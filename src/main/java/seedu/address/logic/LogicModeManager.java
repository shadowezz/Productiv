package seedu.address.logic;

import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.mode.Command;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.mode.ModeParser;

/**
 * The main LogicManager of the app.
 */
public class LogicModeManager implements LogicMode {
    private final Logger logger = LogsCenter.getLogger(LogicModeManager.class);
    private final ModeParser modeParser;

    public LogicModeManager() {
        this.modeParser = new ModeParser();
    }

    @Override
    public CommandResult execute(String commandText) throws ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = modeParser.parseCommand(commandText);
        commandResult = command.execute();

        return commandResult;
    }

    public boolean isModeCommand(String commandText) {
        return modeParser.isModeCommand(commandText);
    }

}
