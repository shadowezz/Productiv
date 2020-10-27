package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.deliverable.deliverable.Deliverable;
import seedu.address.model.meeting.meeting.Meeting;

/**
 * Panel containing the list of persons.
 */
// TODO change to a calendar of meetings and deliverables
public class CalendarListPanel extends UiPart<Region> {
    private static final String FXML = "CalendarListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(CalendarListPanel.class);

    @FXML
    private ListView<Object> itemListView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public CalendarListPanel(ObservableList<Deliverable> deliverableList, ObservableList<Meeting> meetingList) {
        super(FXML);
        // this dosen't work cos calendar list currently not updated upon any edit to deliverables / meetings
        //        ObservableList<Object> calendarItems = FXCollections.observableArrayList();
        //        for (Deliverable d: logicDeliverable.getFilteredDeliverableList()) {
        //            calendarItems.add(d);
        //        }
        itemListView.setItems(FXCollections.observableArrayList());
        itemListView.setCellFactory(listView -> new ItemListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class ItemListViewCell extends ListCell<Object> {
        @Override
        protected void updateItem(Object obj, boolean empty) {
            super.updateItem(obj, empty);

            if (empty || obj == null) {
                setGraphic(null);
                setText(null);
            } else if (obj instanceof Deliverable) {
                setGraphic(new DeliverableCard((Deliverable) obj, getIndex() + 1).getRoot());
            } else if (obj instanceof Meeting) {
                setGraphic(new MeetingCard((Meeting) obj, getIndex() + 1).getRoot());
            }
        }
    }

}
