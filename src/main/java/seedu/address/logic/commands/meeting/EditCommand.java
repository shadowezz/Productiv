package seedu.address.logic.commands.meeting;

import static java.util.Objects.requireNonNull;
//import static seedu.address.logic.parser.meeting.CliSyntax.PREFIX_TITLE;
//import static seedu.address.logic.parser.meeting.CliSyntax.PREFIX_DESCRIPTION;
//import static seedu.address.logic.parser.meeting.CliSyntax.PREFIX_FROM;
//import static seedu.address.logic.parser.meeting.CliSyntax.PREFIX_FROM;
//import static seedu.address.logic.parser.meeting.CliSyntax.PREFIX_TO;
//import static seedu.address.logic.parser.meeting.CliSyntax.PREFIX_CONTACTS;

//import java.util.Collections;
//import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.meeting.ModelMeeting;
import seedu.address.model.meeting.meeting.Contacts;
import seedu.address.model.meeting.meeting.From;
import seedu.address.model.meeting.meeting.Location;
import seedu.address.model.meeting.meeting.Meeting;
import seedu.address.model.meeting.meeting.To;
import seedu.address.model.util.Description;
import seedu.address.model.util.Title;


public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the meeting.";


    public static final String MESSAGE_EDIT_MEETING_SUCCESS = "Edited Person: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_MEETING = "This person already exists in the address book.";
    public static final String MESSAGE_INVALID_MEETING_DISPLAYED_INDEX = "Invalid Meeting index.";


    private final Index targetIndex;
    private final EditMeetingDescriptor editMeetingDescriptor;

    /**
     * @param index                 of the person in the filtered person list to edit
     * @param editMeetingDescriptor details to edit the person with
     */
    public EditCommand(Index index, EditMeetingDescriptor editMeetingDescriptor) {
        requireNonNull(index);
        requireNonNull(editMeetingDescriptor);

        this.targetIndex = index;
        this.editMeetingDescriptor = new EditMeetingDescriptor(editMeetingDescriptor);
    }

    @Override
    public CommandResult execute(ModelMeeting modelMeeting) throws CommandException {
        requireNonNull(modelMeeting);

        //TODO: Add getFilteredMeetingList
        //List<Meeting> lastShownList = modelMeeting.getFilteredMeetingList();
        List<Meeting> lastShownList = new ArrayList<Meeting>();
        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(MESSAGE_INVALID_MEETING_DISPLAYED_INDEX);
        }

        Meeting meetingToEdit = lastShownList.get(targetIndex.getZeroBased());
        Meeting editedMeeting = createEditedMeeting(meetingToEdit, editMeetingDescriptor);

        //TODO: throw exception if meetingToEdit.isSameMeeting(editedMeeting) makes no changes
        if (modelMeeting.hasMeeting(editedMeeting)) {
            throw new CommandException(MESSAGE_DUPLICATE_MEETING);
        }

        //TODO: implement setMeeting and updateFilteredMeetingList
        //modelMeeting.setMeeting(meetingToEdit, editedMeeting);
        //modelMeeting.updateFilteredMeetingList(PREDICATE_SHOW_ALL_Meeting);


        return new CommandResult(String.format(MESSAGE_EDIT_MEETING_SUCCESS, editedMeeting));
    }

    private static Meeting createEditedMeeting(Meeting meetingToEdit, EditMeetingDescriptor editMeetingDescriptor) {
        assert meetingToEdit != null;

        // String updatedTitle = editMeetingDescriptor.getTitle().orElse(meetingToEdit.getTitle());
        // String updatedDesc = editMeetingDescriptor.getDescription().orElse(meetingToEdit.getDescription());
        // String updatedFrom = editMeetingDescriptor.getFrom().orElse(meetingToEdit.getFrom());
        // String updatedTo = editMeetingDescriptor.getTo().orElse(meetingToEdit.getTo());
        // String updatedContacts = editMeetingDescriptor.getContacts().orElse(meetingToEdit.getContacts());
        // String updatedLocation = editMeetingDescriptor.getLocation().orElse(meetingToEdit.getLocation());

        // return new Meeting(updatedTitle, updatedDesc, updatedFrom, updatedTo, updatedContacts, updatedLocation);
        return new Meeting(new Title("A"), new Description("B"), new From("2"),
                new To("3"), new Contacts("1,2,3"), new Location("SG"));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditCommand)) {
            return false;
        }

        // state check
        EditCommand e = (EditCommand) other;
        return targetIndex.equals(e.targetIndex)
                && editMeetingDescriptor.equals(e.editMeetingDescriptor);
    }

    /**
     *
     */
    public static class EditMeetingDescriptor {
        private String title;
        private String description;
        private String from;
        private String to;
        private String contacts;
        private String location;

        public EditMeetingDescriptor() {
        }

        /**
         * Copy attributes from meeting to be edited.
         * @param toCopy meeting to be edited.
         */
        public EditMeetingDescriptor(EditMeetingDescriptor toCopy) {
            setTitle(toCopy.title);
            setDescription(toCopy.description);
            setFrom(toCopy.from);
            setTo(toCopy.to);
            setContacts(toCopy.contacts);
            setLocation(toCopy.location);
        }

        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(title, description, from, to, contacts, location);
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Optional<String> getTitle() {
            return Optional.ofNullable(this.title);
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Optional<String> getDescription() {
            return Optional.ofNullable(this.description);
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public Optional<String> getFrom() {
            return Optional.ofNullable(this.from);
        }

        public void setTo(String to) {
            this.to = to;
        }

        public Optional<String> getTo() {
            return Optional.ofNullable(this.to);
        }

        public void setContacts(String contact) {
            this.contacts = contact;
        }

        public Optional<String> getContacts() {
            return Optional.ofNullable(this.contacts);
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Optional<String> getLocation() {
            return Optional.ofNullable(this.location);
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditMeetingDescriptor)) {
                return false;
            }

            // state check
            EditMeetingDescriptor e = (EditMeetingDescriptor) other;

            return getTitle().equals(e.getTitle())
                    && getDescription().equals(e.getDescription())
                    && getFrom().equals(e.getFrom())
                    && getTo().equals(e.getTo())
                    && getContacts().equals(e.getContacts())
                    && getLocation().equals(e.getLocation());
        }

    }
}
