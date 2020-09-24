package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.HelpCommand.SHOWING_HELP_MESSAGE;

import org.junit.jupiter.api.Test;

import seedu.address.model.ModelPerson;
import seedu.address.model.ModelPersonManager;

public class HelpCommandTest {
    private ModelPerson modelPerson = new ModelPersonManager();
    private ModelPerson expectedModelPerson = new ModelPersonManager();

    @Test
    public void execute_help_success() {
        CommandResult expectedCommandResult = new CommandResult(SHOWING_HELP_MESSAGE, true, false);
        assertCommandSuccess(new HelpCommand(), modelPerson, expectedCommandResult, expectedModelPerson);
    }
}
