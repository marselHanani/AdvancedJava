package DesignPrinciples.CompositionOverInheritance.problem;
/*
#Problems with Inheritance (Summary):
!-Interface Constraint: Subclasses must implement all abstract methods of the superclass, even if they are unnecessary.
!-Behavior Compatibility: Overridden methods must maintain compatibility with the superclass to avoid breaking code that expects the superclass.
!-Encapsulation Violation: Inheritance exposes the internal details of the superclass to subclasses, potentially leading to tighter coupling and reduced flexibility.
!-Tight Coupling: Subclasses depend heavily on superclasses, so changes in the superclass can break subclass functionality.
!-Hierarchy Bloat: Reusing code via inheritance in multi-dimensional cases leads to parallel inheritance hierarchies, causing excessive and complex class combinations.
 */
// الفئة الأساسية
abstract class Vehicle {
    public void drive() {
        System.out.println("Driving the vehicle normally");
    }
    public abstract void cargo();
}

// فئة فرعية تضيف سلوكيات جديدة
class Car extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving the car");
    }

    @Override
    public void cargo() {
        throw new UnsupportedOperationException("Cars don't have cargo");
    }

    public void honk() {
        System.out.println("Honking the car horn");
    }

}

class Truck extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving the truck");
    }

    public void cargo() {
        System.out.println("Loading cargo");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.drive();  // Driving the car

        Vehicle truck = new Truck();
        truck.drive(); // Driving the truck
    }
}//بالسيارة رغم انها ما بتلزم لانو يدوب مساحتها صغيرة جدا اصلا  cargo لفنكشن ال  implement  هون انجبرت اعمل 
