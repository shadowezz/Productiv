package seedu.address.model.util;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

public class DateTime implements Comparable<DateTime> {
    public static final String TIME_REGEX = "(([0-1]\\d)|(2[0-3])):([0-5]\\d)";
    public static final String DATE_REGEX = "(([0-2]\\d)|(3[0-1]))-((0[1-9])|(1[0-2]))-(\\d{4})";
    public static final String MESSAGE_CONSTRAINTS =
            "Dates should be in the format of DD-MM-YYYY or DD-MM-YYYY HH:mm, "
                    + "and should not be blank. Note: Single digit month, day, and "
                    + "minute must start with a leading zero.";

    public static final String VALIDATION_REGEX = String.format("%s(\\s(%s))?",
            DATE_REGEX, TIME_REGEX);

    public static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy[ HH:mm]");

    public static final String EMPTY_DATETIME_VALUE_STRING = "-";

    public final Optional<LocalDateTime> value;
    public final String valueString;

    /**
     * Constructs a {@code date}.
     *
     * @param date A valid date.
     */
    public DateTime(String date) {
        requireNonNull(date);

        // Check for constraints
        checkArgument(isValidDateTime(date), MESSAGE_CONSTRAINTS);

        // Parse value
        TemporalAccessor temporalAccessor = DATE_TIME_FORMATTER.parseBest(date,
                LocalDateTime::from, LocalDate::from);
        if (temporalAccessor instanceof LocalDateTime) {
            LocalDateTime dateTimeParsed = (LocalDateTime) temporalAccessor;
            this.value = Optional.of(dateTimeParsed);
            this.valueString = dateTimeParsed.format(DATE_TIME_FORMATTER);
        } else {
            LocalDate dateParsed = (LocalDate) temporalAccessor;
            this.value = Optional.of((dateParsed).atStartOfDay());
            this.valueString = dateParsed.format(DATE_TIME_FORMATTER);
        }

    }

    /**
     * Constructs a {@code date}.
     *
     * @param date A valid optional DateTime.
     */
    public DateTime(Optional<String> date) {
        // Check for constraints
        date.ifPresent(d -> checkArgument(isValidDateTime(d), MESSAGE_CONSTRAINTS));

        //Parse value
        Optional<TemporalAccessor> temporalAccessor = date.map(d -> DATE_TIME_FORMATTER
                .parseBest(d, LocalDateTime::from, LocalDate::from));
        Optional<LocalDateTime> dateTimeParsed = temporalAccessor
                .filter(t -> t instanceof LocalDateTime)
                .map(t -> ((LocalDateTime) t));
        Optional<LocalDate> dateParsed = temporalAccessor
                .filter(t -> t instanceof LocalDate)
                .map(t -> ((LocalDate) t));

        if (dateTimeParsed.isPresent()) {
            this.value = dateTimeParsed;
            this.valueString = dateTimeParsed
                    .map(dt -> dt.format(DATE_TIME_FORMATTER))
                    .orElse(EMPTY_DATETIME_VALUE_STRING);
        } else {
            this.value = dateParsed.map(LocalDate::atStartOfDay);
            this.valueString = dateParsed
                    .map(dt -> dt.format(DATE_TIME_FORMATTER))
                    .orElse(EMPTY_DATETIME_VALUE_STRING);
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

    /**
     * Checks is DateTime exists.
     *
     * @return true if value in DateTime exists.
     */
    public boolean isEmpty() {
        return this.value.isEmpty();
    }

    @Override
    public int compareTo(DateTime o) {
        if (value.isEmpty() && o.isEmpty()) {
            return 0;
        } else {
            return this.value.map(v1 ->
                    o.value.map(v2-> v1.compareTo(v2)).orElse(-1))
                    .orElse(1);
        }

    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DateTime) // instanceof handles nulls
                && ((value.isEmpty() && ((DateTime) other).value.isEmpty()) //if v1 and v2 empty, return true
                || value.map(v1 -> ((DateTime) other)
                .value.map(v2-> v1.equals(v2))
                .orElse(false)) // if v2 not present, return false
                .orElse(false)); // if v1 not present return false
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
