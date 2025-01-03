package DesignPatterns.Creational.Factory.problem;
//?Factory Pattern :
//! separates the logic of creating objects from the client code. Instead of creating instances directly,
//! the client calls a factory method, and the factory decides which object to create.
//! This makes it easier to manage changes in object creation logic and adds flexibility when introducing new types of objects.
//*Cons:
//*More Complexity: Adds extra abstraction layer.
//*Extra Classes: Introduces additional factory classes.
// Without Factory: The client is directly responsible for creating objects
class Car {
    public void drive() {
        System.out.println("Driving a car...");
    }
}

class Truck {
    public void drive() {
        System.out.println("Driving a truck...");
    }
}

class VehicleClient {
    // Client directly creates the vehicle
    public void createVehicle(String type) {
        if (type.equals("car")) {
            Car car = new Car();
            car.drive();  // Client knows about Car class
        } else if (type.equals("truck")) {
            Truck truck = new Truck();
            truck.drive();  // Client knows about Truck class
        }
    }
}
/*
* إذا أضفنا نوعًا جديدًا من السيارات، علينا تعديل الكود في أماكن متعددة.
* الكود يعتمد بشكل مباشر على الفئات ال classes.
* صعوبة إضافة تغييرات مستقبلية دون تعديل الكثير من الأكواد.
* **/