package DesignPatterns.Structural.Decorator.solution;
//?When to Use It:
//! When you need to dynamically add or modify behavior of an object without altering its structure.
//! When extending functionality through inheritance is not flexible or feasible.
//! When you want to combine behaviors in various ways.
//*Benefits:
//*Dynamic Behavior: Allows for dynamic extension of functionality without modifying existing code.
//*Flexibility: Supports combining multiple decorators in various ways.
//*Open/Closed Principle: Classes remain open for extension but closed for modification.
// Base Component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

// Decorator Base Class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

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
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee); // Add Milk
        coffee = new SugarDecorator(coffee); // Add Sugar

        System.out.println(coffee.getDescription() + ": $" + coffee.getCost());
    }
}
//Before Decorator Pattern: Requires a new subclass for every possible combination of features, leading to class explosion.
//After Decorator Pattern: Achieves dynamic behavior by stacking decorators, keeping the design flexible and maintainable.