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
        while (true) {
            System.out.println("1. Add Device");
            System.out.println("2. Control Device");
            System.out.println("3. Show Status");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> deviceController.addDevice();
                case 2 -> deviceController.controlDevice();
                case 3 -> deviceController.showStatus();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}