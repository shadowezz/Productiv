package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.deliverable.deliverable.Deliverable;

/**
 * An UI component that displays information of a {@code Deliverable}.
 */
public class DeliverableCard extends UiPart<Region> {

    private static final String FXML = "DeliverableListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Deliverable deliverable;

    @FXML
    private HBox cardPane;
    @FXML
    private Label title;
    @FXML
    private Label id;
    @FXML
    private Label description;
    @FXML
    private Label deadline;
    @FXML
    private Label contacts;
    @FXML
    private Label isCompleted;

    /**
     * Creates a {@code DeliverableCode} with the given {@code Deliverable} and index to display.
     */
    public DeliverableCard(Deliverable deliverable, int displayedIndex) {
        super(FXML);
        this.deliverable = deliverable;
        id.setText(displayedIndex + ". ");
        title.setText(deliverable.getTitle().value);
        description.setText("Description: " + deliverable.getDescription().value);
        deadline.setText("Deadline: " + deliverable.getDeadline().value);
        contacts.setText("Contacts: " + deliverable.getContacts());
        isCompleted.setText("Completion status: " + deliverable.getCompletionStatus());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeliverableCard)) {
            return false;
        }

        // state check
        DeliverableCard card = (DeliverableCard) other;
        return id.getText().equals(card.id.getText())
                && deliverable.equals(card.deliverable);
    }
}
