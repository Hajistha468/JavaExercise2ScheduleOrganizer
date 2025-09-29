# Astronaut Daily Schedule Organizer - Exercise 2

## Overview

This is a console-based application to help astronauts organize their daily tasks.

### Features

- Add a task with description, start and end time, priority
- Remove existing tasks
- View all tasks sorted by start time
- Validate tasks so they do not overlap
- Notify users on conflicts using Observer pattern
- Mark tasks as completed (optional)
- View tasks by priority (optional)

## Design Patterns Used

- **Singleton:** For ScheduleManager that manages tasks globally  
- **Factory:** For creating Task objects  
- **Observer:** To notify users when conflicts occur  

## How to Run

- Compile and run the `Main` class for Exercise 2  
- Follow prompts on the console to add, remove, or view tasks

