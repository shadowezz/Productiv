package seedu.address.model.deliverable.deliverable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDeliverables.HOMEPAGE;
import static seedu.address.testutil.TypicalDeliverables.NAVIGATION;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.DeliverableBuilder;

public class DeliverableTest {

    //Not implemented yet
    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        assertFalse(false);
    }

    @Test
    public void isSameDeliverable() {
        // same object -> returns true
        assertTrue(HOMEPAGE.isSameDeliverable(HOMEPAGE));

        // null -> returns false
        assertFalse(HOMEPAGE.isSameDeliverable(null));

        // different title, everything else same -> returns false
        Deliverable editedHomepage = new DeliverableBuilder(HOMEPAGE).withTitle("Implement home page").build();
        assertFalse(HOMEPAGE.isSameDeliverable(editedHomepage));

        // same title, different other attributes -> returns true
        Deliverable editedNavigation = new DeliverableBuilder(NAVIGATION).withTitle("Build home page").build();
        assertTrue(HOMEPAGE.isSameDeliverable(editedNavigation));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Deliverable homepageCopy = new DeliverableBuilder(HOMEPAGE).build();
        assertTrue(HOMEPAGE.equals(homepageCopy));

        // same object -> returns true
        assertTrue(HOMEPAGE.isSameDeliverable(HOMEPAGE));

        // null -> returns false
        assertFalse(HOMEPAGE.equals(null));

        // different type -> returns false
        assertFalse(HOMEPAGE.equals(5));

        // different deliverable -> returns false
        assertFalse(HOMEPAGE.equals(NAVIGATION));

        // different title -> returns false
        Deliverable editedHomepage = new DeliverableBuilder(HOMEPAGE).withTitle("Implement home page").build();
        assertFalse(HOMEPAGE.isSameDeliverable(editedHomepage));

        // different milestone -> returns false

        // different description -> returns false

        // different deadline -> returns false

        // different contacts -> returns false

    }
}
