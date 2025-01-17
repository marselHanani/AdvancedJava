package DesignPrinciples.InterfaceNotImplementation.solution;

class LightBulb implements Switchable {
    public void turnOn() {
        System.out.println("The light bulb is on");
    }
}
class LEDLamp implements Switchable {
    public void turnOn() {
        System.out.println("The LED lamp is on");
    }
}
class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
    }
}
public class Main {
    public static void main(String[] args) {
        Switchable bulb = new LightBulb(); // أو LEDLamp
        Switch lightSwitch = new Switch(bulb);
        lightSwitch.operate(); // يقوم بتشغيل المصباح أو اللمبة
        Switchable ledLamp = new LEDLamp();
        lightSwitch = new Switch(ledLamp);
        lightSwitch.operate();
    }
}
