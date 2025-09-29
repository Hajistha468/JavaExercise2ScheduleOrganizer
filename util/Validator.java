package util;

import java.util.regex.Pattern;

public class Validator {
    public static void validateTimeFormat(String t) {
        if (!Pattern.matches("^([01]?\\d|2[0-3]):[0-5]\\d$", t)) {
            throw new IllegalArgumentException("Error: Invalid time format.");
        }
    }

    public static boolean timesOverlap(String startA, String endA, String startB, String endB) {
        int sA = toMinutes(startA), eA = toMinutes(endA), sB = toMinutes(startB), eB = toMinutes(endB);
        return sA < eB && sB < eA;
    }

    private static int toMinutes(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
