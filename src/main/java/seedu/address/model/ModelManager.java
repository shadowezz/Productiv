package seedu.address.model;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.GuiSettings;

public abstract class ModelManager implements Model {
    protected UserPrefs userPrefs;

    /**
     * Initializes an abstract ModelManager with the given userPrefs.
     */
    public ModelManager(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs = new UserPrefs(userPrefs);
    }

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

}
