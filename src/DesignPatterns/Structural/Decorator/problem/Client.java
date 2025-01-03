package DesignPatterns.Structural.Decorator.problem;

//?The Decorator Pattern wraps an object with additional functionality dynamically. It uses a common interface for both
//? the wrapped object and its decorators, allowing seamless stacking of behaviors.
//*Cons:
//*Complexity: Can result in a large number of small classes, making the design harder to understand.
//*Debugging Difficulty: Complex decorator chains can make debugging challenging.
class Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }

    public double getCost() {
        return 5.0;
    }
}

class MilkCoffee extends Coffee {
    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }
}

class SugarCoffee extends Coffee {
    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        Coffee coffee = new MilkCoffee();
        System.out.println(coffee.getDescription() + ": $" + coffee.getCost());
    }
}
//Problem:
//Each new combination (e.g., coffee with milk and sugar) requires a new subclass.
//This leads to a class explosion as the number of combinations increases.