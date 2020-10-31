package seedu.address.storage.person;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.ReadOnlyAddressBook;
import seedu.address.storage.Storage;
import seedu.address.storage.UserPrefsStorage;

/**
 * API of the Storage component
 */
public interface StoragePerson extends Storage {

    Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException, IOException;

    void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException;

}
