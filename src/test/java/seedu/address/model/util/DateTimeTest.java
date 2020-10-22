package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DateTimeTest {

    public static final String VALID_SAMPLE_A = "30-11-9999 10:00";
    public static final String VALID_SAMPLE_B = "28-02-0001 10:00";
    public static final String VALID_SAMPLE_C = "29-02-1996 10:01";
    public static final String INVALID_SAMPLE_A = "01-1-2020 23:59";
    public static final String INVALID_SAMPLE_B = "01-01-2020";
    public static final String INVALID_SAMPLE_C = "29-02-2019 23:00:59";
    public static final String INVALID_SAMPLE_D = "31-11-2020 23:00";
    public static final String INVALID_SAMPLE_E = "29-02-2019 23:00";


    @Test
    void isValidDateTimeSuccess() {
        // Date and Time
        assertTrue(DateTime.isValidDateTimePattern(VALID_SAMPLE_A));
        assertTrue(DateTime.isValidDateTimePattern(VALID_SAMPLE_B));
        assertTrue(DateTime.isValidDateTimePattern(VALID_SAMPLE_C));
    }


    @Test
    void parseSuccess() {
        DateTime dtA = new DateTime(VALID_SAMPLE_A);
        DateTime dtB = new DateTime(VALID_SAMPLE_B);
        DateTime dtC = new DateTime(VALID_SAMPLE_C);
        assertEquals(VALID_SAMPLE_A, dtA.toString());
        assertEquals(VALID_SAMPLE_B, dtB.toString());
        assertEquals(VALID_SAMPLE_C, dtC.toString());

    }

    @Test
    void parseFail() {
        // Fail pattern
        // E.g Missing digit, missing date, additional digits
        assertExceptionMessage(INVALID_SAMPLE_A, DateTime.MESSAGE_CONSTRAINTS);
        assertExceptionMessage(INVALID_SAMPLE_B, DateTime.MESSAGE_CONSTRAINTS);
        assertExceptionMessage(INVALID_SAMPLE_C, DateTime.MESSAGE_CONSTRAINTS);

        // Fail Range
        // E.g Months with too many days 29-02-2019
        assertExceptionMessage(INVALID_SAMPLE_D, DateTime.MESSAGE_CONSTRAINTS);
        assertExceptionMessage(INVALID_SAMPLE_E, DateTime.MESSAGE_CONSTRAINTS);


    }

    @Test
    void compareSuccess() {
        DateTime a = new DateTime(VALID_SAMPLE_A);
        DateTime b = new DateTime(VALID_SAMPLE_B);
        assertTrue(a.compareTo(b) > 0);
        assertTrue(b.compareTo(a) < 0);
        assertTrue(a.compareTo(a) == 0);

    }

    public void assertExceptionMessage(String test, String messageConstraint) {
        try {
            new DateTime(test);
        } catch (IllegalArgumentException pe) {
            assertEquals(messageConstraint,
                    pe.getMessage());
        }
    }
}
