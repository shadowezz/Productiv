package seedu.address.model.calendar;

import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.deliverable.deliverable.Deliverable;
import seedu.address.model.event.TimeEvent;
import seedu.address.model.meeting.meeting.Meeting;
import seedu.address.model.meeting.util.TimeEventComparator;

public class Calendar {
    private ObservableList<Meeting> meetings;
    private ObservableList<Deliverable> deliverables;
    private ObservableList<TimeEvent> calendarList;
    private static TimeEventComparator timeEventComparator = new TimeEventComparator();

    public Calendar(ObservableList<Deliverable> deliverables, ObservableList<Meeting> meetings) {
        this.deliverables = deliverables;
        this.meetings = meetings;
        this.calendarList = FXCollections.observableArrayList();
        updateCalendarList();
    }

    public void updateCalendarList() {
        this.calendarList.clear();
        this.calendarList.addAll(meetings);
        this.calendarList.addAll(deliverables);
        Collections.sort(calendarList, timeEventComparator);
    }

    public ObservableList<TimeEvent> getTimeEvents() {
        return this.calendarList;
    }
}
