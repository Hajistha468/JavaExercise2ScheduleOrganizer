package core;

public enum TaskPriority {
    HIGH, MEDIUM, LOW;

    public static TaskPriority fromString(String input) {
        switch (input.trim().toLowerCase()) {
            case "high": return HIGH;
            case "medium": return MEDIUM;
            case "low": return LOW;
            default: throw new IllegalArgumentException("Invalid priority: " + input);
        }
    }
}
