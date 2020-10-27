package seedu.address;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;
import seedu.address.commons.core.Config;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.Version;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.util.ConfigUtil;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.LogicDeliverable;
import seedu.address.logic.LogicDeliverableManager;
import seedu.address.logic.LogicMeeting;
import seedu.address.logic.LogicMeetingManager;
import seedu.address.logic.LogicMode;
import seedu.address.logic.LogicModeManager;
import seedu.address.logic.LogicPerson;
import seedu.address.logic.LogicPersonManager;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;
import seedu.address.model.calendar.Calendar;
import seedu.address.model.deliverable.DeliverableBook;
import seedu.address.model.deliverable.ModelDeliverable;
import seedu.address.model.deliverable.ModelDeliverableManager;
import seedu.address.model.deliverable.ReadOnlyDeliverableBook;
import seedu.address.model.meeting.MeetingBook;
import seedu.address.model.meeting.ModelMeeting;
import seedu.address.model.meeting.ModelMeetingManager;
import seedu.address.model.meeting.ReadOnlyMeetingBook;
import seedu.address.model.person.AddressBook;
import seedu.address.model.person.ModelPerson;
import seedu.address.model.person.ModelPersonManager;
import seedu.address.model.person.ReadOnlyAddressBook;
import seedu.address.model.util.SampleDataUtil;
import seedu.address.storage.JsonUserPrefsStorage;
import seedu.address.storage.UserPrefsStorage;
import seedu.address.storage.deliverable.DeliverableBookStorage;
import seedu.address.storage.deliverable.JsonDeliverableBookStorage;
import seedu.address.storage.deliverable.StorageDeliverable;
import seedu.address.storage.deliverable.StorageDeliverableManager;
import seedu.address.storage.meeting.JsonMeetingBookStorage;
import seedu.address.storage.meeting.MeetingBookStorage;
import seedu.address.storage.meeting.StorageMeeting;
import seedu.address.storage.meeting.StorageMeetingManager;
import seedu.address.storage.person.AddressBookStorage;
import seedu.address.storage.person.JsonAddressBookStorage;
import seedu.address.storage.person.StoragePerson;
import seedu.address.storage.person.StoragePersonManager;
import seedu.address.ui.Ui;
import seedu.address.ui.UiManager;

/**
 * Runs the application.
 */
public class MainApp extends Application {

    public static final Version VERSION = new Version(0, 6, 0, true);

    private static final Logger logger = LogsCenter.getLogger(MainApp.class);

    protected Ui ui;
    protected LogicPerson logicPerson;
    protected StoragePerson storagePerson;
    protected ModelPerson modelPerson;

    protected ModelDeliverable modelDeliverable;
    protected StorageDeliverable storageDeliverable;
    protected LogicDeliverable logicDeliverable;

    protected LogicMeeting logicMeeting;
    protected StorageMeeting storageMeeting;
    protected ModelMeeting modelMeeting;
    protected Calendar calendar;

    protected LogicMode logicMode;
    protected Config config;

    @Override
    public void init() throws Exception {
        logger.info("=============================[ Initializing AddressBook ]===========================");
        super.init();

        AppParameters appParameters = AppParameters.parse(getParameters());
        config = initConfig(appParameters.getConfigPath());

        UserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(config.getUserPrefsFilePath());
        UserPrefs userPrefs = initPrefs(userPrefsStorage);

        AddressBookStorage addressBookStorage = new JsonAddressBookStorage(userPrefs.getAddressBookFilePath());
        DeliverableBookStorage deliverableBookStorage = new JsonDeliverableBookStorage(
                userPrefs.getDeliverableBookFilePath());
        MeetingBookStorage meetingBookStorage = new JsonMeetingBookStorage(
                userPrefs.getMeetingBookFilePath());

        storagePerson = new StoragePersonManager(addressBookStorage, userPrefsStorage);
        storageDeliverable = new StorageDeliverableManager(deliverableBookStorage, userPrefsStorage);
        initLogging(config);
        storageMeeting = new StorageMeetingManager(meetingBookStorage, userPrefsStorage);

        modelPerson = initModelManager(storagePerson, userPrefs);
        modelDeliverable = initDeliverableModelManager(storageDeliverable, userPrefs);
        modelMeeting = initMeetingModelManager(storageMeeting, userPrefs);
        calendar = new Calendar(modelDeliverable.getFilteredDeliverableList(),
                modelMeeting.getFilteredMeetingList());

        logicPerson = new LogicPersonManager(modelPerson, storagePerson);
        logicDeliverable = new LogicDeliverableManager(modelDeliverable, storageDeliverable);
        logicMeeting = new LogicMeetingManager(modelMeeting, storageMeeting);
        logicMode = new LogicModeManager();

        ui = new UiManager(logicMode, logicPerson, logicDeliverable, logicMeeting, calendar);

    }

