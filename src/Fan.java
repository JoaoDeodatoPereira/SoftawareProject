import java.util.ArrayList;
import java.util.List;

public class Fan implements Device {
    private final String name;
    private boolean on;
    private final List<Observer> observers;

    public Fan(String name) {
        this.name = name;
        this.on = false;
        this.observers = new ArrayList<>();
    }

    @Override
    public void turnOn() {
        on = true;
        notifyObservers();
        System.out.println(name + " is now On.");
    }

    @Override
    public void turnOff() {
        on = false;
        notifyObservers();
        System.out.println(name + " is now Off.");
    }

    @Override
    public boolean isOn() {
        return on;
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
            observer.update(name + " is now " + (on ? "On" : "Off"));
        }
    }
}
