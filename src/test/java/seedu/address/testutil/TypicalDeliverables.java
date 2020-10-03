package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.deliverable.deliverable.Deliverable;

/**
 * A utility class containing a list of {@code Deliverable} objects to be used in tests.
 */
public class TypicalDeliverables {
    public static final Deliverable HOMEPAGE = new DeliverableBuilder().withTitle("Build home page").build();
    public static final Deliverable NAVIGATION = new DeliverableBuilder().withTitle("Implement navigation").build();

    private TypicalDeliverables() {} //prevents instantiation

    public static List<Deliverable> getTypicalDeliverables() {
        return new ArrayList<>(Arrays.asList(HOMEPAGE, NAVIGATION));
    }
}