    /**
     * Returns a {@code ModelManager} with the data from {@code storage}'s address book and {@code userPrefs}. <br>
     * The data from the sample address book will be used instead if {@code storage}'s address book is not found,
     * or an empty address book will be used instead if errors occur when reading {@code storage}'s address book.
     */
    private ModelPerson initModelManager(StoragePerson storagePerson, ReadOnlyUserPrefs userPrefs) {
        Optional<ReadOnlyAddressBook> addressBookOptional;
        ReadOnlyAddressBook initialData;
        try {
            addressBookOptional = storagePerson.readAddressBook();
            if (addressBookOptional.isEmpty()) {
                logger.info("Data file not found. Will be starting with a sample AddressBook");
            }
            initialData = addressBookOptional.orElseGet(SampleDataUtil::getSampleAddressBook);
        } catch (DataConversionException e) {
            logger.warning("Data file not in the correct format. Will be starting with an empty AddressBook");
            initialData = new AddressBook();
        } catch (IOException e) {
            logger.warning("Problem while reading from the file. Will be starting with an empty AddressBook");
            initialData = new AddressBook();
        }

        return new ModelPersonManager(initialData, userPrefs);
    }

    /**
     * Returns a {@code ModelManager} with the data from {@code storage}'s address book and {@code userPrefs}. <br>
     * The data from the sample address book will be used instead if {@code storage}'s address book is not found,
     * or an empty address book will be used instead if errors occur when reading {@code storage}'s address book.
     */
    private ModelDeliverable initDeliverableModelManager(StorageDeliverable storageDeliverable,
                                                         ReadOnlyUserPrefs userPrefs) {
        Optional<ReadOnlyDeliverableBook> deliverableBookOptional;
        ReadOnlyDeliverableBook initialData;
        try {
            deliverableBookOptional = storageDeliverable.readDeliverableBook();
            if (!deliverableBookOptional.isPresent()) {
                logger.info("Data file for deliverable not found. Will be starting with a sample DeliverableBook");
            }
            initialData = deliverableBookOptional.orElseGet(SampleDataUtil::getSampleDeliverableBook);
        } catch (DataConversionException e) {
            logger.warning("Data file for deliverable not in the correct format. "
                    + "Will be starting with an empty DeliverableBook");
            initialData = new DeliverableBook();
        } catch (IOException e) {
            logger.warning("Problem while reading from the deliverable file. "
                    + "Will be starting with an empty DeliverableBook");
            initialData = new DeliverableBook();
        }

        return new ModelDeliverableManager(initialData, userPrefs);
    }

