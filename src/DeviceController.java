import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DeviceController {
    private final List<Device> devices;
    private final List<DeviceGroup> groups;
    private SmartHomeUser user;

    public DeviceController() {
        devices = new ArrayList<>();
        groups = new ArrayList<>();
    }

    public void setUser(String username) {
        this.user = new SmartHomeUser(username);
        System.out.println("User '" + username + "' is now registered and will receive notifications.");
    }

    public void addDevice() {
        if (user == null) {
            System.out.println("No user registered! Please set a user first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Device Type: 1. Light, 2. Fan, 3. Air Conditioner, 4. Television, 5. Heater");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter device name: ");
        String name = scanner.nextLine();

        DeviceFactory factory = getFactory(choice);
        if (factory != null) {
            Device device = factory.createDevice(name);
            devices.add(device);

            device.subscribe(user);

            System.out.println(name + " added successfully.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private DeviceFactory getFactory(int type) {
        return switch (type) {
            case 1 -> new LightFactory();
            case 2 -> new FanFactory();
            case 3 -> new AirConditionerFactory();
            case 4 -> new TelevisionFactory();
            case 5 -> new HeaterFactory();
            default -> null;
        };
    }

    public void addGroup() {
        if (user == null) {
            System.out.println("No user registered! Please set a user first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter group name: ");
        String name = scanner.nextLine();
        DeviceGroup group = new DeviceGroup(name);
        groups.add(group);

        group.subscribe(user);

        System.out.println("Group '" + name + "' created successfully.");
    }

    public void addDeviceToGroup() {
        if (groups.isEmpty()) {
            System.out.println("No groups available. Please create a group first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Groups:");
        for (int i = 0; i < groups.size(); i++) {
            System.out.println((i + 1) + ". " + groups.get(i).getName());
        }

        System.out.print("Select a group to add devices to: ");
        int groupChoice = scanner.nextInt();
        scanner.nextLine();

        if (groupChoice < 1 || groupChoice > groups.size()) {
            System.out.println("Invalid group selection.");
            return;
        }

        DeviceGroup selectedGroup = groups.get(groupChoice - 1);

        System.out.println("Available Devices:");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i).getName());
        }

        System.out.print("Select a device to add to the group: ");
        int deviceChoice = scanner.nextInt();

        if (deviceChoice < 1 || deviceChoice > devices.size()) {
            System.out.println("Invalid device selection.");
            return;
        }

        Device selectedDevice = devices.get(deviceChoice - 1);
        selectedGroup.addDevice(selectedDevice);
        System.out.println(selectedDevice.getName() + " added to group " + selectedGroup.getName());
    }

    public void controlDevice() {
        if (devices.isEmpty()) {
            System.out.println("No devices available.");
            return;
        }

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

    public void controlGroup() {
        if (groups.isEmpty()) {
            System.out.println("No groups available.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Groups:");
        for (int i = 0; i < groups.size(); i++) {
            System.out.println((i + 1) + ". " + groups.get(i).getName());
        }

        System.out.print("Select a group to control: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > groups.size()) {
            System.out.println("Invalid group selection.");
            return;
        }

        DeviceGroup group = groups.get(choice - 1);
        System.out.println("1. Turn On");
        System.out.println("2. Turn Off");
        System.out.print("Choose an action: ");
        int action = scanner.nextInt();

        if (action == 1) {
            group.turnOn();
        } else if (action == 2) {
            group.turnOff();
        } else {
            System.out.println("Invalid action.");
        }
    }

    public void showStatus() {
        System.out.println("Device Status:");

        Iterator<Device> deviceIterator = devices.iterator();
        while (deviceIterator.hasNext()) {
            Device device = deviceIterator.next();
            System.out.println(device.getName() + ": " + (device.isOn() ? "On" : "Off"));
        }

        for (DeviceGroup group : groups) {
            System.out.println(group.getName() + ": " + (group.isOn() ? "On" : "Off"));

            for (Device device : group) {
                System.out.println("  - " + device.getName() + ": " + (device.isOn() ? "On" : "Off"));
            }
        }
    }
}
