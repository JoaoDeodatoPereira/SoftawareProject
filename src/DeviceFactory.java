public class DeviceFactory {
    public static Device createDevice(int type, String name) {
        return switch (type) {
            case 1 -> new Light(name);
            case 2 -> new Fan(name);
            case 3 -> new AirConditioner(name);
            case 4 -> new Television(name);
            case 5 -> new Heater(name);
            default -> null;
        };
    }
}