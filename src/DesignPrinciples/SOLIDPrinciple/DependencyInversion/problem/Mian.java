package DesignPrinciples.SOLIDPrinciple.DependencyInversion.problem;

/*
* ** Dependency Inversion Principle (DIP):
*1-high-level modules should not depend on low-level modules. Both should depend on abstractions.
*2-Abstractions should not depend on details. Details should depend on abstractions.
! the problems :
!1-Tight Coupling:High-level modules are directly dependent on low-level modules, making the system rigid and hard to modify.
!2-Difficult to Extend or Maintain:Adding new features or modifying existing ones can break existing code since
 !it depends on specific implementations.
!3-Hard to Test:Testing high-level modules in isolation becomes difficult because they directly rely on specific low-level modules.
 */
// Low-level module
class LightBulb {
    public void turnOn() {
        System.out.println("Light bulb turned on.");
    }

    public void turnOff() {
        System.out.println("Light bulb turned off.");
    }
}

// High-level module that depends on the low-level module
class Switch {
    private LightBulb bulb;

    public Switch(LightBulb bulb) {
        this.bulb = bulb;
    }

    public void operate() {
        bulb.turnOn();  // Direct dependency on the LightBulb class
    }
}