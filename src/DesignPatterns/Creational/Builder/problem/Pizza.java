package DesignPatterns.Creational.Builder.problem;

//?Builder Pattern :
// separates the construction of a complex object from its representation.
// It allows you to construct an object step by step, specifying only the needed parts. This pattern is particularly
// useful when creating objects with many optional parts or configurations.
//*Cons:
//*More Code: Can introduce additional complexity and boilerplate code for creating the builder and product classes.
//*Not Always Necessary: Overkill for simple object creation or objects with few parameters.
// Without Builder: Constructor telescoping, many parameters needed
public class Pizza {
    String size;
    boolean cheese;
    boolean pepperoni;
    boolean mushrooms;

    // Constructor with many parameters
    public Pizza(String size, boolean cheese, boolean pepperoni, boolean mushrooms) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.mushrooms = mushrooms;
    }

    public void display() {
        System.out.println("Pizza size: " + size);
        System.out.println("Cheese: " + cheese);
        System.out.println("Pepperoni: " + pepperoni);
        System.out.println("Mushrooms: " + mushrooms);
    }
}

// Client creating Pizza object
class PizzaOrder {
    public static void main(String[] args) {
        // Client has to remember all the parameters for construction
        Pizza pizza = new Pizza("Medium", true, false, true);
        pizza.display();
    }
}
