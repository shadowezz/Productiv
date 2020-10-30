package seedu.address.model.meeting;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.model.Model;
import seedu.address.model.meeting.meeting.Meeting;

/**
 * The API of the Model component of Meeting.
 */
public interface ModelMeeting extends Model {
    Predicate<Meeting> PREDICATE_SHOW_ALL_MEETINGS = unused -> true;

    /**
     * Replaces deliverable book data with the data in {@code deliverableBook}.
     */
    void setMeetingBook(ReadOnlyMeetingBook deliverableBook);

    /** Returns the MeetingBook */
    ReadOnlyMeetingBook getMeetingBook();

    /** Returns the meeting currently in view. */
    Meeting getMeetingInView();

    /** Updates the meeting currently in view */
    void setMeetingInView(Meeting meetingInView);

    /**
     * Returns true if a deliverable with the same identity as {@code deliverable} exists in the deliverable book.
     */
    boolean hasMeeting(Meeting deliverable);

    /**
     * Deletes the given deliverable.
     * The deliverable must exist in the deliverable book.
     */
    void deleteMeeting(Meeting target);

    /**
     * Adds the given deliverable.
     * {@code deliverable} must not already exist in the deliverable book.
     */
    void addMeeting(Meeting deliverable);

    /**
     * Replaces the given deliverable {@code target} with {@code editedMeeting}.
     * {@code target} must exist in the deliverable book.
     * The deliverable identity of {@code editedMeeting} must not be the same as
     * another existing deliverable in the deliverable book.
     */
    void setMeeting(Meeting target, Meeting editedMeeting);

    /** Returns an unmodifiable view of the filtered deliverable list */
    ObservableList<Meeting> getFilteredMeetingList();

    /**
     * Updates the filter of the filtered deliverable list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredMeetingList(Predicate<Meeting> predicate);
}
