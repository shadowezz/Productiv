---
layout: page
title: User Guide
---

Productiv is a **desktop app for product owners/managers to oversee the development 
of their product, optimized for use via a Command Line Interface** (CLI) while still 
having the benefits of a Graphical User Interface (GUI). If you can type fast, Productiv 
can get your product management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `Productiv.jar` from [Coming Soon].

1. Copy the file to the folder you want to use as the _home folder_ for Productiv.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`switch contact`** and pressing Enter will switch to the Contact mode.<br>
   Some example commands you can try:

   * **`switch deliverable`** : Switches to `deliverable` mode.

   * **`add`**`stk n/Betty Clarke p/98765432` : Adds a contact named `Betty Clarke` to Productiv.

   * **`delete`**`1` : If in Contact mode, deletes the 1st contact shown.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>

### General

#### [Coming Soon] Viewing help: `help`

Shows a message that explains how to access the help page.

Format: `help`

#### Switching modes: `switch`

Switches to either `contact`, `meeting` or `deliverable` mode.

Format: `switch MODE`
* Subsequent commands will be with respect to managing the mode.

Examples:
* `switch contact`
* `switch meeting`

### Contact

#### Adding a contact: `add`

Adds a developer or stakeholder to the contact list.

Format: `add ROLE n/NAME p/PHONE_NUMBER [e/EMAIL] [a/ADDRESS] [t/TAG]`
* `ROLE` is the type of contact - developer (`dev`) or stakeholder (`stk`).
* `NAME` is the name of the contact.
* `PHONE_NUMBER` is the phone number of the contact.
* `EMAIL` is the email address of the contact.
* `ADDRESS` is the home address of the contact.
* `TAG` is the job position of the contact.

Examples:
* `add dev n/John Doe p/81234567 e/johndoe@gutter.com a/John street`
Adds a developer with the name `John Doe`, phone number `81234567`,
email `johndoe@gutter.com`, and address `John street`.
* `add stk n/Betsy Crowe p/87654321`
Adds a stakeholder with the name `Betsy Crowe` and phone number `87654321`.


### Editing a contact: `edit`

Edits an existing developer or stakeholder in the contact list.

Format: `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]`
* Edits the contact at the specified `INDEX`.
* `INDEX` is the index number of the contact in the displayed contact list.
* `INDEX` **must be a positive integer** 1, 2, 3, ...
* At least one of the optional fields must be provided.
* The existing values of the specified contact will be updated to the input values.

Examples:
*  `edit 1 p/81234567 a/Fifth Avenue`
Edits the phone number and home address of the 1st person to be `81234567` and `Fifth Avenue` respectively.
*  `edit 2 e/` 
Edits the email address of the 2nd contact to be empty, thus clearing the email address field.

### Deleting a contact: `delete`

Deletes the specified developer or stakeholder from the contact list.

Format: `delete INDEX`

* Deletes the contact at the specified `INDEX`.
* `INDEX` is the index number of the contact in the displayed contact list.
* `INDEX` **must be a positive integer** 1, 2, 3, ...

Examples:
* `delete 3` deletes the 3rd contact in the contact list.

### Deliverable

#### Adding a deliverable `add`

Adds a deliverable to the deliverable list.

