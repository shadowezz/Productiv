package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.model.deliverable.deliverable.Deliverable;

/**
 * Panel containing the expanded details of a deliverable.
 */
public class ProjectCompletionStatusPanel extends UiPart<Region> {
    private static final String FXML = "ProjectCompletionStatusPanel.fxml";
    private ObservableList<Deliverable> deliverableList;
    private int totalNumDeliverables;
    private int numCompletedDeliverables;
    private int overallCompletionPercentage;

    @FXML
    private StackPane ocpDiagram;

    @FXML
    private Label ocpCaption;

    /**
     * Creates a {@code ProjectCompletionStatusPanel} with the given {@code ObservableList<Deliverable>}
     */
    public ProjectCompletionStatusPanel(ObservableList<Deliverable> deliverableList) {
        super(FXML);
        this.deliverableList = deliverableList;
        updateOcp();
    }

    private int findNumCompletedDeliverables(ObservableList<Deliverable> deliverableList) {
        int numCompletedDeliverables = 0;
        for (Deliverable deliverable : deliverableList) {
            if (deliverable.getIsComplete()) {
                numCompletedDeliverables++;
            }
        }
        return numCompletedDeliverables;
    }

    private int getOcp(int totalNumDeliverables, int numCompletedDeliverables) {
        return totalNumDeliverables == 0
                ? 0
                : (int) ((double) numCompletedDeliverables / (double) totalNumDeliverables * 100);
    }

    /**
     * Updates OCP for every Deliverable command execution.
     */
    public void updateOcp() {
        totalNumDeliverables = deliverableList.size();
        numCompletedDeliverables = findNumCompletedDeliverables(deliverableList);
        overallCompletionPercentage = getOcp(totalNumDeliverables, numCompletedDeliverables);

        RingProgressIndicator ringProgressIndicator = new RingProgressIndicator();
        ringProgressIndicator.setProgress(overallCompletionPercentage);
        ocpDiagram.getChildren().add(ringProgressIndicator);

        String caption = numCompletedDeliverables + " / " + totalNumDeliverables + " Deliverables Completed";
        ocpCaption.setText(caption);
    }
}
