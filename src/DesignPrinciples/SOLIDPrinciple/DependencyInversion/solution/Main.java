package DesignPrinciples.SOLIDPrinciple.DependencyInversion.solution;

//# Low-level module implementing the Switchable interface
class LightBulb implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Light bulb turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Light bulb turned off.");
    }
}

//# Another low-level module implementing the Switchable interface
class LEDLight implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("LED light turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("LED light turned off.");
    }
}

//# High-level module depends on abstraction (Switchable)
class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();  // Works with any Switchable device
    }
}
/*
Benefits After Applying DIP:
Reduced Coupling:
The high-level Switch class no longer depends on a concrete implementation (LightBulb). Instead, it depends on the abstract Switchable interface.
Increased Flexibility:
Now, you can easily add new types of Switchable devices (e.g., LEDLight, Fan) without changing the Switch class. This makes the system open for extension.
Easier Testing:
The Switch class can now be tested independently by mocking the Switchable interface, making unit tests simpler.
Maintains the Open/Closed Principle:
You can introduce new device types without modifying the existing high-level module (Switch), adhering to the Open/Closed Principle.
 */