Format: `add t/TITLE [desc/DESCRIPTION] [dead/DEADLINE] [c/CONTACT]…`​`
* `TITLE` is the main heading of the deliverable.
* `DESCRIPTION` is the additional details of the deliverable (e.g. sub-requirements). 
* `DEADLINE` is the due date time of the deliverable in DD-MM-YYYY HH:MM format.
* `CONTACTS` represents the contact(s) involved in meeting the deliverable.
* `CONTACTS` is a comma-separated list of the index numbers of these contacts, as specified in the contact list.

Examples:
* `add t/Login screen desc/Must include username and password fields dead/12-12-2020 23:59 c/2,4` 
Adds a deliverable with the title `Login screen`, description `Must include username and password fields`,
deadline `12-12-2020 23:59` and contacts with index `2` and `4` in the contact list.

### Editing a deliverable: `edit`

Edits an existing deliverable in the deliverable list.

Format: `edit INDEX [t/TITLE] [desc/DESCRIPTION] [dead/DEADLINE] [c/CONTACTS]`
* Edits the deliverable at the specified `INDEX`.
* `INDEX` is the index number of the deliverable in the displayed deliverable list.
* `INDEX` **must be a positive integer** 1, 2, 3, ...
* At least one of the optional fields must be provided.
* The existing values of the specified deliverable will be updated to the input values.

Examples:
*  `edit 1 desc/Must include username, email and password fields dead/19-12-2020 23:59`
Edits the description of the 1st deliverable to be `Must include username, email and password fields`
and pushes back the deadline of the deliverable by one week to `19-12-2020 23:59`.
*  `edit 2 desc/` Clears the description of the 2nd deliverable.

### Marking a deliverable as completed: `done`

Marks the specified deliverable from the deliverable list as done.

Format: `done INDEX`
* Marks the deliverable at the specified `INDEX` as done.
* `INDEX` is the index number of the deliverable in the displayed deliverable list.
* `INDEX` **must be a positive integer** 1, 2, 3, ...
* Deliverable at `INDEX` must be currently not marked as completed.

Examples:
* `done 1` marks the 1st deliverable in the deliverable list as done.

### Deleting a deliverable: `delete`

Deletes the specified deliverable from the deliverable list.

Format: `delete INDEX`

* Deletes the deliverable at the specified `INDEX`.
* `INDEX` is the index number of the deliverable in the displayed deliverable list.
* `INDEX` **must be a positive integer** 1, 2, 3, ...

Examples:
* `delete 2` deletes the 2nd deliverable in the deliverable list.

### Meeting

#### Adding a meeting: `add`

Adds a meeting to the meeting list.

Format: `add t/TITLE [desc/DESCRIPTION] from/FROM [to/TO] [c/CONTACTS] [l/LOCATION]`
* `TITLE` is the main heading of the meeting.
* `DESCRIPTION` is the additional details of the meeting (e.g. agenda). 
* `FROM` is the start date time of the meeting in DD-MM-YYYY HH:MM format.
* `TO` is the end date time of the meeting in DD-MM-YYYY HH:MM format.
* `CONTACTS` represents the contact(s) involved in the meeting.
* `CONTACTS` is a comma-separated list of the index numbers of these contacts, as specified in the contact list.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A meeting can have no specific end time.
</div>

Examples:
* `add t/Discuss app requirements desc/Refine functional requirements with 
business associates from/12-12-2020 08:00 to/12-12-2020 09:00 c/3,6,9`
Adds a meeting with the title `Discuss app requirements`, description `Refine functional requirements 
with business associates`, start date time `12-12-2020 08:00`, end date time `12-12-2020 09:00` and 
the attendees are contacts with index `3`, `6` and `9` in the contact list.

### Editing a meeting: `edit`

Edits an existing meeting in the meeting list.

Format: `edit INDEX [t/TITLE] [desc/DESCRIPTION] [from/FROM] [to/TO] [c/CONTACTS] [l/LOCATION]`
* Edits the meeting at the specified `INDEX`.
* `INDEX` is the index number of the meeting in the displayed meeting list.
* `INDEX` **must be a positive integer** 1, 2, 3, ...
* At least one of the optional fields must be provided.
* The existing values of the specified meeting will be updated to the input values.

Examples:
* `edit 3 t/Discuss final release features desc/Finalize dashboard functions`
Edits the 3rd meeting by replacing its title with `Discuss final release features` 
and description `Finalize dashboard functions`.

### Deleting a meeting: `delete`

Deletes the specified meeting from the meeting list.

Format: `delete INDEX`

* Deletes the meeting at the specified `INDEX`.
* `INDEX` is the index number of the meeting in the displayed meeting list.
* `INDEX` **must be a positive integer** 1, 2, 3, ...

Examples:
* `delete 4` deletes the 4th meeting in the meeting list.

### Exiting the program: `exit`

Exits the program.

Format: `exit`

### Saving the data

Productiv data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it 
creates with the file that contains the data of your previous Productiv home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Mode** | `mode`
**Add (Contact)** | `add ROLE n/NAME p/PHONE_NUMBER [e/EMAIL] [a/ADDRESS] [t/TAG]` <br> e.g., `add stk n/Jenny Ho p/98981212 e/jennyho@pmail.com`
**Edit (Meeting)** | `edit INDEX [t/TITLE] [desc/DESCRIPTION] [from/FROM] [to/TO] [c/CONTACTS] [l/LOCATION]` <br> e.g., `edit 2 l/Blk C Level 8 Meeting Room 1`
**Mark Deliverable as Done** | `done INDEX` <br> e.g., `done 2`
**Delete** | `delete INDEX` <br> e.g., `delete 3`
**Exit** | `exit`
