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
interface Vehicle {
    void drive();
}

// Concrete classes for vehicles
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car...");
    }
}

class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a truck...");
    }
}

// Factory class that will create vehicles
class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        // Factory decides which vehicle to create based on input type
        if (type.equals("car")) {
            return new Car();
        } else if (type.equals("truck")) {
            return new Truck();
        } else {
            throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}

// Client class that uses the factory
class VehicleClient {
    public void createVehicle(String type) {
        // Client uses the factory to create the vehicle
        Vehicle vehicle = VehicleFactory.createVehicle(type);
        vehicle.drive();  // Client only interacts with the common interface (Vehicle)
    }
}

