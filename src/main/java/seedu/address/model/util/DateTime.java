package seedu.address.model.util;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateTime implements Comparable<DateTime> {
    public static final String TIME_REGEX = "(([0-1]\\d)|(2[0-3])):([0-5]\\d)";
    public static final String DATE_REGEX = "(([0-2]\\d)|(3[0-1]))-((0[1-9])|(1[0-2]))-(\\d{4})";
    public static final String MESSAGE_CONSTRAINTS =
            "From should be in the format of DD-MM-YYYY or DD-MM-YYYY HH:mm, and should not be blank."
                    + "Note: Single digit month, day, and minute must start with a leading zero.";

    public static final String VALIDATION_REGEX = String.format("%s(\\s(%s))?",
            DATE_REGEX, TIME_REGEX);

    public static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy[ HH:mm]");

    public final LocalDateTime value;
    public final String valueString;

    /**
     * Constructs a {@code date}.
     *
     * @param date A valid from.
     */
    public DateTime(String date) {
        requireNonNull(date);

        // Check for constraints
        checkArgument(isValidDateTime(date), MESSAGE_CONSTRAINTS);

        // Parse value
        TemporalAccessor temporalAccessor = DATE_TIME_FORMATTER.parseBest(date,
                LocalDateTime::from, LocalDate::from);
        if (temporalAccessor instanceof LocalDateTime) {
            this.value = (LocalDateTime) temporalAccessor;
            this.valueString = this.value.format(DATE_TIME_FORMATTER);
        } else {
            this.value = ((LocalDate) temporalAccessor).atStartOfDay();
            this.valueString = ((LocalDate) temporalAccessor).format(DATE_TIME_FORMATTER);
        }

    }

    /**
     * Returns true if a given string is a valid DateTime.
     *
     * @param test string to test.
     * @return result of match.
     */
    public static boolean isValidDateTime(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public int compareTo(DateTime o) {
        return this.value.compareTo(o.value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DateTime) // instanceof handles nulls
                && value.equals((((DateTime) other).value)); // state check
    }

    @Override
    public String toString() {
        return valueString;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
