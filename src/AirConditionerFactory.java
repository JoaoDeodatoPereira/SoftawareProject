public class AirConditionerFactory extends DeviceFactory {
    @Override
    public Device createDevice(String name) {
        return new AirConditioner(name);
    }
}
