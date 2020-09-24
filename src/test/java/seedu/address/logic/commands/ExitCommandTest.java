package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.ExitCommand.MESSAGE_EXIT_ACKNOWLEDGEMENT;

import org.junit.jupiter.api.Test;

import seedu.address.model.ModelPerson;
import seedu.address.model.ModelPersonManager;

public class ExitCommandTest {
    private ModelPerson modelPerson = new ModelPersonManager();
    private ModelPerson expectedModelPerson = new ModelPersonManager();

    @Test
    public void execute_exit_success() {
        CommandResult expectedCommandResult = new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, false, true);
        assertCommandSuccess(new ExitCommand(), modelPerson, expectedCommandResult, expectedModelPerson);
    }
}
