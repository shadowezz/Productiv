package seedu.address.logic.commands.mode;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.ui.MainWindow;
import seedu.address.ui.ModeEnum;

public class SwitchCommand extends Command {

    public static final String COMMAND_WORD = "switch";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Switches mode. Parameters: deliverable or meeting or" +
            " " +
            "contact" +
            " \n"
            + "Example: " + COMMAND_WORD + " contact";
    public static final String MESSAGE_SUCCESS = "Mode switched to: %1$s";
    private final ModeEnum mode;

    public SwitchCommand(ModeEnum mode) {
        this.mode = mode;
    }

    @Override
    public CommandResult execute(MainWindow mainWindow) throws CommandException {
        mainWindow.switchMode(mode);
        return new CommandResult(String.format(MESSAGE_SUCCESS, mode));
    }
}
