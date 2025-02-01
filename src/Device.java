import java.util.List;

public interface Device {
    void turnOn();
    void turnOff();
    boolean isOn();
    String getName();

    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}
