import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeviceGroup implements Device, Iterable<Device> {
    private final String name;
    private final List<Device> devices;
    private final List<Observer> observers;

    public DeviceGroup(String name) {
        this.name = name;
        this.devices = new ArrayList<>();
        this.observers = new ArrayList<>();
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
        notifyObservers();
    }

    @Override
    public void turnOff() {
        System.out.println(name + " group is now Off.");
        for (Device device : devices) {
            device.turnOff();
        }
        notifyObservers();
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

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(name + " group is now " + (isOn() ? "On" : "Off"));
        }
    }

    @Override
    public Iterator<Device> iterator() {
        return devices.iterator();
    }
}
