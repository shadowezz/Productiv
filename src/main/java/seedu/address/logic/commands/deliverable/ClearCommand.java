package seedu.address.logic.commands.deliverable;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.deliverable.DeliverableBook;
import seedu.address.model.deliverable.ModelDeliverable;

/**
 * Clears the deliverable book.
 */
public class ClearCommand extends Command {
    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Deliverable list has been cleared!";


    @Override
    public CommandResult execute(ModelDeliverable modelDeliverable) {
        requireNonNull(modelDeliverable);
        modelDeliverable.setDeliverableBook(new DeliverableBook());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
