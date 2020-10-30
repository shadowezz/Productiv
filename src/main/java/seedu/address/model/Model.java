package seedu.address.model;

import java.nio.file.Path;

import seedu.address.commons.core.GuiSettings;

public interface Model {
    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' specified book file path.
     */
    Path getBookFilePath();

    /**
     * Sets the user prefs' specified book file path.
     */
    void setBookFilePath(Path bookFilePath);

}
