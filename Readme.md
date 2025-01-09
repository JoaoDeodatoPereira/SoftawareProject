# Home Automation Project

## Introduction

This is a terminal-based home automation system developed in **Java**. It enables users to manage and control various devices such as lights, fans, air conditioners, televisions, and heaters. The system allows users to:

- Add new devices
- Turn devices on or off
- Check the current status of devices

All interactions are performed through a terminal interface.

The project demonstrates the application of six design patterns that enhance modularity, scalability, and maintainability. It is hosted on [GitHub](https://github.com/JoaoDeodatoPereira/SoftawareProject).
---

## Team Collaboration

This project was a collaborative effort between two team members, each focusing on different aspects of the application:

- **João Pereira**: Focused on the core application logic, implementing the **Singleton**, **Factory**, and **Facade** design patterns. Key contributions include:
  - `Main.java`
  - `HomeAutomationApp.java`
  - `DeviceController.java`
  - `DeviceFactory.java`

- **Chavdar Tsvetkov**: Focused on creating the interface and concrete device classes, implementing the **Observer** and **Iterator** design patterns. Key contributions include:
  - `Device.java`
  - Concrete device classes (`Light.java`, `Fan.java`, `AirConditioner.java`, `Television.java`, `Heater.java`)
  - Observer and Iterator logic for device management

Both team members contributed equally to ensure a balanced and comprehensive implementation of the program.

---

## Design Patterns

### Creational Patterns

#### 1. **Singleton Pattern**
- **Code**: The `HomeAutomationApp` class implements the Singleton pattern to ensure a single instance of the application during runtime.
- **Explanation**: The Singleton pattern ensures that only one instance of the `HomeAutomationApp` class exists. This is achieved by:
  - Making the constructor private.
  - Providing a static method `getInstance()` to retrieve the single instance.
- **Usage**: The Singleton pattern helps centralize the application logic, ensuring consistent behavior across the system.

#### 2. **Factory Pattern**
- **Code**: The `DeviceFactory` class implements the Factory pattern to create instances of different devices based on user input.
- **Explanation**: The Factory pattern encapsulates the logic of device creation. This approach:
  - Simplifies adding new device types.
  - Reduces the dependency of the main application logic on specific device implementations.
- **Usage**: Whenever a user adds a new device, the `DeviceFactory` is used to dynamically create the appropriate device instance.

---

### Structural Patterns

#### 1. **Facade Pattern**
- **Code**: The `DeviceController` class serves as a **Facade**, providing a simplified interface for managing devices.
- **Explanation**: The Facade pattern simplifies complex subsystem interactions by offering a unified interface. The `DeviceController` encapsulates device management, including:
  - Adding devices
  - Controlling devices
  - Displaying device statuses
- **Usage**: The `DeviceController` shields the core application logic from the internal details of device management, maintaining a clean separation of concerns.

#### 2. **Composite Pattern** (Optional)
- If included, this pattern demonstrates the ability to group devices, such as managing multiple lights as a single entity. This can be useful for representing hierarchical relationships between devices.

---

### Behavioural Patterns

#### 1. **Observer Pattern**
- **Code**: The `DeviceController` notifies devices of state changes using the Observer pattern.
- **Explanation**: The Observer pattern allows devices to subscribe to system events or changes. Devices can dynamically update their status based on user interactions or other system events.
- **Usage**: For instance, a "Master Switch" can notify all devices to turn on or off simultaneously.

#### 2. **Iterator Pattern**
- **Code**: The `DeviceController` uses the Iterator pattern to efficiently loop through the list of devices.
- **Explanation**: The Iterator pattern provides a way to access elements of a collection (e.g., devices) sequentially without exposing the underlying data structure.
- **Usage**: The `showStatus()` method in the `DeviceController` iterates through all devices to display their current status in a clean, maintainable manner.

---

## Conclusion

We believe that we created a stable project that has the required 6 design patterns. We tried to do it as simpler and efficient as possible so that it is easy to understand and use. All you have to do is run the terminal and choose the right actions. With that being said, we are happily waiting for your feedback.
