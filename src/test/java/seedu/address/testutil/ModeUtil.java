package seedu.address.testutil;

import seedu.address.logic.commands.mode.SwitchCommand;
import seedu.address.ui.ModeEnum;

public class ModeUtil {

    /**
     * Returns an switch command string for changing the {@code mode}.
     */
    public static String getSwitchCommand(ModeEnum mode) {
        return SwitchCommand.COMMAND_WORD + " " + mode.toString().toLowerCase();
    }
}
