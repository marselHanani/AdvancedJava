package DesignPatterns.Creational.Builder.solution;

//?When to Use It:
//! When you need to create a complex object with many optional parts.
//! When the construction process is independent of the parts that make up the object.
//! When you want to avoid constructor telescoping, where multiple constructors are needed for different combinations of parameters.
//! When you need to build an object step by step in a flexible manner.
//*Benefits:
//*Flexibility: It allows you to create different representations of an object using the same construction process.
//*Readability: Improves readability by using descriptive methods for setting properties.
//*Separation of Concerns: Separates the construction process from the actual object, making the object creation cleaner.
//*
//*
// Product class (Pizza)
public class Pizza {
    String size;
    boolean cheese;
    boolean pepperoni;
    boolean mushrooms;

    // Private constructor, only accessible through the builder
    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }

    public void display() {
        System.out.println("Pizza size: " + size);
        System.out.println("Cheese: " + cheese);
        System.out.println("Pepperoni: " + pepperoni);
        System.out.println("Mushrooms: " + mushrooms);
    }

    // Static inner class for building the Pizza object
    public static class PizzaBuilder {
        String size;
        boolean cheese;
        boolean pepperoni;
        boolean mushrooms;

        // Required parameter constructor
        public PizzaBuilder(String size) {
            this.size = size;
        }

        // Optional parameters
        public PizzaBuilder cheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder pepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public PizzaBuilder mushrooms(boolean mushrooms) {
            this.mushrooms = mushrooms;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

// Client creating Pizza object using builder
class PizzaOrder {
    public static void main(String[] args) {
        // Using the builder to create a Pizza object
        Pizza pizza = new Pizza.PizzaBuilder("Medium")
                .cheese(true)
                .mushrooms(true)
                .build();
        pizza.display();
    }
}
