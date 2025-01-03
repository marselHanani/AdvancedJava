package DesignPatterns.Creational.AbstractFactory.problem;
//?Abstract Factory Pattern:
//! provides a way to create families of related objects without specifying their concrete classes.
//! The abstract factory defines methods for creating abstract products, and concrete factories
//! implement these methods to create specific product families.
//*Cons:
//*Complexity: Adds more layers of abstraction, which can be overkill in simple scenarios.
//*Extensibility Issues: Adding new families of products might require changes to existing code.

// Concrete product classes for different themes
class DarkButton {
    public void click() {
        System.out.println("Dark button clicked.");
    }
}

class LightButton {
    public void click() {
        System.out.println("Light button clicked.");
    }
}

class DarkScrollbar {
    public void scroll() {
        System.out.println("Dark scrollbar scrolled.");
    }
}

class LightScrollbar {
    public void scroll() {
        System.out.println("Light scrollbar scrolled.");
    }
}

// Client creating specific products manually
class UIClient {
    public void createUI(String theme) {
        if (theme.equals("dark")) {
            DarkButton darkButton = new DarkButton();
            darkButton.click();
            DarkScrollbar darkScrollbar = new DarkScrollbar();
            darkScrollbar.scroll();
        } else if (theme.equals("light")) {
            LightButton lightButton = new LightButton();
            lightButton.click();
            LightScrollbar lightScrollbar = new LightScrollbar();
            lightScrollbar.scroll();
        }
    }
}
