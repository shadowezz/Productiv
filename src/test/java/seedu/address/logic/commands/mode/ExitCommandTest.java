package seedu.address.logic.commands.mode;

import static seedu.address.logic.commands.mode.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.mode.ExitCommand.MESSAGE_EXIT_ACKNOWLEDGEMENT;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.CommandResult;

public class ExitCommandTest {

    @Test
    public void execute_exit_success() {
        CommandResult expectedCommandResult = new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, false, true, null);
        assertCommandSuccess(new ExitCommand(), expectedCommandResult);
    }
}
