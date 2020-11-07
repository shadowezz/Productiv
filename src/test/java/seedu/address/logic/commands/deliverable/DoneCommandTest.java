package seedu.address.logic.commands.deliverable;


import static seedu.address.commons.core.Messages.MESSAGE_INVALID_DELIVERABLE_DISPLAYED_INDEX;
import static seedu.address.logic.commands.deliverable.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.deliverable.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.deliverable.DoneCommand.MESSAGE_DONE_DELIVERABLE_SUCCESS;
import static seedu.address.testutil.TypicalDeliverables.getTypicalDeliverableBook;
import static seedu.address.testutil.TypicalDeliverables.getTypicalDeliverables;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.model.UserPrefs;
import seedu.address.model.deliverable.ModelDeliverable;
import seedu.address.model.deliverable.ModelDeliverableManager;
import seedu.address.model.deliverable.deliverable.Deliverable;
import seedu.address.testutil.DeliverableBuilder;

public class DoneCommandTest {
    private ModelDeliverable modelDeliverable = new ModelDeliverableManager(
            getTypicalDeliverableBook(), new UserPrefs());

    @Test
    void execute_validIndexUnfilteredList_success() {
        Deliverable deliverableToComplete = getTypicalDeliverables().get(INDEX_FIRST.getZeroBased());
        Deliverable completedDeliverable = new DeliverableBuilder(deliverableToComplete).withIsComplete(true).build();
        DoneCommand doneCommand = new DoneCommand(INDEX_FIRST);

        String expectedMessage = String.format(MESSAGE_DONE_DELIVERABLE_SUCCESS, deliverableToComplete);

        ModelDeliverableManager expectedModel = new ModelDeliverableManager(
                modelDeliverable.getDeliverableBook(), new UserPrefs());
        expectedModel.updateDeliverableStatus(deliverableToComplete, completedDeliverable);

        assertCommandSuccess(doneCommand, modelDeliverable, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(modelDeliverable.getFilteredDeliverableList().size() + 1);
        DoneCommand doneCommand = new DoneCommand(outOfBoundIndex);

        assertCommandFailure(doneCommand, modelDeliverable, MESSAGE_INVALID_DELIVERABLE_DISPLAYED_INDEX);
    }

}
