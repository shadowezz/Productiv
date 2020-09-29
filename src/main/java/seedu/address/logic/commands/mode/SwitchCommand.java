package seedu.address.logic.commands.mode;

import seedu.address.logic.commands.CommandResult;
import seedu.address.commons.ModeEnum;

public class SwitchCommand extends Command {

    public static final String COMMAND_WORD = "switch";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Switches mode. Parameters: deliverable or meeting or"
            + " "
            + "contact"
            + " \n"
            + "Example: " + COMMAND_WORD + " contact";
    public static final String MESSAGE_SUCCESS = "Mode switched to: %1$s";
    private final ModeEnum mode;

    public SwitchCommand(ModeEnum mode) {
        this.mode = mode;
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(String.format(MESSAGE_SUCCESS, mode));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SwitchCommand // instanceof handles nulls
                && mode.equals(((SwitchCommand) other).mode)); // state check
    }
}
