import java.util.Scanner;

public class HomeAutomationApp {
    private static HomeAutomationApp instance;
    private final DeviceController deviceController;

    private HomeAutomationApp() {
        deviceController = new DeviceController();
    }

    public static HomeAutomationApp getInstance() {
        if (instance == null) {
            instance = new HomeAutomationApp();
        }
        return instance;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        deviceController.setUser(username);

        while (true) {
            System.out.println("1. Add Device");
            System.out.println("2. Add Group");
            System.out.println("3. Add Device to Group");
            System.out.println("4. Control Device");
            System.out.println("5. Control Group");
            System.out.println("6. Show Status");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> deviceController.addDevice();
                case 2 -> deviceController.addGroup();
                case 3 -> deviceController.addDeviceToGroup();
                case 4 -> deviceController.controlDevice();
                case 5 -> deviceController.controlGroup();
                case 6 -> deviceController.showStatus();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
