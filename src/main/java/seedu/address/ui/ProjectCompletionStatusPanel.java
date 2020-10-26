package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.deliverable.deliverable.Deliverable;

/**
 * Panel containing the expanded details of a deliverable.
 */
public class ProjectCompletionStatusPanel extends UiPart<Region> {
    private static final String FXML = "ProjectCompletionStatusPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ProjectCompletionStatusPanel.class);

    @FXML
    private Label deliverablesCompleted;

    /**
     * Creates a {@code ProjectCompetionStatusPanel} with the given {@code ObservableList<Deliverable>}
     */
    public ProjectCompletionStatusPanel(ObservableList<Deliverable> deliverableList) {
        super(FXML);
        deliverablesCompleted.setText("9 / 10 Completed");
        // TODO count no of completed / total
    }
}
