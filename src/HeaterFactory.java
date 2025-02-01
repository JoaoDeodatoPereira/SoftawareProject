public class HeaterFactory extends DeviceFactory {
    @Override
    public Device createDevice(String name) {
        return new Heater(name);
    }
}
