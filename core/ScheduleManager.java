package core;

import exception.ScheduleException;
import observer.ConflictObserver;
import observer.Observable;
import observer.Observer;
import util.Logger;
import util.Validator;

import java.util.*;

public class ScheduleManager extends Observable {
    private static ScheduleManager INSTANCE;
    private final List<Task> tasks = new ArrayList<>();

    private ScheduleManager() {
        addObserver(new ConflictObserver());
    }

    public static synchronized ScheduleManager getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ScheduleManager();
        return INSTANCE;
    }

    public void addTaskCLI(Scanner sc) {
        try {
            System.out.print("Task Description: ");
            String desc = sc.nextLine();
            System.out.print("Start Time (HH:mm): ");
            String start = sc.nextLine();
            System.out.print("End Time (HH:mm): ");
            String end = sc.nextLine();
            System.out.print("Priority (High/Medium/Low): ");
            String priority = sc.nextLine();

            Task newTask = TaskFactory.createTask(desc, start, end, priority);
            if (isConflict(newTask)) {
                notifyObservers("Error: Task conflicts with existing task.");
            } else {
                tasks.add(newTask);
                notifyObservers("Task added successfully. No conflicts.");
            }
        } catch (Exception ex) {
            Logger.getInstance().error("Add Task Failed: " + ex.getMessage());
        }
    }

    public void removeTaskCLI(Scanner sc) {
        System.out.print("Enter Task Description to Remove: ");
        String desc = sc.nextLine();
        Task toRemove = null;
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(desc)) {
                toRemove = t;
                break;
            }
        }
        if (toRemove == null) {
            notifyObservers("Error: Task not found.");
        } else {
            tasks.remove(toRemove);
            notifyObservers("Task removed successfully.");
        }
    }

    public void viewTasksCLI() {
        if (tasks.isEmpty()) {
            notifyObservers("No tasks scheduled for the day.");
            return;
        }
        tasks.sort(Comparator.comparing(Task::getStartTime));
        for (Task t : tasks) {
            System.out.println(t.getStartTime() + " - " + t.getEndTime() + ": " + t.getDescription() + " [" + t.getPriority() + "]" + (t.isCompleted() ? " (Completed)" : ""));
        }
    }

    private boolean isConflict(Task newTask) {
        for (Task t : tasks) {
            if (Validator.timesOverlap(newTask.getStartTime(), newTask.getEndTime(), t.getStartTime(), t.getEndTime())) {
                notifyObservers("Error: Task conflicts with existing task \"" + t.getDescription() + "\".");
                return true;
            }
        }
        return false;
    }
}
