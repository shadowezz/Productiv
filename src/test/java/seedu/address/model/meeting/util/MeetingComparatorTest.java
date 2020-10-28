package seedu.address.model.meeting.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalMeetings.MEETING_A;
import static seedu.address.testutil.TypicalMeetings.MEETING_B;

import org.junit.jupiter.api.Test;


class MeetingComparatorTest {

    private MeetingComparator meetingComparator = new MeetingComparator();

    @Test
    void compare_nullMeeting_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> meetingComparator.compare(MEETING_A, null));

    }

    @Test
    void compare_success() {
        // MEETING_A < MEETING_B
        assertTrue(meetingComparator.compare(MEETING_A, MEETING_B) > 0);
        assertTrue(meetingComparator.compare(MEETING_B, MEETING_A) < 0);

        // Equal priority
        assertEquals(meetingComparator.compare(MEETING_A, MEETING_A), 0);

    }
}
