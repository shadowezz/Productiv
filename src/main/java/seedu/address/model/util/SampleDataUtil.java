package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.deliverable.DeliverableBook;
import seedu.address.model.deliverable.ReadOnlyDeliverableBook;
import seedu.address.model.deliverable.deliverable.Deadline;
import seedu.address.model.deliverable.deliverable.Deliverable;
import seedu.address.model.meeting.MeetingBook;
import seedu.address.model.meeting.ReadOnlyMeetingBook;
import seedu.address.model.meeting.meeting.Contacts;
import seedu.address.model.meeting.meeting.From;
import seedu.address.model.meeting.meeting.Location;
import seedu.address.model.meeting.meeting.Meeting;
import seedu.address.model.meeting.meeting.To;
import seedu.address.model.person.AddressBook;
import seedu.address.model.person.ReadOnlyAddressBook;
import seedu.address.model.person.person.Email;
import seedu.address.model.person.person.Name;
import seedu.address.model.person.person.Person;
import seedu.address.model.person.person.Phone;
import seedu.address.model.person.person.Role;
import seedu.address.model.person.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                    getTagSet("friends"), Role.getRole("stk"), new Description("End user")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                    getTagSet("colleagues", "friends"), Role.getRole("stk"), new Description("End user")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                    getTagSet("neighbours"), Role.getRole("stk"), new Description("End user")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                    getTagSet("family"), Role.getRole("stk"), new Description("End user")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                    getTagSet("classmates"), Role.getRole("stk"), new Description("End user")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                    getTagSet("colleagues"), Role.getRole("stk"), new Description("End user"))
        };
    }

    public static Deliverable[] getSampleDeliverables() {
        return new Deliverable[] {
            new Deliverable(new Title("Settle login screens"), new Description("Include forget password option"),
                new Deadline("04-11-2020 15:00"), true, "2,4"),
            new Deliverable(new Title("Settle profile page"), new Description("Include change password option"),
                new Deadline("15-11-2020 12:00"), true, "1,2,3"),
            new Deliverable(new Title("Finalise v1.1 app design"), new Description("Include forget password option"),
                new Deadline("12-12-2020 23:59"), false, "2,5"),
        };
    }

    public static Meeting[] getSampleMeetings() {
        return new Meeting[] {
            new Meeting(new Title("Meeting 1"), new Description("With business associates"),
                new From("01-01-2020 12:00"),
                new To("01-01-2020 14:00"),
                new Contacts("1,2,3"),
                new Location("Singapore")),
            new Meeting(new Title("Meeting 2"), new Description("With product designers"),
                new From("02-01-2020 12:00"),
                new To("02-01-2020 14:00"),
                new Contacts("4,5,6"),
                new Location("Jakarta"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    public static ReadOnlyDeliverableBook getSampleDeliverableBook() {
        DeliverableBook sampleDb = new DeliverableBook();
        for (Deliverable sampleDeliverable : getSampleDeliverables()) {
            sampleDb.addDeliverable(sampleDeliverable);
        }
        return sampleDb;
    }

    public static ReadOnlyMeetingBook getSampleMeetingBook() {
        MeetingBook sampleMb = new MeetingBook();
        for (Meeting sampleMeeting : getSampleMeetings()) {
            sampleMb.addMeeting(sampleMeeting);
        }
        return sampleMb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
