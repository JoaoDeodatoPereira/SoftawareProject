public class DeviceObserver implements Observer {
    private final String observerName;

    public DeviceObserver(String name) {
        this.observerName = name;
    }

    @Override
    public void update(String message) {
        System.out.println("[" + observerName + "] Notification: " + message);
    }
}
