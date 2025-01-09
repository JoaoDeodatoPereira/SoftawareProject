import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeviceController {
    private final List<Device> devices;

    public DeviceController() {
        devices = new ArrayList<>();
    }

    public void addDevice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Device Type: 1. Light, 2. Fan, 3. Air Conditioner, 4. Television, 5. Heater");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter device name: ");
        String name = scanner.nextLine();
        Device device = DeviceFactory.createDevice(choice, name);
        if (device != null) {
            devices.add(device);
            System.out.println(name + " added successfully.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void controlDevice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Devices:");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i).getName());
        }
        System.out.print("Select a device to control: ");
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= devices.size()) {
            Device device = devices.get(choice - 1);
            System.out.println("1. Turn On");
            System.out.println("2. Turn Off");
            System.out.print("Choose an action: ");
            int action = scanner.nextInt();
            if (action == 1) {
                device.turnOn();
            } else if (action == 2) {
                device.turnOff();
            } else {
                System.out.println("Invalid action.");
            }
        } else {
            System.out.println("Invalid device.");
        }
    }

    public void showStatus() {
        System.out.println("Device Status:");
        for (Device device : devices) {
            System.out.println(device.getName() + ": " + (device.isOn() ? "On" : "Off"));
        }
    }
}
