public class TelevisionFactory extends DeviceFactory {
    @Override
    public Device createDevice(String name) {
        return new Television(name);
    }
}
