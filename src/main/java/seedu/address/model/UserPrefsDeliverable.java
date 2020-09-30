package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import seedu.address.commons.core.GuiSettings;

/**
 * Represents User's preferences of deliverables section.
 * Not used.
 */
public class UserPrefsDeliverable implements ReadOnlyUserPrefsDeliverable {

    private GuiSettings guiSettings = new GuiSettings();
    private Path deliverableBookFilePath = Paths.get("data" , "deliverablebook.json");

    /**
     * Creates a {@code UserPrefsDeliverable} with default values.
     */
    public UserPrefsDeliverable() {}

    /**
     * Creates a {@code UserPrefsDeliverable} with the prefs in {@code userPrefsDeliverable}.
     */
    public UserPrefsDeliverable(ReadOnlyUserPrefsDeliverable userPrefsDeliverable) {
        this();
        resetData(userPrefsDeliverable);
    }

    /**
     * Resets the existing data of this {@code UserPrefsDeliverable} with {@code newUserPrefsDeliverable}.
     */
    public void resetData(ReadOnlyUserPrefsDeliverable newUserPrefsDeliverable) {
        requireNonNull(newUserPrefsDeliverable);
        setGuiSettings(newUserPrefsDeliverable.getGuiSettings());
        setDeliverableBookFilePath(newUserPrefsDeliverable.getDeliverableBookFilePath());
    }
    @Override
    public GuiSettings getGuiSettings() {
        return guiSettings;
    }

    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        this.guiSettings = guiSettings;
    }

    @Override
    public Path getDeliverableBookFilePath() {
        return deliverableBookFilePath;
    }

    public void setDeliverableBookFilePath(Path deliverableBookFilePath) {
        requireNonNull(deliverableBookFilePath);
        this.deliverableBookFilePath = deliverableBookFilePath;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UserPrefsDeliverable)) { //this handles null as well.
            return false;
        }

        UserPrefsDeliverable o = (UserPrefsDeliverable) other;

        return guiSettings.equals(o.guiSettings)
                && deliverableBookFilePath.equals(o.deliverableBookFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, deliverableBookFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings);
        sb.append("\nLocal deliverable file location : " + deliverableBookFilePath);
        return sb.toString();
    }
}
