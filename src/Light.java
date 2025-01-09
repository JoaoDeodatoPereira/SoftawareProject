public class Light implements Device {
    private final String name;
    private boolean on;

    public Light(String name) {
        this.name = name;
        this.on = false;
    }

    @Override
    public void turnOn() {
        on = true;
        System.out.println(name + " is now On.");
    }

    @Override
    public void turnOff() {
        on = false;
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
}
