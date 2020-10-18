package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.deliverable.deliverable.Deliverable;

public class DeliverableDetailsPanel extends UiPart<Region> {
    private static final String FXML = "DeliverableDetailsPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(DeliverableDetailsPanel.class);

    @FXML
    private Label title;
    @FXML
    private Label description;
    @FXML
    private Label deadline;
    @FXML
    private Label contact;

    public DeliverableDetailsPanel(Deliverable deliverable) {
        super(FXML);
        if (deliverable == null) {
            return;
        }
        title.setText(deliverable.getTitle().value);
        description.setText(deliverable.getDescription().value);
        deadline.setText(deliverable.getDeadline().value);
        contact.setText(deliverable.getContacts());

    }

    public DeliverableDetailsPanel() {
        super(FXML);
    }
}
