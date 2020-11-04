---
layout: page
title: Chrystal Quek's Project Portfolio Page
---

## Project: Productiv

Productiv is a desktop application for product managers to organise their product-related information. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature**: Added the ability to switch modes.
 * What it does: allows the user to `switch` to the different modes of the app - `db` (dashboard), `dv` (deliverable), `m` (meeting) or `c` (contact). Subsequent commands are executed with respect to the current mode.
 * Justification: This feature improves the user experience significantly because the user can just choose to see only deliverable, meeting or contact related information. This makes the application less cluttered and more organised. 
 * Also the user can remember less commands, e.g. the `add` command word can be used to add a deliverable, meeting or contact, depending on the mode the user is currently in.
 * Highlights: This feature was very difficult to implement and required significant restructuring of the entire application. I had to make the UI change whenever there was a switch in mode and ensure that the subsequent commands were passed to the correct `LogicManagers` for execution.
 * As the command is very short, e.g. `switch db` instead of `switch dashboard`, it is customised to the needs of fast typists. Also, a warning message is shown when users attempt to switch to the same mode. These change were made after considering the recommendations from PED.
 * Add screenshot?

* **New Feature**: Update person to contact that is more useful for product-management.
 * What it does: allows the user to keep track of the developers and stakeholders that are involved in the development of the product. Contacts can have a role - developer or stakeholder and also a description.
 * Justification: A product manager needs more than just an address book. A product manager needs to remember
 * Highlights:
 * Role
 * Remove Address, Tag
 * Implement Find for not just Name but also Description
 
* **New Feature**: Improved UI for list of items.
 * Table-like format, neat
 * Only compulsory fields that are more important to user

* **Example New Feature**: Added the ability to undo/redo previous commands.
  * What it does: allows the user to undo all previous commands one at a time. Preceding undo commands can be reversed by using the redo command.
  * Justification: This feature improves the product significantly because a user can make mistakes in commands and the app should provide a convenient way to rectify them.
  * Highlights: This enhancement affects existing commands and commands to be added in future. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=chrystalquek)

* **Project management**:
  * Managed releases `v1.3` - `v1.5rc` (3 releases) on GitHub

* **Enhancements to existing features**:
  * Updated the GUI color scheme (Pull requests [\#33](), [\#34]())
  * Wrote additional tests for existing features to increase coverage from 88% to 92% (Pull requests [\#36](), [\#38]())

* **Documentation**:
  * User Guide:
    * Updated documentation for feature `contact`
    * Added documentation for feature `dashboard`: [\#72]()
    * Did cosmetic tweaks to existing documentation of features `deliverable`, `meeting`: [\#74]()
  * Developer Guide:
    * Added implementation details of the `switch` feature with UML diagram no.
    * Updated Appendix: Requirements and Appendix: Instructions for manual testing.
    * (tbc) ...
    
* **Contributions to team-based tasks**:
  * Necessary general code enhancements
      * Updated Person to Contact to be more useful for product-management
      * Changed product icon and name
      * Renamed jar file
  * Enabled assertions in Gradle
  * Updating user/developer docs that are not specific to a feature...
  * Clarified and followed up with reviewers of PED on behalf of team
  * Standardized App feedback messages: [\#12]()

* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#12](), [\#32](), [\#19](), [\#42]()
  * Reported bugs and suggestions for other teams (examples: [1](), [2](), [3]())

* _{you can add/remove categories in the list above}_

* how deep the enhancement is, why it is complete, how hard it was to implement...

