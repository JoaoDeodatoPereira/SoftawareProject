public class SmartHomeUser implements Observer {
    private final String username;

    public SmartHomeUser(String username) {
        this.username = username;
    }

    @Override
    public void update(String message) {
        System.out.println("[User: " + username + "] Notification: " + message);
    }

    public String getUsername() {
        return username;
    }
}
