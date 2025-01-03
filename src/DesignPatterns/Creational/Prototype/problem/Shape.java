package DesignPatterns.Creational.Prototype.problem;
//?Prototype Pattern
// allows you to create new objects by cloning an existing object (called the prototype) rather than creating
// a new one from scratch. This pattern is useful when object creation is expensive,
// or when you want to create multiple identical objects efficiently.
//*Cons:
//*Complexity: Cloning objects with complex structures can become difficult, especially if the object has deep copies.
//*Not Always Suitable: Not ideal for simple objects where cloning adds unnecessary complexity.
// Creating a new object manually with multiple properties
class Car {
    String model;
    String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public void display() {
        System.out.println("Car Model: " + model + ", Color: " + color);
    }
}

// Client code creating new cars manually
class CarShowroom {
    public static void main(String[] args) {
        // Creating multiple cars manually
        Car car1 = new Car("Sedan", "Red");
        car1.display();

        Car car2 = new Car("SUV", "Blue");
        car2.display();
    }
}
