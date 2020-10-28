package seedu.address.logic.commands.deliverable;


import static seedu.address.logic.commands.deliverable.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalDeliverables.getTypicalDeliverableBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.UserPrefs;
import seedu.address.model.deliverable.DeliverableBook;
import seedu.address.model.deliverable.ModelDeliverable;
import seedu.address.model.deliverable.ModelDeliverableManager;

public class ClearCommandTest {

    @Test
    public void execute_emptyDeliverableBook_success() {
        ModelDeliverable modelDeliverable = new ModelDeliverableManager();
        ModelDeliverable expectedModelDeliverable = new ModelDeliverableManager();

        assertCommandSuccess(
                new ClearCommand(), modelDeliverable, ClearCommand.MESSAGE_SUCCESS, expectedModelDeliverable);
    }

    @Test
    public void execute_nonEmptyDeliverableBook_success() {
        ModelDeliverable modelDeliverable = new ModelDeliverableManager(getTypicalDeliverableBook(), new UserPrefs());
        ModelDeliverable expectedModelDeliverable = new ModelDeliverableManager(
                getTypicalDeliverableBook(), new UserPrefs());
        expectedModelDeliverable.setDeliverableBook(new DeliverableBook());

        assertCommandSuccess(
                new ClearCommand(), modelDeliverable, ClearCommand.MESSAGE_SUCCESS, expectedModelDeliverable);
    }
}
