package seedu.address.logic;

import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.mode.Command;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.mode.ModeParser;
import seedu.address.ui.MainWindow;

/**
 * The main LogicManager of the app.
 */
public class LogicModeManager implements LogicMode {
    private final Logger logger = LogsCenter.getLogger(LogicModeManager.class);
    private final ModeParser modeParser;

    public LogicModeManager() {
        this.modeParser = new ModeParser();
    }

    public CommandResult execute(String commandText, MainWindow mainWindow) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = modeParser.parseCommand(commandText);
        commandResult = command.execute(mainWindow);

        return commandResult;
    }

    public boolean isSwitchCommand(String commandText) {
        return modeParser.isSwitchCommand(commandText);
    }

}