    /**
     * Returns a {@code ModelManager} with the data from {@code storage}'s meeting book and {@code userPrefs}. <br>
     * The data from the sample meeting book will be used instead if {@code storage}'s meeting book is not found,
     * or an empty meeting book will be used instead if errors occur when reading {@code storage}'s meeting book.
     */
    private ModelMeeting initMeetingModelManager(StorageMeeting storageMeeting,
                                                 ReadOnlyUserPrefs userPrefs) {
        Optional<ReadOnlyMeetingBook> meetingBookOptional;
        ReadOnlyMeetingBook initialData;

        try {
            meetingBookOptional = storageMeeting.readMeetingBook();
            if (!meetingBookOptional.isPresent()) {
                logger.info("Data file for meeting not found. Will be starting with a sample MeetingBook");
            }
            initialData = meetingBookOptional.orElseGet(SampleDataUtil::getSampleMeetingBook);
        } catch (DataConversionException e) {
            logger.warning("Data file for meeting not in the correct format. "
                    + "Will be starting with an empty MeetingBook");
            initialData = new MeetingBook();
        } catch (IOException e) {
            logger.warning("Problem while reading from the meeting file. "
                    + "Will be starting with an empty MeetingBook");
            initialData = new MeetingBook();
        }

        return new ModelMeetingManager(initialData, userPrefs);
    }

    private void initLogging(Config config) {
        LogsCenter.init(config);
    }

    /**
     * Returns a {@code Config} using the file at {@code configFilePath}. <br>
     * The default file path {@code Config#DEFAULT_CONFIG_FILE} will be used instead
     * if {@code configFilePath} is null.
     */
    protected Config initConfig(Path configFilePath) {
        Config initializedConfig;
        Path configFilePathUsed;

        configFilePathUsed = Config.DEFAULT_CONFIG_FILE;

        if (configFilePath != null) {
            logger.info("Custom Config file specified " + configFilePath);
            configFilePathUsed = configFilePath;
        }

        logger.info("Using config file : " + configFilePathUsed);

        try {
            Optional<Config> configOptional = ConfigUtil.readConfig(configFilePathUsed);
            initializedConfig = configOptional.orElse(new Config());
        } catch (DataConversionException e) {
            logger.warning("Config file at " + configFilePathUsed + " is not in the correct format. "
                    + "Using default config properties");
            initializedConfig = new Config();
        }

        //Update config file in case it was missing to begin with or there are new/unused fields
        try {
            ConfigUtil.saveConfig(initializedConfig, configFilePathUsed);
        } catch (IOException e) {
            logger.warning("Failed to save config file : " + StringUtil.getDetails(e));
        }
        return initializedConfig;
    }

    /**
     * Returns a {@code UserPrefs} using the file at {@code storage}'s user prefs file path,
     * or a new {@code UserPrefs} with default configuration if errors occur when
     * reading from the file.
     */
    protected UserPrefs initPrefs(UserPrefsStorage storage) {
        Path prefsFilePath = storage.getUserPrefsFilePath();
        logger.info("Using prefs file : " + prefsFilePath);

        UserPrefs initializedPrefs;
        try {
            Optional<UserPrefs> prefsOptional = storage.readUserPrefs();
            initializedPrefs = prefsOptional.orElse(new UserPrefs());
        } catch (DataConversionException e) {
            logger.warning("UserPrefs file at " + prefsFilePath + " is not in the correct format. "
                    + "Using default user prefs");
            initializedPrefs = new UserPrefs();
        } catch (IOException e) {
            logger.warning("Problem while reading from the file. Will be starting with an empty AddressBook");
            initializedPrefs = new UserPrefs();
        }

        //Update prefs file in case it was missing to begin with or there are new/unused fields
        try {
            storage.saveUserPrefs(initializedPrefs);
        } catch (IOException e) {
            logger.warning("Failed to save config file : " + StringUtil.getDetails(e));
        }

        return initializedPrefs;
    }

    @Override
    public void start(Stage primaryStage) {
        logger.info("Starting AddressBook " + MainApp.VERSION);
        ui.start(primaryStage);
    }

    @Override
    public void stop() {
        logger.info("============================ [ Stopping Address Book ] =============================");
        try {
            storagePerson.saveUserPrefs(modelPerson.getUserPrefs());
            // for testing
            storageDeliverable.saveDeliverableBook(modelDeliverable.getDeliverableBook());
            storageMeeting.saveMeetingBook(modelMeeting.getMeetingBook());
        } catch (IOException e) {
            logger.severe("Failed to save preferences " + StringUtil.getDetails(e));
        }
    }
}
