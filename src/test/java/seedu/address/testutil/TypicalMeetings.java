package seedu.address.testutil;

import static seedu.address.logic.commands.meeting.CommandTestUtil.VALID_CONTACTS_A;
import static seedu.address.logic.commands.meeting.CommandTestUtil.VALID_CONTACTS_B;
import static seedu.address.logic.commands.meeting.CommandTestUtil.VALID_DESCRIPTION_A;
import static seedu.address.logic.commands.meeting.CommandTestUtil.VALID_DESCRIPTION_B;
import static seedu.address.logic.commands.meeting.CommandTestUtil.VALID_FROM_A;
import static seedu.address.logic.commands.meeting.CommandTestUtil.VALID_FROM_B;
import static seedu.address.logic.commands.meeting.CommandTestUtil.VALID_LOCATION_A;
import static seedu.address.logic.commands.meeting.CommandTestUtil.VALID_LOCATION_B;
import static seedu.address.logic.commands.meeting.CommandTestUtil.VALID_TITLE_A;
import static seedu.address.logic.commands.meeting.CommandTestUtil.VALID_TITLE_B;
import static seedu.address.logic.commands.meeting.CommandTestUtil.VALID_TO_A;
import static seedu.address.logic.commands.meeting.CommandTestUtil.VALID_TO_B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import seedu.address.model.meeting.MeetingBook;
import seedu.address.model.meeting.meeting.Contacts;
import seedu.address.model.meeting.meeting.From;
import seedu.address.model.meeting.meeting.Location;
import seedu.address.model.meeting.meeting.Meeting;
import seedu.address.model.meeting.meeting.To;
import seedu.address.model.util.OptionalDescription;
import seedu.address.model.util.Title;

public class TypicalMeetings {

    public static final String TITLE_C = "Final";
    public static final Optional<String> DESCRIPTION_C = Optional.of("Discuss final features");
    public static final String FROM_C = "12-12-2020 08:00";
    public static final String TO_C = "12-12-2020 10:00";
    public static final Optional<String> CONTACTS_C = Optional.of("3,2,1");
    public static final Optional<String> LOCATION_C = Optional.of("Somewhere");

    public static final String TITLE_D = "Mid v1.2";
    public static final Optional<String> DESCRIPTION_D = Optional.of("Discuss features");
    public static final String FROM_D = "12-24-2020 08:00";
    public static final String TO_D = "12-24-2020 08:00";
    public static final Optional<String> CONTACTS_D = Optional.of("6,7,8");
    public static final Optional<String> LOCATION_D = Optional.of("Somewhere");

    //    public static final String TITLE_E = "Mid v1.2";
    //    public static final String DESCRIPTION_E = "NIL";
    //    public static final String FROM_E = "12-24-2020 08:00";
    //    public static final String TO_E = "NIL";
    //    public static final String CONTACTS_E = "NIL";
    //    public static final String LOCATION_E = "NIL";

    public static final Meeting MEETING_A =
            new Meeting(new Title(VALID_TITLE_A), new OptionalDescription(VALID_DESCRIPTION_A), new From(VALID_FROM_A),
                    new To(VALID_TO_A), new Contacts(VALID_CONTACTS_A), new Location(VALID_LOCATION_A));

    public static final Meeting MEETING_B =
            new Meeting(new Title(VALID_TITLE_B), new OptionalDescription(VALID_DESCRIPTION_B), new From(VALID_FROM_B),
                    new To(VALID_TO_B), new Contacts(VALID_CONTACTS_B), new Location(VALID_LOCATION_B));

    public static final Meeting MEETING_C =
            new Meeting(new Title(TITLE_C), new OptionalDescription(DESCRIPTION_C), new From(FROM_C),
                    new To(TO_C), new Contacts(CONTACTS_C), new Location(LOCATION_C));

    public static final Meeting MEETING_D =
            new Meeting(new Title(TITLE_D), new OptionalDescription(DESCRIPTION_D), new From(FROM_D), new To(TO_D),
                    new Contacts(CONTACTS_D), new Location(LOCATION_D));

    //    public static final Meeting MEETING_E =
    //            new Meeting(new Title(TITLE_E), new Description(DESCRIPTION_E), new From(FROM_E), new To(TO_E),
    //                    new Contacts(CONTACTS_E), new Location(LOCATION_E));



    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static MeetingBook getTypicalMeetingBook() {
        MeetingBook ab = new MeetingBook();
        for (Meeting meeting : getTypicalMeeting()) {
            ab.addMeeting(meeting);
        }
        return ab;
    }

    public static List<Meeting> getTypicalMeeting() {
        return new ArrayList<>(Arrays.asList(MEETING_A, MEETING_B));
    }
}
