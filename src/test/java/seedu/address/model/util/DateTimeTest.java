package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class DateTimeTest {

    public static final String VALID_SAMPLE_A = "30-11-2020 10:00";
    public static final String VALID_DATE_A = "30-11-2020";
    public static final String VALID_SAMPLE_B = "31-11-2020 23:00";
    public static final String VALID_DATE_B = "30-02-2020";
    public static final String VALID_DATE_C = "29-02-2019";
    public static final String TIME_A = "23:00";

    @Test
    void isValidDateTimeSuccess() {
        assertTrue(TIME_A.matches(DateTime.TIME_REGEX));
        assertTrue(VALID_DATE_A.matches(DateTime.DATE_REGEX));

        // Date no Time
        assertTrue(DateTime.isValidDateTime(VALID_DATE_A));

        // Date and Time
        assertTrue(DateTime.isValidDateTime(VALID_SAMPLE_A));
    }


    @Test
    void parseSuccess() {
        DateTime dt = new DateTime(VALID_SAMPLE_A);
        assertEquals(VALID_SAMPLE_A, dt.toString());

        DateTime dtNoTime = new DateTime(VALID_DATE_A);
        assertEquals(VALID_DATE_A, dtNoTime.toString());

        //Optional
        dt = new DateTime(Optional.of(VALID_SAMPLE_A));
        assertEquals(VALID_SAMPLE_A, dt.toString());

        dtNoTime = new DateTime(Optional.of(VALID_DATE_A));
        assertEquals(VALID_DATE_A, dtNoTime.toString());

        //Optional Empty
        assertEquals("-", new DateTime(Optional.empty()).toString());

    }

    @Test
    void resolveOverflowParseSuccess() {

        DateTime resolveA = new DateTime(VALID_SAMPLE_B);
        assertEquals("30-11-2020 23:00", resolveA.toString());

        DateTime resolveB = new DateTime(VALID_DATE_B);
        assertEquals("29-02-2020", resolveB.toString());

        DateTime resolveC = new DateTime(VALID_DATE_C);
        assertEquals("28-02-2019", resolveC.toString());
    }

    @Test
    void compareSuccess() {
        DateTime a = new DateTime(VALID_SAMPLE_A);
        DateTime b = new DateTime(VALID_SAMPLE_B);
        DateTime c = new DateTime(VALID_DATE_A);
        DateTime a1 = new DateTime(Optional.empty());
        assertEquals(a.compareTo(b), -1);
        assertEquals(a.compareTo(a), 0);
        assertEquals(a.compareTo(c), 1);

        //Compare Empty Optionals
        //Empty Optionals have highest priority
        assertEquals(a1.compareTo(a), 1);
        assertEquals(a.compareTo(a1), -1);

        //Both are Empty Optionals
        assertEquals(a1.compareTo(a1), 0);
    }
}
