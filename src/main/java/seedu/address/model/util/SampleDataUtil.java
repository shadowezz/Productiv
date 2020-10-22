package seedu.address.model.util;

import java.util.Optional;

import seedu.address.model.deliverable.DeliverableBook;
import seedu.address.model.deliverable.ReadOnlyDeliverableBook;
import seedu.address.model.deliverable.deliverable.Deadline;
import seedu.address.model.deliverable.deliverable.Deliverable;
import seedu.address.model.deliverable.deliverable.Milestone;
import seedu.address.model.meeting.MeetingBook;
import seedu.address.model.meeting.ReadOnlyMeetingBook;
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

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                    Role.getRole("stk"), new OptionalDescription("End user")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                    Role.getRole("dev"), new OptionalDescription("Frontend Engineer")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                    Role.getRole("stk"), new OptionalDescription("Business analyst")),
            new Person(new Name("David Li"), new Phone(Optional.empty()), new Email("lidavid@example.com"),
                    Role.getRole("dev"), new OptionalDescription("Backend Engineer")),
            new Person(new Name("Irfan Ibrahim"), new Phone(Optional.empty()), new Email("irfan@example.com"),
                    Role.getRole("stk"), new OptionalDescription(Optional.empty())),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                    Role.getRole("stk"), new OptionalDescription("End user"))
        };
    }

    public static Deliverable[] getSampleDeliverables() {
        return new Deliverable[] {
            new Deliverable(new Title("Settle login screens"), new Milestone("1.1"),
                new OptionalDescription("Include forget password option"),
                new Deadline("04-11-2020 15:00"), true, new Contacts("2,4")),
            new Deliverable(new Title("Settle profile page"), new Milestone("1.2"),
                new OptionalDescription("Include change password option"),
                new Deadline("15-11-2020 12:00"), true, new Contacts("1,2,3")),
            new Deliverable(new Title("Finalise v1.1 app design"), new Milestone("1.2.1"),
                new OptionalDescription("Include forget password option"),
                new Deadline("12-12-2020 23:59"), false, new Contacts("2,5")),
        };
    }

    public static Meeting[] getSampleMeetings() {
        return new Meeting[] {
            new Meeting(new Title("Meeting 1"), new OptionalDescription("With business associates"),
                new From("01-01-2020 12:00"),
                new To("01-01-2020 14:00"),
                new Contacts("1,2,3"),
                new Location("Singapore")),
            new Meeting(new Title("Meeting 2"), new OptionalDescription("With product designers"),
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

}
