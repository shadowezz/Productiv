package seedu.address.logic;

import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.deliverable.deliverable.Deliverable;


/**
 * Logic manager for deliverables
 */
public class LogicDeliverableManager implements LogicDeliverable {

    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicDeliverableManager.class);

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        return null;
    }

    @Override
    public ReadOnlyAddressBook getMeetingBook() {
        return null;
    }

    @Override
    public ObservableList<Deliverable> getFilteredDeliverableList() {
        return null;
    }

    @Override
    public Path getMeetingBookFilePath() {
        return null;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return null;
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {

    }
}
