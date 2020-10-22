package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.deliverable.deliverable.Deliverable;

/**
 * A utility class containing a list of {@code Deliverable} objects to be used in tests.
 */
public class TypicalDeliverables {
    public static final Deliverable HOMEPAGE = new DeliverableBuilder().withTitle("Build home page")
            .withMilestone("1.0")
            .withDescription("Include company description.")
            .withDeadline("12-11-2020 20:00")
            .withContacts("3")
            .withIsComplete(false)
            .build();
    public static final Deliverable NAVIGATION = new DeliverableBuilder().withTitle("Implement navigation")
            .withMilestone("1.1")
            .withDescription("Include about us tab")
            .withDeadline("12-07-2020 20:00")
            .withContacts("5,6")
            .withIsComplete(true)
            .build();;

    private TypicalDeliverables() {} //prevents instantiation

    public static List<Deliverable> getTypicalDeliverables() {
        return new ArrayList<>(Arrays.asList(HOMEPAGE, NAVIGATION));
    }
}
