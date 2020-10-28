package seedu.address.logic.commands.deliverable;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.deliverable.ModelDeliverable;

/**
 * Lists all deliverables in the deliverable book to the user.
 */
public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all deliverables";


    @Override
    public CommandResult execute(ModelDeliverable modelDeliverable) {
        requireNonNull(modelDeliverable);
        modelDeliverable.updateFilteredDeliverableList(ModelDeliverable.PREDICATE_SHOW_ALL_DELIVERABLES);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
