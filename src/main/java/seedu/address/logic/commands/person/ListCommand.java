package seedu.address.logic.commands.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.person.ModelPerson.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.person.ModelPerson;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all contacts";


    @Override
    public CommandResult execute(ModelPerson modelPerson) {
        requireNonNull(modelPerson);
        modelPerson.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
