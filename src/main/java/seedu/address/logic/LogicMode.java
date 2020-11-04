package seedu.address.logic;

import seedu.address.commons.ModeEnum;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;

public interface LogicMode {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @param mode The current mode of the app.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText, ModeEnum mode) throws CommandException, ParseException;

    public boolean isModeCommand(String commandText);
}
