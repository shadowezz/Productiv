---
layout: page
title: Clara Adora's Project Portfolio Page
---

## Project: Productiv

### Overview
Productiv is a desktop application for product managers to organise their product-related information. 
The user interacts with it using a CLI, and it has a GUI created with JavaFX. 
It is written in Java, and has about 20 kLoC.

### Summary of Contributions
**Code contributed**: [RepoSense](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=claraadora)
### New features and Enhancements
1 **New Feature**: Added the schedule/timeline feature. 
   * What it does: displays all `Deliverable`s and `Meeting`s in a single sorted-by-time list in the Dashboard
   * Justification: allows product managers to check their deliverables and meetings together in one place
   * Highlights: This new feature requires a thorough design analysis. Amendments and discussions were done to prevent couplings and preserve cohesiveness
1 **New Feature**: Added the auto-sorting of `Deliverable`s and `Meeting`s
   * What it does: auto-sorts `Deliverable`s and `Meeting`s in ascending chronological order.
   * Justification: allows product managers to view their most urgent deliverables and meetings quickly, in neat sorted-by-time lists
   * Highlights: Before settling with the current sorting implementation, an in-depth analysis of the `PriorityQueue` and binary search implementations was done
1 **Enhancement**: Designed the current UI/UX of Productiv.
   * What it does: enhances the UI/UX of Productiv to be slick, clean, and intuitive. 
   * Justification: Good UI/UX plays a significant role in user satisfaction and retention. 
   * Highlights: Designing the UI/UX is challenging but essential as Productiv has four modes. 
    Many designs were made and improved upon, before reaching the current clutter-free design.  
    
#### Documentation
1. User Guide
   * Wrote the Introduction section
   * Co-wrote the Meeting subsection in the Feature section
   * Added and edited all diagrams
   * Wrote the Command Summary tables
1. Developer Guide
   * Updated the Architecture sequence diagram and Model component object diagram
   * Added the implementation details of the Calendar and auto-sort feature

#### Team-based tasks
1. Restructured AB3 to allow the addition of the deliverable, meeting, and mode components
1. Added the skeleton of the Meeting component
1. Filled application with synchronized seed data that make sense and reflective of product managers' busy schedule
1. Updated user and developer guides that are not specific to my responsibilities

#### Community
1. Reported bugs and suggestions for a team [(link to issues)](https://github.com/claraadora/ped)
1. Reviewed PRs with non-trivial comments (examples: [\#32](), [\#98](), [\#108](), [\#52]())
1. Total PRs reviewed: 20+, Total comments given: 65+ 
