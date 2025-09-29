package core;
import util.Validator;

public class TaskFactory {
    public static Task createTask(String desc, String start, String end, String priority) {
        Validator.validateTimeFormat(start);
        Validator.validateTimeFormat(end);
        TaskPriority taskPriority = TaskPriority.fromString(priority);
        return new Task(desc, start, end, taskPriority);
    }
}
