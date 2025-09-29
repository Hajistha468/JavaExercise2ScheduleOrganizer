package util;

public class Logger {
    private static Logger INSTANCE = new Logger();

    private Logger() {}

    public static Logger getInstance() {
        return INSTANCE;
    }

    public void info(String msg) {
        System.out.println("[INFO] " + msg);
    }

    public void error(String msg) {
        System.err.println("[ERROR] " + msg);
    }
}
