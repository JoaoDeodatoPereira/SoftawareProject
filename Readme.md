# 🏡 Home Automation Project

## 📄 Introduction

Welcome to the **Home Automation System**, a terminal-based application developed in **Java**. This system allows users to manage and control a variety of devices, including:

- 💡 **Lights**
- 🌬️ **Fans**
- ❄️ **Air Conditioners**
- 🎥 **Televisions**
- 🔥 **Heaters**

### Key Features:
- Add new devices seamlessly
- Turn devices **ON** or **OFF** with ease
- Monitor the current status of all connected devices
- Add an user
- Create and manage groups

All interactions are handled via a user-friendly terminal interface.

> **Hosted on GitHub:** [Home Automation Repository](https://github.com/JoaoDeodatoPereira/SoftawareProject)

---

## 👥 Team Collaboration

This project was a collaborative effort between two team members, each specializing in different components of the system:

### **João Pereira**
- **Focus:** Core application logic
- **Design Patterns Implemented:** `Singleton`, `Factory`, `Facade`
- **Key Contributions:**
  - `Main.java`
  - `HomeAutomationApp.java`
  - `DeviceController.java`
  - `DeviceFactory.java`

### **Chavdar Tsvetkov**
- **Focus:** Interface development & concrete device classes
- **Design Patterns Implemented:** `Observer`, `Iterator`, `Composite`
- **Key Contributions:**
  - `Device.java`
  - Concrete device classes (`Light.java`, `Fan.java`, `AirConditioner.java`, `Television.java`, `Heater.java`)
  - Observer and Iterator logic for dynamic device management

> Both team members collaborated equally to ensure a robust and comprehensive system.

---

## 🔄 Design Patterns

This project showcases **6 key design patterns** to promote modularity, scalability, and maintainability.

### 📍 Creational Patterns

#### 1. **Singleton Pattern**
- **Implemented In:** `HomeAutomationApp`
- **Purpose:** Ensures only one instance of the application exists.
- **Key Features:**
  - Private constructor
  - Static `getInstance()` method
- **Benefit:** Centralizes application logic, ensuring consistent system behavior.

#### 2. **Factory Pattern**
- **Implemented In:** `DeviceFactory`
- **Purpose:** Creates device instances dynamically based on user input.
- **Key Features:**
  - Simplifies the addition of new device types
  - Reduces dependencies in the main application logic
- **Benefit:** Enhances flexibility when adding new devices.

---

### 🛠️ Structural Patterns

#### 3. **Facade Pattern**
- **Implemented In:** `DeviceController`
- **Purpose:** Provides a simplified interface for complex device management operations.
- **Key Features:**
  - Adds, controls, and displays device statuses
  - Shields core logic from subsystem complexities
- **Benefit:** Maintains clean, organized code with clear separation of concerns.

#### 4. **Composite Pattern**
- **Potential Use:** Grouping devices (e.g., managing multiple lights as a single entity).
- **Benefit:** Represents hierarchical relationships effectively.

---

### 🚀 Behavioral Patterns

#### 5. **Observer Pattern**
- **Implemented In:** `DeviceController`
- **Purpose:** Notifies devices of state changes dynamically.
- **Key Features:**
  - Devices subscribe to system events
  - Enables automatic updates based on user actions
- **Benefit:** Facilitates features like a "Master Switch" to control multiple devices simultaneously.

#### 6. **Iterator Pattern**
- **Implemented In:** `DeviceController`
- **Purpose:** Efficiently iterates through device collections.
- **Key Features:**
  - Sequential access without exposing underlying data structures
  - Clean, maintainable code for status display
- **Benefit:** Simplifies device management, especially when scaling.

---

## 🌟 Conclusion

We are proud to present a **stable, efficient, and easy-to-use** home automation system, demonstrating the effective use of six core design patterns.

- ✅ **Simple** and intuitive terminal interface
- ⚖️ **Balanced** contributions ensuring comprehensive functionality
- 🌍 **Scalable** architecture for future enhancements

We look forward to your **feedback**. Thank you for exploring our project!

