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
    public void execute_emptyAddressBook_success() {
        ModelDeliverable modelDeliverable = new ModelDeliverableManager();
        ModelDeliverable expectedModelPerson = new ModelDeliverableManager();

        assertCommandSuccess(new ClearCommand(), modelDeliverable, ClearCommand.MESSAGE_SUCCESS, expectedModelPerson);
    }

    @Test
    public void execute_nonEmptyAddressBook_success() {
        ModelDeliverable modelPerson = new ModelDeliverableManager(getTypicalDeliverableBook(), new UserPrefs());
        ModelDeliverable expectedModelPerson = new ModelDeliverableManager(
                getTypicalDeliverableBook(), new UserPrefs());
        expectedModelPerson.setDeliverableBook(new DeliverableBook());

        assertCommandSuccess(new ClearCommand(), modelPerson, ClearCommand.MESSAGE_SUCCESS, expectedModelPerson);
    }
}
