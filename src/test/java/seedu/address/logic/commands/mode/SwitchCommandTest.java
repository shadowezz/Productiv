package seedu.address.logic.commands.mode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.mode.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.commons.ModeEnum;
import seedu.address.logic.commands.CommandResult;

public class SwitchCommandTest {

    @Test
    public void execute_validMode_success() {
        SwitchCommand switchCommand = new SwitchCommand(ModeEnum.PERSON);
        String expectedMessage = String.format(SwitchCommand.MESSAGE_SUCCESS, ModeEnum.PERSON);
        assertCommandSuccess(switchCommand, new CommandResult(expectedMessage, false, false, ModeEnum.PERSON));
        // TODO add more modes here
    }

    @Test
    public void equals() {
        SwitchCommand switchFirstCommand = new SwitchCommand(ModeEnum.PERSON);
        SwitchCommand switchSecondCommand = new SwitchCommand(ModeEnum.DELIVERABLE);

        // same object -> returns true
        assertTrue(switchFirstCommand.equals(switchFirstCommand));

        // same values -> returns true
        SwitchCommand switchFirstCommandCopy = new SwitchCommand(ModeEnum.PERSON);
        assertTrue(switchFirstCommand.equals(switchFirstCommandCopy));

        // different types -> returns false
        assertFalse(switchFirstCommand.equals(1));

        // null -> returns false
        assertFalse(switchFirstCommand.equals(null));

        // different mode -> returns false
        assertFalse(switchFirstCommand.equals(switchSecondCommand));
    }
}
