package seedu.address.logic.commands.mode;

import static seedu.address.logic.commands.mode.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.mode.HelpCommand.SHOWING_HELP_MESSAGE;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.CommandResult;

public class HelpCommandTest {

    @Test
    public void execute_help_success() {
        CommandResult expectedCommandResult = new CommandResult(SHOWING_HELP_MESSAGE, true, false, null);
        assertCommandSuccess(new HelpCommand(), expectedCommandResult);
    }
}
