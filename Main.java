import core.ScheduleManager;
import util.Logger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger.getInstance().info("Astronaut Daily Schedule Organizer Started");
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu: 1.Add Task 2.Remove Task 3.View Tasks 4.Exit");
            System.out.print("Select Option: ");
            String optionStr = sc.nextLine();
            int option;
            try {
                option = Integer.parseInt(optionStr.trim());
            } catch (Exception ex) {
                Logger.getInstance().error("Invalid option selected.");
                continue;
            }

            switch (option) {
                case 1:
                    scheduleManager.addTaskCLI(sc);
                    break;
                case 2:
                    scheduleManager.removeTaskCLI(sc);
                    break;
                case 3:
                    scheduleManager.viewTasksCLI();
                    break;
                case 4:
                    Logger.getInstance().info("Exiting application.");
                    System.exit(0);
                default:
                    Logger.getInstance().error("Invalid menu option.");
            }
        }
    }
}
