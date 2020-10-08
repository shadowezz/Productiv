package seedu.address.testutil;

import static seedu.address.logic.parser.deliverable.CliSyntax.PREFIX_CONTACTS;
import static seedu.address.logic.parser.deliverable.CliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.deliverable.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.deliverable.CliSyntax.PREFIX_TITLE;

import seedu.address.logic.commands.person.AddCommand;
import seedu.address.model.deliverable.deliverable.Deliverable;

/**
 * A utility class for Deliverable.
 */
public class DeliverableUtil {

    /**
     * Returns an add command string for adding the {@code deliverable}.
     */
    public static String getAddCommand(Deliverable deliverable) {
        return AddCommand.COMMAND_WORD + " " + getDeliverableDetails(deliverable);
    }

    /**
     * Returns the part of command string for the given {@code deliverable}'s details.
     */
    public static String getDeliverableDetails(Deliverable deliverable) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_TITLE + deliverable.getTitle().title + " ");
        sb.append(PREFIX_DESCRIPTION + deliverable.getDescription().value + " ");
        sb.append(PREFIX_DEADLINE + deliverable.getDeadline().value + " ");
        sb.append(PREFIX_CONTACTS + deliverable.getContacts());
        return sb.toString();
    }

    // TODO
    /**
     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
     */
    public static String getEditDeliverableDescriptorDetails() {
        return null;
    }
}
