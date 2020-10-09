package seedu.address.logic.commands.deliverable;

import java.util.Optional;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.model.deliverable.deliverable.Deadline;
import seedu.address.model.util.Description;
import seedu.address.model.util.Title;

/**
 * Stores the details to edit the deliverable with. Each non-empty field value will replace the
 * corresponding field value of the deliverable.
 */
public class EditDeliverableDescriptor {
    private Title title;
    private Description description;
    private Deadline deadline;
    private boolean isComplete;
    private String contacts;

    public EditDeliverableDescriptor() {}

    /**
     * Copy constructor.
     */
    public EditDeliverableDescriptor(EditDeliverableDescriptor toCopy) {
        setTitle(toCopy.title);
        setDescription(toCopy.description);
        setDeadline(toCopy.deadline);
        setContacts(toCopy.contacts);
        setIsComplete(toCopy.isComplete);
    }

    /**
     * Returns true if at least one field is edited.
     */
    public boolean isAnyFieldEdited() {
        return CollectionUtil.isAnyNonNull(title, description, deadline, contacts, isComplete);
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Optional<Title> getTitle() {
        return Optional.ofNullable(title);
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Optional<Description> getDescription() {
        return Optional.ofNullable(description);
    }

    public void setDeadline(Deadline deadline) {
        this.deadline = deadline;
    }

    public Optional<Deadline> getDeadline() {
        return Optional.ofNullable(deadline);
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Optional<String> getContacts() {
        return Optional.ofNullable(contacts);
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public Optional<Boolean> getCompletionStatus() {
        return Optional.ofNullable(isComplete);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditDeliverableDescriptor)) {
            return false;
        }

        // state check
        EditDeliverableDescriptor e = (EditDeliverableDescriptor) other;

        return getTitle().equals(e.getTitle())
                && getDescription().equals(e.getDescription())
                && getDeadline().equals(e.getDeadline())
                && getContacts().equals(e.getContacts())
                && getCompletionStatus().equals(e.getCompletionStatus());
    }
}
