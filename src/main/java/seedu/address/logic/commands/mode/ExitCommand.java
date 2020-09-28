package seedu.address.logic.commands.mode;

import seedu.address.logic.commands.CommandResult;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting Address Book as requested ...";

    public CommandResult execute() {
        return new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, false, true, null);
    }

}
