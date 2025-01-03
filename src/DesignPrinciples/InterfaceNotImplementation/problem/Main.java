package DesignPrinciples.InterfaceNotImplementation.problem;

class LightBulb  {
    public void turnOn() {
        System.out.println("The light Blue is on");
    }
}

class Switch {
    private LightBulb  Bulb ;
    public Switch(LightBulb  Bulb ) {
        this.Bulb  = Bulb ;
    }
    public void operate() {
        Bulb .turnOn();
    }
}
public class Main {
    public static void main(String[] args) {
        LightBulb  Bulb  = new LightBulb ();
        Switch lightSwitch = new Switch(Bulb );
        lightSwitch.operate(); // Turns on the light Bulb
    }
}
//# الكود الي فوق فيه مشكلة انو اذا بدي استخدم اشي غير ال LightBulb  بدي انجبر اعدل ال switch وهاد مش صح
