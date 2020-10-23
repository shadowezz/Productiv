package seedu.address.ui;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.commands.mode.SwitchCommand.MESSAGE_SUCCESS;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import seedu.address.commons.ModeEnum;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.LogicDeliverable;
import seedu.address.logic.LogicMeeting;
import seedu.address.logic.LogicMode;
import seedu.address.logic.LogicPerson;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.deliverable.deliverable.Deadline;
import seedu.address.model.deliverable.deliverable.Deliverable;
import seedu.address.model.util.Description;
import seedu.address.model.util.Item;
import seedu.address.model.util.Title;

/**
 * The Main Window. Provides the basic application layout containing
 * a menu bar and space where other JavaFX elements can be placed.
 */
public class MainWindow extends UiPart<Stage> {

    private static final String FXML = "MainWindow.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private Stage primaryStage;
    private ModeEnum mode;
    private LogicMode logicMode;
    private LogicPerson logicPerson;
    private LogicDeliverable logicDeliverable;
    private LogicMeeting logicMeeting;

    // Independent Ui parts residing in this Ui container
    private PersonListPanel personListPanel;
    private DeliverableListPanel deliverableListPanel;
    private MeetingListPanel meetingListPanel;
    private DeliverableDetailsPanel deliverableDetailsPanel;
    private ResultDisplay resultDisplay;
    private HelpWindow helpWindow;

    @FXML
    private StackPane commandBoxPlaceholder;

    @FXML
    private Button helpButton;

    @FXML
    private Button deliverableButton;

    @FXML
    private Button meetingButton;

    @FXML
    private Button personButton;

    @FXML
    private StackPane listPanelPlaceholder;

    @FXML
    private StackPane detailsPanelPlaceholder;

    @FXML
    private StackPane resultDisplayPlaceholder;

    @FXML
    private StackPane statusbarPlaceholder;

    /**
     * Creates a {@code MainWindow} with the given {@code Stage} {@code LogicMode},
     * {@code LogicPerson} and {@code LogicDeliverable}.
     */
    public MainWindow(Stage primaryStage, LogicMode logicMode, LogicPerson logicPerson,
                      LogicDeliverable logicDeliverable, LogicMeeting logicMeeting) {
        super(FXML, primaryStage);

        // Set dependencies
        this.primaryStage = primaryStage;
        this.logicMode = logicMode;
        this.logicPerson = logicPerson;
        this.logicDeliverable = logicDeliverable;
        this.logicMeeting = logicMeeting;

        // Configure the UI
        // all managers' Gui points to same GuiSettings object so its fine
        setWindowDefaultSize(logicPerson.getGuiSettings());

        setAccelerators();

        helpWindow = new HelpWindow();

        mode = ModeEnum.PERSON; // default to contacts list first
        setUnderlineButton(personButton);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private void setAccelerators() {
        setAccelerator(helpButton, KeyCombination.valueOf("F1"));
    }

    /**
     * Sets the accelerator of a Button.
     * @param keyCombination the KeyCombination value of the accelerator
     */
    private void setAccelerator(Button button, KeyCombination keyCombination) {
        requireNonNull(button);
        Scene scene = button.getScene();
        requireNonNull(scene);

        scene.getAccelerators().put(
                keyCombination,
                new Runnable() {
                    @FXML public void run() {
                        button.fire();
                    }
                }
        );
    }

    /**
     * Change Ui according to current mode.
     * @param mode the mode to change Ui to.
     */
    public void switchMode(ModeEnum mode) {
        requireNonNull(mode);
        this.mode = mode;
        detailsPanelPlaceholder.getChildren().clear(); // clear details panel
        listPanelPlaceholder.getChildren().clear(); // remove current list
        statusbarPlaceholder.getChildren().clear(); // remove current status bar
        resultDisplay.setFeedbackToUser(String.format(MESSAGE_SUCCESS, mode)); // if userinput is through clicking
        switch (mode) {
        case PERSON:
            listPanelPlaceholder.getChildren().add(personListPanel.getRoot());
            StatusBarFooter statusBarFooter = new StatusBarFooter(logicPerson.getAddressBookFilePath());
            statusbarPlaceholder.getChildren().add(statusBarFooter.getRoot());
            setUnderlineButton(personButton);
            break;
        case DELIVERABLE:
//            detailsPanelPlaceholder.getChildren().add(deliverableDetailsPanel.getRoot()); // test
            listPanelPlaceholder.getChildren().add(deliverableListPanel.getRoot());
            statusBarFooter = new StatusBarFooter(logicDeliverable.getDeliverableBookFilePath());
            statusbarPlaceholder.getChildren().add(statusBarFooter.getRoot());
            setUnderlineButton(deliverableButton);
            break;
        case MEETING:
            listPanelPlaceholder.getChildren().add(meetingListPanel.getRoot());
            statusBarFooter = new StatusBarFooter(logicMeeting.getMeetingBookFilePath());
            statusbarPlaceholder.getChildren().add(statusBarFooter.getRoot());
            setUnderlineButton(meetingButton);
            break;
        default:
            assert false : "from default: " + ModeEnum.getModeOptions();
        }
    }

    private void setUnderlineButton(Button button) {
        personButton.setUnderline(false);
        deliverableButton.setUnderline(false);
        meetingButton.setUnderline(false);
        button.setUnderline(true);
    }

    // TODO define switch tabs here

    /**
     * Switches to contact mode.
     */
    public void switchPerson() {
        switchMode(ModeEnum.PERSON);
    }

    /**
     * Switches to deliverable mode.
     */
    public void switchDeliverable() {
        switchMode(ModeEnum.DELIVERABLE);
    }

    /**
     * Switches to meeting mode.
     */
    public void switchMeeting() {
        switchMode(ModeEnum.MEETING);
    }
    /**
     * Fills up all the placeholders of this window.
     */
    void fillInnerParts() {

        personListPanel = new PersonListPanel(logicPerson.getFilteredPersonList());
        listPanelPlaceholder.getChildren().add(personListPanel.getRoot());

        deliverableListPanel = new DeliverableListPanel(logicDeliverable.getFilteredDeliverableList());
        meetingListPanel = new MeetingListPanel(logicMeeting.getFilteredMeetingList());

        resultDisplay = new ResultDisplay();
        resultDisplayPlaceholder.getChildren().add(resultDisplay.getRoot());

        StatusBarFooter statusBarFooter = new StatusBarFooter(logicPerson.getAddressBookFilePath());
        statusbarPlaceholder.getChildren().add(statusBarFooter.getRoot());

        CommandBox commandBox = new CommandBox(this::executeCommand);
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());
    }

