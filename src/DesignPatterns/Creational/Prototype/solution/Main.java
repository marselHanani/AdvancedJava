package DesignPatterns.Creational.Prototype.solution;

//?When to Use It:
//! When creating an object is costly or time-consuming, and you want to clone it instead of creating a new one.
//! When you need to create a duplicate object without knowing its exact class.
//! When the object creation process involves many steps or resources, and you want to reuse an existing object.
//*Benefits:
//*Performance Improvement: Saves time by cloning existing objects rather than constructing new ones.
//*Flexibility: Allows cloning of complex objects without having to know their exact class.
//*Easy Object Creation: New objects can be created from a prototype, making it easier to create multiple similar objects.
//*
//*
// Concrete Prototype class
class Car implements Cloneable {
    String model;
    String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    // Implementing the clone method to return a copy of the car
    public Car clone() {
        return new Car(this.model, this.color);
    }

    public void display() {
        System.out.println("Car Model: " + model + ", Color: " + color);
    }
}

// Client code creating new cars using the prototype
class CarShowroom {
    public static void main(String[] args) {
        // Creating a prototype car
        Car prototypeCar = new Car("Sedan", "Red");

        // Cloning the prototype car for new cars
        Car car1 = (Car) prototypeCar.clone();
        car1.display();

        Car car2 = (Car) prototypeCar.clone();
        car2.model = "SUV";  // Modifying the cloned car's model
        car2.color = "Blue";  // Modifying the cloned car's color
        car2.display();
    }
}
