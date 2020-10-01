package seedu.address.logic.commands.deliverable;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.deliverable.CliSyntax.PREFIX_NUMBER;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ModelDeliverable;
import seedu.address.model.deliverable.deliverable.Deliverable;

/**
 * Adds a deliverable to the address book.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a deliverable to the deliverable book. "
            + "Parameters: "
            + PREFIX_NUMBER + "NUMBER ";
    public static final String MESSAGE_SUCCESS = "New deliverable added: %1$s";
    public static final String MESSAGE_DUPLICATE_DELIVERABLE =
            "This deliverable already exists in the deliverable book";

    private final Deliverable toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Deliverable}
     */
    public AddCommand(Deliverable deliverable) {
        requireNonNull(deliverable);
        toAdd = deliverable;
    }

    @Override
    public CommandResult execute(ModelDeliverable modelDeliverable) throws CommandException {
        requireNonNull(modelDeliverable);

        if (modelDeliverable.hasDeliverable(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_DELIVERABLE);
        }

        modelDeliverable.addDeliverable(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && toAdd.equals(((AddCommand) other).toAdd));
    }
}
