package seedu.address.storage.deliverable;

import java.io.IOException;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.deliverable.ReadOnlyDeliverableBook;
import seedu.address.storage.Storage;

/**
 * API of the Storage component for Deliverable
 */
public interface StorageDeliverable extends Storage {

    Optional<ReadOnlyDeliverableBook> readDeliverableBook() throws DataConversionException, IOException;

    void saveDeliverableBook(ReadOnlyDeliverableBook deliverableBook) throws IOException;
}
