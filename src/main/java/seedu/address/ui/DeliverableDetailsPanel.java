package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.deliverable.deliverable.Deliverable;

public class DeliverableDetailsPanel extends UiPart<Region> {
    private static final String FXML = "DeliverableDetailsPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(DeliverableDetailsPanel.class);

    @FXML
    private Label title;
    @FXML
    private Label milestone;
    @FXML
    private Label description;
    @FXML
    private Label deadline;
    @FXML
    private VBox contactList;
    @FXML
    private Label isCompleted;

    public DeliverableDetailsPanel(Deliverable deliverable) {
        super(FXML);
        assert deliverable != null;
        title.setText(deliverable.getTitle().value);
//        title.setWrapText(true);
        milestone.setText((deliverable.getMilestone().toString()));
        description.setText(deliverable.getDescription().toString());
//        description.setWrapText(true);
        deadline.setText(deliverable.getDeadline().value);
        deliverable.getContacts().value.ifPresentOrElse(contacts -> {
            for (String contact : contacts.split(",")) {
                contactList.getChildren().add(new Label("- " + contact));
            }
        }, () -> contactList.getChildren().add(new Label(deliverable.getContacts().toString())));

        if (deliverable.getIsComplete()) {
            isCompleted.setText("completed");
            isCompleted.setStyle("-fx-background-color: #32cd32");
        } else {
            isCompleted.setText("on-going");
            isCompleted.setStyle("-fx-background-color: #ffa500");
        }

    }
}
