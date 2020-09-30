package seedu.address.model;

import java.nio.file.Path;

import seedu.address.commons.core.GuiSettings;

/**
 * Unmodifiable view of user prefs of deliverables.
 * Not used.
 */
public interface ReadOnlyUserPrefsDeliverable {
    GuiSettings getGuiSettings();

    Path getDeliverableBookFilePath();
}
