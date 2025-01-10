package DesignPatterns.Creational.Factory.Solution;
//?When to Use It:
//! When the exact type of object to create is determined dynamically or at runtime.
//! When you want to avoid tight coupling between the client and the classes it needs to instantiate.
//! When object creation involves complex logic and you want to centralize it in a single place.
//! When you want to provide different variants of an object but keep the client code simple and flexible.
//*Benefits:
//*Encapsulation: Centralizes object creation logic.
//*Decoupling: Client doesn't know specific class types.
//*Flexibility: Easy to add new object types without changing client code.

// Abstract class for vehicle (common interface)
// الخطوة 1: إنشاء واجهة أو فئة مجردة تمثل المنتج
interface Vehicle {
    void drive();
}

// الخطوة 2: إنشاء الفئات التي تمثل المنتجات الملموسة (Concrete Products)
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}

class Motorcycle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a motorcycle.");
    }
}

// الخطوة 3: إنشاء الفئة المجردة التي تحتوي على Factory Method
abstract class VehicleFactory {
    // Factory Method
    public abstract Vehicle createVehicle();

    public void deliverVehicle() {
        Vehicle vehicle = createVehicle();
        vehicle.drive();
    }
}

// الخطوة 4: إنشاء الفئات الملموسة التي تحقق من الفئة المجردة وتوفر المنتجات المناسبة
class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

class MotorcycleFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Motorcycle();
    }
}

// الخطوة 5: استخدام Factory Method
public class Client {
    public static void main(String[] args) {
        // إنشاء مصنع سيارة
        VehicleFactory carFactory = new CarFactory();
        carFactory.deliverVehicle(); // سيتم إنشاء سيارة وقيادتها

        // إنشاء مصنع دراجة نارية
        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        motorcycleFactory.deliverVehicle(); // سيتم إنشاء دراجة نارية وركوبها
    }
}
