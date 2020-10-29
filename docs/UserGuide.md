---
layout: page
title: User Guide
---

*Productiv* is a desktop app that assists product managers like yourself with organising product-related information 
(**contacts**, **deliverables** and **meetings**) so that you can track your product's development more comprehensively 
and conveniently.

*Productiv* is optimized for use via Command Line Interface (CLI), but still has the benefits of a Graphical User 
Interface (GUI). Thus, if you can type fast, *Productiv* can get your product management tasks done faster than 
traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your computer.

1. Download the latest `Productiv.jar` from [here](https://github.com/AY2021S1-CS2103T-F11-2/tp/releases).

1. Copy the `.jar` file to your preferred folder.

1. Double-click the file to start *Productiv*. 
The GUI similar to the below should appear in a few seconds. 
Note that the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type a command in the command box and press Enter to execute it. 
Here are some example commands you can try:

   * **`switch`**`deliverable` : Switches to `deliverable` mode.

   * **`add`**`r/stk n/Betty Clarke p/98765432` : If in `contact` mode, adds a contact named `Betty Clarke`.

   * **`delete`**`1` : If in `meeting` mode, deletes the 1st meeting shown.

   * **`exit`** : Exits the app.

1. Refer to [Features](#features) below for details of each available command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by you.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/Jason`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [p/PHONE]` can be used as `n/Jason p/98890112` or as `n/Jason`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME e/EMAIL`, `e/EMAIL n/NAME` is also acceptable.

</div>

### General

#### Viewing help: `help`

Shows a message directing you to this User Guide.
![help](images/helpMessage.JPG)

Format: `help`

#### Switching modes: `switch`

Switches to either `contact`, `meeting` or `deliverable` mode.

Format: `switch MODE`
* Corresponding list of existing items will be displayed, e.g. `contact` mode will display all contacts.
* Subsequent commands will be with respect to the `MODE`.

Examples:
* `switch contact` switches to `contact` mode.
* `switch meeting` switches to `meeting` mode.

### Contact

#### Adding a contact: `add`

Adds a developer or stakeholder to the contact list.

Format: `add r/ROLE n/NAME [p/PHONE] e/EMAIL [d/DESCRIPTION]`
* `ROLE` is the type of contact, either developer (`dev`) or stakeholder (`stk`).
* `NAME` is the name of the contact.
* `PHONE` is the phone number of the contact.
* `EMAIL` is the email address of the contact.
* `DESCRIPTION` contains additional information about the contact, such as their job position.

Examples:
* `add r/dev n/Jordan Woods p/81234567 e/johndoe@glutter.com`
adds a developer with the name `Jordan Woods`, phone number `81234567` and email `jordanwoods@glutter.com`.
* `add r/stk n/Betsy Crowe e/betsybet872@pmail.com`
adds a stakeholder with the name `Betsy Crowe` and email `betsybet872@pmail.com`.

#### Editing a contact: `edit`

Edits an existing contact in the contact list.

Format: `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [d/DESCRIPTION]`
* `INDEX` is the index number of the contact in the displayed contact list.
* `INDEX` must be a positive integer.
* At least one of the optional fields must be provided.
* The existing values of the specified contact will be updated to the input values.

Examples:
*  `edit 1 p/81234567 e/jeremysand@glutter.com`
edits the phone number and home address of the 1st person to be `81234567` and `jeremysand@glutter.com` respectively.
*  `edit 2 n/Jayden Smith` 
edits the name of the 2nd contact to be `Jayden Smith`.

#### Listing all contacts: `list`

Shows a list of all contacts in the contact list.

Format: `list`

#### Finding contacts: `find`

Finds the contacts whose names or descriptions contain any of the given keywords.

Format: `find KEYWORDS`
* `KEYWORDS` contains one or more keywords used to match contacts.
* Searches only consider name and description.
* Searches are case-insensitive, e.g. `hans` will match `Hans`.
* Order of keywords does not matter, e.g. `Hans Bo` will match `Bo Hans`.
* Searches only account for full words, e.g. `Han` will not match `Hans`.
* Searches return contacts matching at least one keyword, e.g. `Hans Bo` will return `Hans Seed` and `Bo Yarns`.

Examples:
* `find John Kite` returns a contact with name `john kite` and another with description `Kite manufacturer`.
* `find Sun` returns a contact with name `Joe Sun` and another with description `Works at Sun Tools`.

#### Deleting a contact: `delete`

Deletes the specified contact from the contact list.

Format: `delete INDEX`
* `INDEX` is the index number of the contact in the displayed contact list.
* `INDEX` must be a positive integer.

Example:
* `delete 3` deletes the 3rd contact in the contact list.

#### Clearing all contacts: `clear`

Clears all contacts from the contact list.

Format: `clear`

### Deliverable

#### Adding a deliverable: `add`

Adds a deliverable to the deliverable list.

Format: `add t/TITLE m/MILESTONE [d/DESCRIPTION] [by/DEADLINE] [c/CONTACTS]`
* `TITLE` is the main heading of the deliverable.
* `MILESTONE` is the milestone tagged to the deliverable.
* `MILESTONE` takes in numerical values separated by periods, e.g. `1.3`, `14.2.1`.
* `DESCRIPTION` contains additional information about the deliverable, e.g. sub-requirements. 
* `DEADLINE` is the due date time of the deliverable in DD-MM-YYYY HH:mm format.
* `CONTACTS` represents the contacts involved in seeing through the deliverable.
* `CONTACTS` is a comma-separated string of the index numbers of these contacts, as specified in the contact list.

Examples:
* `add t/Login screen m/1.1 d/Include email and password fields c/2,4` 
adds a deliverable with the title `Login screen`, milestone `1.1`, 
description `Include email and password fields` and contacts `2,4`.
* `add t/Find profile page template m/2.1.1 by/12-12-2020 12:00` 
adds a deliverable with the title `Find profile page template`, milestone `2.1.1` 
and deadline `12-12-2020 12:00`.

#### Editing a deliverable: `edit`

Edits an existing deliverable in the deliverable list.

Format: `edit INDEX [t/TITLE] [m/MILESTONE] [d/DESCRIPTION] [by/DEADLINE] [c/CONTACTS]`
* `INDEX` is the index number of the deliverable in the displayed deliverable list.
* `INDEX` must be a positive integer.
* At least one of the optional fields must be provided.
* The existing values of the specified deliverable will be updated to the input values.

Examples:
*  `edit 1 d/Must include username, email and password fields by/13-12-2020 12:00`
edits the description of the 1st deliverable to be `Must include username, email and password fields`
and its deadline to be `13-12-2020 12:00`.
*  `edit 2 c/2,4,5` edits the contacts of the 2nd deliverable to be `2,4,5`.

#### Marking a deliverable as completed: `done`

Marks the specified deliverable from the deliverable list as done.

Format: `done INDEX`
* `INDEX` is the index number of the deliverable in the displayed deliverable list.
* `INDEX` must be a positive integer.

Example:
* `done 1` marks the 1st deliverable in the deliverable list as done.

#### Deleting a deliverable: `delete`

Deletes the specified deliverable from the deliverable list.

Format: `delete INDEX`
* `INDEX` is the index number of the deliverable in the displayed deliverable list.
* `INDEX` must be a positive integer.

Example:
* `delete 2` deletes the 2nd deliverable in the deliverable list.

### Meeting

#### Adding a meeting: `add`

Adds a meeting to the meeting list.

Format: `add t/TITLE [d/DESCRIPTION] from/FROM to/TO [c/CONTACTS] [l/LOCATION]`
* `TITLE` is the main heading of the meeting.
* `DESCRIPTION` contains additional details about the meeting, e.g. agenda. 
* `FROM` is the start date time of the meeting in DD-MM-YYYY HH:mm format.
* `TO` is the end date time of the meeting in DD-MM-YYYY HH:mm format.
* `CONTACTS` represents the contacts involved in the meeting.
* `CONTACTS` is a comma-separated string of the index numbers of these contacts, as specified in the contact list.
* `LOCATION` is the location of the meeting.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Input an estimate end date time for the meeting if there is none specified.
</div>

Example:
* `add t/Discuss app requirements d/Refine with business associates from/12-12-2020 09:00 to/12-12-2020 10:00 c/3,6,9`
adds a meeting with the title `Discuss app requirements`, description `Refine with business associates`, 
start date time `12-12-2020 09:00`, end date time `12-12-2020 10:00` and contacts `3,6,9`.
* `add t/User research review from/15-12-2020 13:00 to/15-12-2020 15:00 l/Meeting room A` 
adds a meeting with the title `User research review`, start date time `15-12-2020 13:00`, 
end date time `15-12-2020 15:00` and location `Meeting room A`.

#### Editing a meeting: `edit`

Edits an existing meeting in the meeting list.

Format: `edit INDEX [t/TITLE] [d/DESCRIPTION] [from/FROM] [to/TO] [c/CONTACTS] [l/LOCATION]`
* `INDEX` is the index number of the meeting in the displayed meeting list.
* `INDEX` must be a positive integer.
* At least one of the optional fields must be provided.
* The existing values of the specified meeting will be updated to the input values.

Examples:
* `edit 2 t/Discuss final release features d/Finalize dashboard functions`
edits the title of the 2nd meeting to be `Discuss final release features` 
and its description to be `Finalize dashboard functions`.
* `edit 4 c/3,6,8` edits the contacts of the 4th meeting to be `3,6,8`.

#### Deleting a meeting: `delete`

Deletes the specified meeting from the meeting list.

Format: `delete INDEX`
* `INDEX` is the index number of the meeting in the displayed meeting list.
* `INDEX` must be a positive integer.

Examples:
* `delete 3` deletes the 3rd meeting in the meeting list.

### Exiting the program: `exit`

Exits the program.

Format: `exit`

### Saving the data

*Productiv* data are saved in your computer's hard disk automatically after any command that changes it. 
There is no need to save manually.

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I start using *Productiv*?<br>
**A**: You can refer to our [Quick Start Guide](#quick start).

**Q**: Which operating systems can I run *Productiv* on?<br>
**A**: Currently, *Productiv* is supported on both Mac and Windows. Just ensure 
that you have Java `11` or above installed on your computer.

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it 
creates with the file that contains the data of your previous *Productiv* app.


--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Switch** | `switch MODE` <br> e.g. `switch deliverable`
**Add (Contact)** | `add r/ROLE n/NAME [p/PHONE] e/EMAIL [d/DESCRIPTION]` <br> e.g. `add r/stk n/Jenny Ho e/jennyho@pmail.com`
**Edit (Meeting)** | `edit INDEX [t/TITLE] [desc/DESCRIPTION] [from/FROM] [to/TO] [c/CONTACTS] [l/LOCATION]` <br> e.g. `edit 2 l/Level 8 Meeting Room 1`
**Mark Done (Deliverable)** | `done INDEX` <br> e.g. `done 2`
**List** | `list`
**Find** | `find KEYWORDS` <br> e.g. `find Bond James`
**Delete** | `delete INDEX` <br> e.g. `delete 3`
**Clear** | `clear`
**Help** | `help`
**Exit** | `exit`
