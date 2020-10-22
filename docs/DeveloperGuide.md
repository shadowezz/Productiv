---
layout: page
title: Developer Guide
---
* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

## **Design**

### Architecture

<img src="images/ArchitectureDiagram.png" width="450" />

The ***Architecture Diagram*** given above explains the high-level design of the App. Given below is a quick overview of each component.

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** The `.puml` files used to create diagrams in this document can be found in the [diagrams](https://github.com/se-edu/addressbook-level3/tree/master/docs/diagrams/) folder. Refer to the [_PlantUML Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/plantUml.html) to learn how to create and edit diagrams.

</div>

**`Main`** has two classes called [`Main`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java). It is responsible for,
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

The rest of the App consists of four components.

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#modelPerson-component): Holds the data of the App in memory.
* [**`Storage`**](#storagePerson-component): Reads data from, and writes data to, the hard disk.

Each of the four components,

* defines its *API* in an `interface` with the same name as the Component.
* exposes its functionality using a concrete `{Component Name}Manager` class (which implements the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component (see the class diagram given below) defines its API in the `Logic.java` interface and exposes its functionality using the `LogicManager.java` class which implements the `Logic` interface.

![Class Diagram of the Logic Component](images/LogicClassDiagram.png)

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<img src="images/ArchitectureSequenceDiagram.png" width="574" />

The sections below give more details of each component.

### UI component

![Structure of the UI Component](images/UiClassDiagram.png)

**API** :
[`Ui.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java)

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class.

The `UI` component uses JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* Executes user commands using the `Logic` component.
* Listens for changes to `Model` data so that the UI can be updated with the modified data.

### Logic component

![Structure of the Logic Component](images/LogicClassDiagram.png)

**API** :
[`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java)

1. `Logic` uses the `AddressBookParser` class to parse the user command.
1. This results in a `Command` object which is executed by the `LogicManager`.
1. The command execution can affect the `Model` (e.g. adding a person).
1. The result of the command execution is encapsulated as a `CommandResult` object which is passed back to the `Ui`.
1. In addition, the `CommandResult` object can also instruct the `Ui` to perform certain actions, such as displaying help to the user.

Given below is the Sequence Diagram for interactions within the `Logic` component for the `execute("delete 1")` API call.

![Interactions Inside the Logic Component for the `delete 1` Command](images/DeleteSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
</div>

### Model component

![Structure of the Model Component](images/ModelClassDiagram.png)

**API** : [`Model.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/modelPerson/Model.java)

The `Model`,

* stores a `UserPref` object that represents the user’s preferences.
* stores the address book data.
* exposes an unmodifiable `ObservableList<Person>` that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.
* does not depend on any of the other three components.


<div markdown="span" class="alert alert-info">:information_source: **Note:** An alternative (arguably, a more OOP) modelPerson is given below. It has a `Tag` list in the `AddressBook`, which `Person` references. This allows `AddressBook` to only require one `Tag` object per unique `Tag`, instead of each `Person` needing their own `Tag` object.<br>
![BetterModelClassDiagram](images/BetterModelClassDiagram.png)

</div>


### Storage component

![Structure of the Storage Component](images/StorageClassDiagram.png)

**API** : [`Storage.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storagePerson/Storage.java)

The `Storage` component,
* can save `UserPref` objects in json format and read it back.
* can save the address book data in json format and read it back.

### Common classes

Classes used by multiple components are in the `seedu.addressbook.commons` package.

--------------------------------------------------------------------------------------------------------------------

## **Implementation**

This section describes some noteworthy details on how certain features are implemented.

### \[Proposed\] Undo/redo feature

#### Proposed Implementation

The proposed undo/redo mechanism is facilitated by `VersionedAddressBook`. It extends `AddressBook` with an undo/redo history, stored internally as an `addressBookStateList` and `currentStatePointer`. Additionally, it implements the following operations:

* `VersionedAddressBook#commit()` — Saves the current address book state in its history.
* `VersionedAddressBook#undo()` — Restores the previous address book state from its history.
* `VersionedAddressBook#redo()` — Restores a previously undone address book state from its history.

These operations are exposed in the `Model` interface as `Model#commitAddressBook()`, `Model#undoAddressBook()` and `Model#redoAddressBook()` respectively.

Given below is an example usage scenario and how the undo/redo mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `VersionedAddressBook` will be initialized with the initial address book state, and the `currentStatePointer` pointing to that single address book state.

![UndoRedoState0](images/UndoRedoState0.png)

Step 2. The user executes `delete 5` command to delete the 5th person in the address book. The `delete` command calls `Model#commitAddressBook()`, causing the modified state of the address book after the `delete 5` command executes to be saved in the `addressBookStateList`, and the `currentStatePointer` is shifted to the newly inserted address book state.

![UndoRedoState1](images/UndoRedoState1.png)

Step 3. The user executes `add n/David …​` to add a new person. The `add` command also calls `Model#commitAddressBook()`, causing another modified address book state to be saved into the `addressBookStateList`.

![UndoRedoState2](images/UndoRedoState2.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If a command fails its execution, it will not call `Model#commitAddressBook()`, so the address book state will not be saved into the `addressBookStateList`.

</div>

Step 4. The user now decides that adding the person was a mistake, and decides to undo that action by executing the `undo` command. The `undo` command will call `Model#undoAddressBook()`, which will shift the `currentStatePointer` once to the left, pointing it to the previous address book state, and restores the address book to that state.

![UndoRedoState3](images/UndoRedoState3.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index 0, pointing to the initial AddressBook state, then there are no previous AddressBook states to restore. The `undo` command uses `Model#canUndoAddressBook()` to check if this is the case. If so, it will return an error to the user rather
than attempting to perform the undo.

</div>

The following sequence diagram shows how the undo operation works:

![UndoSequenceDiagram](images/UndoSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `UndoCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

</div>

The `redo` command does the opposite — it calls `Model#redoAddressBook()`, which shifts the `currentStatePointer` once to the right, pointing to the previously undone state, and restores the address book to that state.

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index `addressBookStateList.size() - 1`, pointing to the latest address book state, then there are no undone AddressBook states to restore. The `redo` command uses `Model#canRedoAddressBook()` to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</div>

Step 5. The user then decides to execute the command `list`. Commands that do not modify the address book, such as `list`, will usually not call `Model#commitAddressBook()`, `Model#undoAddressBook()` or `Model#redoAddressBook()`. Thus, the `addressBookStateList` remains unchanged.

![UndoRedoState4](images/UndoRedoState4.png)

Step 6. The user executes `clear`, which calls `Model#commitAddressBook()`. Since the `currentStatePointer` is not pointing at the end of the `addressBookStateList`, all address book states after the `currentStatePointer` will be purged. Reason: It no longer makes sense to redo the `add n/David …​` command. This is the behavior that most modern desktop applications follow.

![UndoRedoState5](images/UndoRedoState5.png)

The following activity diagram summarizes what happens when a user executes a new command:

![CommitActivityDiagram](images/CommitActivityDiagram.png)

#### Design consideration:

##### Aspect: How undo & redo executes

* **Alternative 1 (current choice):** Saves the entire address book.
  * Pros: Easy to implement.
  * Cons: May have performance issues in terms of memory usage.

* **Alternative 2:** Individual command knows how to undo/redo by
  itself.
  * Pros: Will use less memory (e.g. for `delete`, just save the person being deleted).
  * Cons: We must ensure that the implementation of each individual command are correct.

_{more aspects and alternatives to be added}_

### \[Proposed\] Data archiving

_{Explain here how the data archiving feature will be implemented}_

--------------------------------------------------------------------------------------------------------------------
## Enhancements

### \[DateTime\]

#### Enhancement
The enhancement allows users to parse and compare unique DateTimes. 

#### Parsing
To parse, dateTimes should be in the following format: **`dd-MM-yyyy HH:mm`** 
* Single digits fields must include leading zero: `01-01-0101 01:10`.
* Valid Calendar Range: \[`01-01-0001 00:00` - `31-12-9999 23:59`\].

DateTime will throw a parsing error if
* `1-10-2020 00:00:59` Format is wrong (e.g missing or additional digit).
* `31-02-2020 00:00` Invalid range (e.g invalid leap year).


#### Implementation
The following is an example of how DateTime can be implemented into the model

![DateTimeClassDiagram](images/DateTimeClass.png)

* DateTime is a common class in Model.
* From, To and Deadline are attributes which extend from DateTime.

### Usage
DateTime can be used to compare with DateTime fields:
* Enables deliverables to be sorted based on which meeting starts earlier.
* DateTime can be used to identify clashes if there are any clashes between meetings.

--------------------------------------------------------------------------------------------------------------------

## **Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Requirements**

### Product scope

**Target user profile**:

* has a need to manage a significant number of contacts
* has a need to manage a meeting schedule
* has a need to oversee the development of the product
* prefer desktop apps over other types
* can type fast
* prefers typing to mouse interactions
* is reasonably comfortable using CLI apps

**Value proposition**: Used in a corporate setting, our application integrates both a meeting schedule and a contact list for the user to 
manage their product’s development more comprehensively and conveniently.


### EPIC

| No | EPIC                                                                                                                                        | 
|----|---------------------------------------------------------------------------------------------------------------------------------------------|
|A   | As a Product Manager, I can track my product’s development so that I can work better towards production deadlines.                          |
|B   | As a Product Manager, I can manage my stakeholder/dev team contacts.                                                                        |
|C   | As a Product Manager, I can organise my meetings with stakeholders.                                                                         |
|D   | As an inexperienced or forgetful Product Manager, I can refer to a user guide as I’m using the app so that I am able to use it as intended. |
|E   | As a bridge between Dev Team and Stakeholders, I can communicate better.                                                                    |

### User stories

Priorities: 
* `* * *` - High (must have)
* `* *` - Medium (nice to have)
* `*` - Low (unlikely to have) 

| Priority | As a Product Manager…​                | I want to …​                                                             | So that I can…​                 |
| -------- | ---------------------------------------- | --------------------------------------------------------------------------- | ---------------------------------- |
| **EPIC A** |
| `* * *`  | Product Manager                          | add deliverables                                                            | keep track of them                 |
| `* * *`  | Product Manager                          | mark deliverables as completed                                              | refer back to them when needed     |
| `* * *`  | Product Manager                          | delete deliverables that are no longer relevant                             | focus on current deliverables      |
| `* *`    | Product Manager                          | change the description of the deliverables                                  | keep them up to date               |
| `* *`    | Product Manager                          | package deliverables into different milestones                              | retrieve the relevant deliverables easily |
| `* *`    | Product Manager                          | easily know who and how to contact the person-in-charge                     | contact the person when the progress of a deliverable is behind schedule |
| `* *`    | Product Manager                          | flag problematic deliverables in the app                                    | know that these tasks require further attention |
| `* *`    | Product Manager                          | find a deliverable easily                                                   |                                    |
| `* *`    | Product Manager                          | sort my deliverables by deadline                                            |                                    |
| **EPIC B** |
| `* * *`  | Product Manager                          | add contacts                                                                | store their details for future communication |
| `* * *`  | Product Manager                          | distinguish between the developers and the stakeholders in a project easily | remember the different roles       |
| `* * *`  | Product Manager                          | view my contacts and their relevant details                                 | remember and retrieve important information  |
| `* *  `  | Product Manager                          | edit my contacts                                                            | keep them up-to-date               |
| `* *`    | Product Manager                          | search for contacts based on a certain field of information                 | easily navigate through different groups |
| `* *`    | Product Manager                          | sort my contacts by alphabetical order                                      |                                    |
| `* *`    | Product Manager                          | view the details of my deliverables easily                                  |                                    |
| **EPIC C** |
| `* * *`  | Product Manager                          | schedule new meetings with my stakeholders                                  | keep track of them                 |
| `* * *`  | Product Manager                          | delete scheduled meetings with my stakeholders                              | remove outdated or cancelled meetings |
| `* *`    | Product Manager                          | edit existing meeting details with my stakeholders                          | update them accordingly            |
| `* *`    | Product Manager                          | be notified if I have conflicting meetings before adding new ones           | reschedule the meetings            |
| `* *`    | Product Manager                          | search for contacts based on a certain field of information                 | easily navigate through different groups |
| `* *`    | Product Manager                          | sort my meetings by alphabetical order                                      |                                    |
| `* *`    | Product Manager                          | view the details of my deliverables easily                                  |                                    |
| **EPIC D** |
| `* *`    | Product Manager                          | view a helpful popup                                                        | easily access the relevant instructions |
| `* *`    | Product Manager                          | receive feedback from the app                                               | know the system has registered my action correctly or not |
| `* *`    | Product Manager                          | view and easily navigate within the shortcut reference                      | locate technical solutions quickly |
| **EPIC E** |
| `* * *`  | Product Manager                          | Opening page                                                                | Enter the name of product and initialise Productiv       |
| `*`      | Product Manager                          | see a calendar view of meetings                                             | know my available slots to schedule new meetings   |
| `*`      | Product Manager                          | view the overall completion                                                 | know whether we are on track (completed deliverables/total deliverables) |




### Use cases

(For all use cases below, the **System** is the `Productiv` and the **Actor** is the `user`, unless specified otherwise)

#### Mode

**Use case: `UC01 - Switch Mode`**

**MSS**

1. User chooses to switch the mode.
2. User enters the command to switch mode into the input box.
3. Productiv switches to the expected mode.

    Use case ends.

**Extensions**

* 2a. Produtiv detects an error in the command.
     
     * 2a1. Productiv displays an error message
     
     * 2a2. User enters the command again.
     
     * 2a3. Steps 2a1-2a2 are repeated until the command entered is correct.
     
       Use case resumes from step 3.


#### CONTACT

**Use case: `UC10 - Add a contact`**

**Precondition(s):**
* **`User is in the Contact mode`**

**MSS**

1. User adds contact.
    Use case ends.
    
**Extensions**

* 1a. Invalid input.
    
    * 1a1. Productiv shows an error message.
      
      Use case ends.

      
**Use case: `UC11 - Edit a contact`**

**Precondition(s):**
* **`User is in the Contact mode`**
* **`Contact to edit exists`**

**MSS**

1. User requests to list contacts.
1. Productiv shows list of contacts.
1. User edits a specific contact in the list.
1. Productiv edits contact details.

    Use case ends.

**Extensions**

* 2a. The list is empty.
  
  * Use case ends.
     
* 3a. The given index is invalid.
    
    * 3a1. Productiv shows an error message.
    
      Use case resumes at step 2.
      
* 4a. The given input is invalid.
    
    * 4a1 Productiv shows an error message.
      
      Use case resumes at step 2.

**Use case: `UC12 - Delete a contact`**

**Precondition(s):**
* **`User is in the Contact mode`** 
* **`Contact to delete exists`**

**Guarantee(s):** 
* **`Deleted contacts will not have its data in Productiv`**
* **`Deleted contacts cannot be retrieved back`**

**MSS**

1. User requests to list contacts.
1. Productiv shows list of contacts.
1. User requests to delete a specific contact in the list.
1. Productiv deletes the contact.
   User case ends.

    Use case ends.

**Extensions**

* 2a. The list is empty.
  
  * Use case ends.
     
* 3a. The given index is invalid.
    
    * 3a1. Productiv shows an error message.
    
      Use case resumes at step 2.
      



#### DELIVERABLES

**Use case: `UC20 - Add Deliverable`**

**Precondition(s):**
* **`User is in the Deliverable mode`** 

**MSS**

1. User chooses to add a deliverable.
1. User enters the command to add a deliverable into the input box.
1. Productiv adds the deliverable for tracking.

    Use case ends.

**Extensions**

* 2a. Produtiv detects an error in the command.
    
    * 2a1. Productiv displays an error message.
    
    * 2a2. User enters the command again.
    
    * Steps 2a1-2a2 are repeated until the command entered is correct.
      
      Use case resumes from step 3.
      
**Use case: `UC21 - Edit Deliverable`**

**Precondition(s):**
* **`User is in the Deliverable mode`** 
* **`Deliverable to edit exists`**

**MSS**

1. User chooses to edit a deliverable.
1. User enters the command to edit a deliverable into the input box.
1. Productiv edits the deliverable.
   
   Use case ends.

**Extensions**

* 2a. Produtiv detects an error in the command.
    
    * 2a1. Productiv displays an error message.
    
    * 2a2. User enters the command again.
    
    * Steps 2a1-2a2 are repeated until the command entered is correct.
      
      Use case resumes from step 3.

**Use case: `UC22 - Mark Deliverable Completed`**

**Precondition(s):**
* **`User is in the Deliverable mode`** 
* **`Deliverable to mark complete exists`**

**MSS**

1. User chooses to mark a deliverable as completed.
1. User enters the command to mark a deliverable as complete into the input box.
1. Productiv marks the deliverable as done.

    Use case ends


**Extensions**

* 2a. Produtiv detects an error in the command.
    
    * 2a1. Productiv displays an error message.
    
    * 2a2. User enters the command again.
    
    * Steps 2a1-2a2 are repeated until the command entered is correct.
      
      Use case resumes from step 3.
      
**Use case: `UC23 - Delete Deliverable`**

**Precondition(s):**
* **`User is in the Deliverable mode`** 
* **`Deliverable to delete exists`**

**Guarantee(s):** 
* **`Deleted deliverables will not have its data in Productiv`**
* **`Deleted deliverables cannot be retrieved back`**


**MSS**
1. User chooses to delete a deliverable.
1. User enters the command to delete a deliverable into the input box.
1. Productiv prompts the user to confirm deletion.
1. User accepts confirmation.
1. Productiv deletes the deliverable.
    Use case ends.

**Extensions**

* 2a. Produtiv detects an error in the command.
    
    * 2a1. Productiv displays an error message.
    
    * 2a2. User enters the command again.
    
    * Steps 2a1-2a2 are repeated until the command entered is correct.
      
      Use case resumes from step 3.
      
* 4a. User declines confirmation.

    * 4a1. Productiv cancels the deletion process.
    
      Use case ends.

#### MEETING

**Use case: `UC30 - Add a meeting`**

**Precondition(s):**
* **`User is in the meeting mode`**

**MSS**

1. User adds meeting.
    Use case ends.
    
**Extensions**

* 1a. Invalid input.
    
    * 1a1. Productiv shows an error message.
      
      Use case ends.
      
**Use case: `UC31 - Edit a meeting`**

**Precondition(s):**
* **`User is in the meeting mode`** 
* **`Meeting to edit exists`**

**MSS**

1. User requests to list meetings.
1. Productiv shows list of meetings.
1. User edits a specific meeting in the list.
1. Productiv edits meeting details.

    Use case ends.

**Extensions**

* 2a. The list is empty.
  
  * Use case ends.
     
* 3a. The given index is invalid.
    
    * 3a1. Productiv shows an error message.
    
      Use case resumes at step 2.
      
* 4a. The given input is invalid.
    
    * 4a1 Productiv shows an error message.
      
      Use case resumes at step 2.
      
**Use case: `UC32 - Delete a meeting`**

**Precondition(s):**
* **`User is in the meeting mode`** 
* **`Meeting to delete exists`**

**Guarantee(s):** 
* **`Deleted meeting will not have its data in Productiv`**
* **`Deleted meeting cannot be retrieved back`**

**MSS**

1. User requests to list meetings.
1. Productiv shows list of meetings.
1. User requests to delete a specific meeting in the list.
1. Productiv deletes the meeting.
   User case ends.

    Use case ends.

**Extensions**

* 2a. The list is empty.
  
  * Use case ends.
     
* 3a. The given index is invalid.
    
    * 3a1. Productiv shows an error message.
    
      Use case resumes at step 2.
      
*{More to be added}*
      

### Non-Functional Requirements

1. Should work on any mainstream OS as long as it has Java 11 or above installed.
1. Should be able to hold up to 1000 contacts without any negative effects.
1. Should be able to hold up to 1000 deliverables without any negative effects.
1. Should be able to schedule meetings up to 2 years in advance.
1. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

*{More to be added}*

### Glossary

* **Mainstream OS**: Windows, Linux, Unix, OS-X.
* **Deliverable**: a thing able to be provided, especially as a product of a development process.
* **CRUD**: Create, Read, Update and delete.

*{More to be added}*

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</div>

### Launch and shutdown

1. Initial launch

   1. Download the jar file and copy into an empty folder

   1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

1. Saving window preferences

   1. Resize the window to an optimum size. Move the window to a different location. Close the window.

   1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

1. Shutdown
    1. Click the window close button _OR_
    1. Enter input: `exit`, to close the program. 
    
### Switching Modes

1. Via Mouse input
    1. Test case: Click `Deliverable` _OR_ Click `Meeting`<br>
    Expected: Window displays list of saved `deliverables` or `meetings`.

1. Via Command Line Input
    1. Testcase: `switch deliverable` or `switch meeting`<br>
    Expected: Window displays list of saved `deliverables` or `meetings`.
    
    1. Incorrect modes: `switch me3ting`, `switch dev`, `...`<br>
    Expected: Status bar throws error message.

### Deleting an item

1. Deleting an item while all items are being shown

   1. Test case: `delete 1`<br>
      Expected: First contact is deleted from the list. Details of the deleted contact shown in the status message. Timestamp in the status bar is updated.

   1. Test case: `delete 0`<br>
      Expected: No person is deleted. Error details shown in the status message. Status bar remains the same.

   1. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
      Expected: Similar to previous.


### Saving data
1. Data files are saved in a `data` folder.
    1. 3 json files are created: ``

1. Dealing with missing/corrupted data files

   1. Missing data files

1. _{ more test cases …​ }_
