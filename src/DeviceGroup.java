import java.util.ArrayList;
import java.util.List;

public class DeviceGroup implements Device {
    private final String name;
    private final List<Device> devices;

    public DeviceGroup(String name) {
        this.name = name;
        this.devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " group is now On.");
        for (Device device : devices) {
            device.turnOn();
        }
    }

    @Override
    public void turnOff() {
        System.out.println(name + " group is now Off.");
        for (Device device : devices) {
            device.turnOff();
        }
    }

    @Override
    public boolean isOn() {
        for (Device device : devices) {
            if (device.isOn()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}

