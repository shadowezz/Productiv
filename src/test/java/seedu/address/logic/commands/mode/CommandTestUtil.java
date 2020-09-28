package seedu.address.logic.commands.mode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.person.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.person.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.person.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.person.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.person.CliSyntax.PREFIX_TAG;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.person.Command;
import seedu.address.logic.commands.person.EditCommand;
import seedu.address.model.ModelPerson;
import seedu.address.model.person.AddressBook;
import seedu.address.model.person.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.person.Person;
import seedu.address.testutil.EditPersonDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(seedu.address.logic.commands.mode.Command command,
                                            CommandResult expectedCommandResult) {
        CommandResult result = command.execute();
        assertEquals(expectedCommandResult, result);
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(seedu.address.logic.commands.mode.Command, CommandResult)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(seedu.address.logic.commands.mode.Command command,
                                            String expectedMessage) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, expectedCommandResult);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered person list and selected person in {@code actualModel} remain unchanged
     */
//    public static void assertCommandFailure(Command command, ModelPerson actualModelPerson, String expectedMessage) {
//        // we are unable to defensively copy the model for comparison later, so we can
//        // only do so by copying its components.
//        AddressBook expectedAddressBook = new AddressBook(actualModelPerson.getAddressBook());
//        List<Person> expectedFilteredList = new ArrayList<>(actualModelPerson.getFilteredPersonList());
//
//        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModelPerson));
//        assertEquals(expectedAddressBook, actualModelPerson.getAddressBook());
//        assertEquals(expectedFilteredList, actualModelPerson.getFilteredPersonList());
//    }

}
