package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class DateTimeTest {

    public static final String VALID_SAMPLE_A = "30-11-2020 10:00";
    public static final String VALID_SAMPLE_B = "31-11-2020 23:00";

    @Test
    void isValidDateTimeSuccess() {
        // Date and Time
        assertTrue(DateTime.isValidDateTime(VALID_SAMPLE_A));
    }


    @Test
    void parseSuccess() {
        DateTime dt = new DateTime(VALID_SAMPLE_A);
        assertEquals(VALID_SAMPLE_A, dt.toString());

    }

    @Test
    void resolveOverflowParseSuccess() {

        DateTime resolveA = new DateTime(VALID_SAMPLE_B);
        assertEquals("30-11-2020 23:00", resolveA.toString());
    }

    @Test
    void compareSuccess() {
        DateTime a = new DateTime(VALID_SAMPLE_A);
        DateTime b = new DateTime(VALID_SAMPLE_B);
        assertEquals(a.compareTo(b), -1);
        assertEquals(a.compareTo(a), 0);
    }
}
