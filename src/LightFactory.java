public class LightFactory extends DeviceFactory {
    @Override
    public Device createDevice(String name) {
        return new Light(name);
    }
}