    /**
     * Sets the default size based on {@code guiSettings}.
     */
    private void setWindowDefaultSize(GuiSettings guiSettings) {
        primaryStage.setHeight(guiSettings.getWindowHeight());
        primaryStage.setWidth(guiSettings.getWindowWidth());
        if (guiSettings.getWindowCoordinates() != null) {
            primaryStage.setX(guiSettings.getWindowCoordinates().getX());
            primaryStage.setY(guiSettings.getWindowCoordinates().getY());
        }
    }

    /**
     * Opens the help window or focuses on it if it's already opened.
     */
    @FXML
    public void handleHelp() {
        if (!helpWindow.isShowing()) {
            helpWindow.show();
        } else {
            helpWindow.focus();
        }
    }

    void show() {
        primaryStage.show();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        GuiSettings guiSettings = new GuiSettings(primaryStage.getWidth(), primaryStage.getHeight(),
                (int) primaryStage.getX(), (int) primaryStage.getY());
        logicPerson.setGuiSettings(guiSettings); // its just to save last guiSetting used
        helpWindow.hide();
        primaryStage.hide();
    }

    private void updateDetailsPanel() {
        detailsPanelPlaceholder.getChildren().clear();

        switch (mode) {
        //Todo
        case PERSON:
            /**
            if (logicPerson.getPersonInView() != null) {
                personDetailsPanel = new PersonDetailsPanel(logicPerson.getPersonInView());
                detailsPanelPlaceholder.getChildren().add(personDetailsPanel.getRoot());
            }
             **/
        case DELIVERABLE:
            if (logicDeliverable.getDeliverableInView() != null) {
                deliverableDetailsPanel = new DeliverableDetailsPanel(logicDeliverable.getDeliverableInView());
                detailsPanelPlaceholder.getChildren().add(deliverableDetailsPanel.getRoot());
            }
        //Todo
        case MEETING:
            /**
            if (logicMeeting.getMeetingInView() != null) {
                meetingDetailsPanel = new MeetingDetailsPanel(logicMeeting.getMeetingInView());
                detailsPanelPlaceholder.getChildren().add(meetingDetailsPanel.getRoot());
            }
             **/
        default:
            assert false : "invalid mode type: " + ModeEnum.getModeOptions();
        }





    }

    public PersonListPanel getPersonListPanel() {
        return personListPanel;
    }

    /**
     * Executes the command and returns the result.
     *
     * @see LogicPerson#execute(String)
     */
    private CommandResult executeCommand(String commandText) throws CommandException, ParseException {
        try {
            CommandResult commandResult = null;
            if (logicMode.isModeCommand(commandText)) {
                commandResult = logicMode.execute(commandText);
            } else {
                switch (mode) {
                case PERSON:
                    commandResult = logicPerson.execute(commandText);
                    break;
                case DELIVERABLE:
                    commandResult = logicDeliverable.execute(commandText);
                    break;
                case MEETING:
                    commandResult = logicMeeting.execute(commandText);
                    break;
                default:
                    assert false : "from default: " + ModeEnum.getModeOptions();
                }
            }

            requireNonNull(commandResult);

            logger.info("Result: " + commandResult.getFeedbackToUser());
            resultDisplay.setFeedbackToUser(commandResult.getFeedbackToUser());

            if (commandResult.isShowHelp()) {
                handleHelp();
            }

            if (commandResult.isExit()) {
                handleExit();
            }

            if (commandResult.getMode() != null) {
                switchMode(commandResult.getMode());
            } else {
                updateDetailsPanel();
            }


            return commandResult;
        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            resultDisplay.setFeedbackToUser(e.getMessage());
            throw e;
        }
    }
}
