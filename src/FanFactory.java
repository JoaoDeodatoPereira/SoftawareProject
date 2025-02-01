public class FanFactory extends DeviceFactory {
    @Override
    public Device createDevice(String name) {
        return new Fan(name);
    }
}
