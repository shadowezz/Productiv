---
layout: page
title: Clara Adora's Project Portfolio Page
---

## Project: Productiv

Productiv is a desktop application for product managers to organise their product-related information.
It is written in Java and has about 10 kLoC.

Given below are my contributions to the project.

### Enhancements
1. **New Feature**: Added the schedule/timeline feature. 
   * What it does: displays all `Deliverable`s and `Meeting`s in a single sorted-by-time list in the Dashboard
   * Justification: allows product managers to check their deliverables and meetings together in one place
   * Highlights: This enhancement requires a thorough design analysis. Amendments and discussions were done to prevent couplings and preserve cohesiveness
1. **New Feature**: Added the auto-sorting of `Deliverable`s and `Meeting`s
   * What it does: auto-sorts `Deliverable`s and `Meeting`s in ascending chronological order.
   * Justification: allows product managers to view their most urgent deliverables and meetings quickly, in neat sorted-by-time lists
   * Highlights: Before settling with the current sorting implementation, an in-depth analysis of the `PriorityQueue` and binary search implementations was done

[Link to contributed code](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=claraadora&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

#### Documentation
1. User Guide
   * Wrote the Introduction section
   * Co-wrote the Meeting subsection in the Feature section
   * Added all diagrams
   * Wrote the Command Summary tables
1. Developer Guide
   * Added the implementation details of the `Calendar` and auto-sort feature
   * Updated Architecture sequence diagrams and Model component object diagram

#### Team-Based tasks
1. Designed the current UI of the application comprehensively using Adobe XD
1. Added the skeleton of the Meeting component
1. Restructured AB3 to allow the addition of the deliverable, meeting, and mode components
1. Updated user and developer guides that are not specific to my responsibilities
1. Filled application with synchronized seed data that make sense and reflective of product managers' busy schedule

#### Community
1. Reported bugs and suggestions for a team [(link to issues)](https://github.com/claraadora/ped)
1. Reviewed PRs with non-trivial comments (examples: [\#32](), [\#98](), [\#108](), [\#52]())
