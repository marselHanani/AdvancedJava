package DesignPatterns.Creational.AbstractFactory.solution;
//?When to Use It:
//! When a system needs to create families of related or dependent objects without specifying their concrete classes.
//! When you want to create different types of objects based on a common interface or theme (e.g., UI components that vary based on platform).
//! When you need to provide a flexible interface for creating objects that belong to a specific family.
//*Benefits:
//*Consistency: Ensures that related objects are created together and maintain compatibility.
//*Flexibility: Can easily switch between different families of products.
//*Decoupling: Clients are decoupled from the concrete product families and interact with abstract interfaces.
//
// Abstract product interfaces
interface Button {
    void click();
}

interface Scrollbar {
    void scroll();
}

// Concrete product classes for dark theme
class DarkButton implements Button {
    public void click() {
        System.out.println("Dark button clicked.");
    }
}

class DarkScrollbar implements Scrollbar {
    public void scroll() {
        System.out.println("Dark scrollbar scrolled.");
    }
}

// Concrete product classes for light theme
class LightButton implements Button {
    public void click() {
        System.out.println("Light button clicked.");
    }
}

class LightScrollbar implements Scrollbar {
    public void scroll() {
        System.out.println("Light scrollbar scrolled.");
    }
}

// Abstract factory interface
interface UIFactory {
    Button createButton();
    Scrollbar createScrollbar();
}

// Concrete factories for creating dark or light themed products
class DarkUIFactory implements UIFactory {
    public Button createButton() {
        return new DarkButton();
    }
    public Scrollbar createScrollbar() {
        return new DarkScrollbar();
    }
}

class LightUIFactory implements UIFactory {
    public Button createButton() {
        return new LightButton();
    }
    public Scrollbar createScrollbar() {
        return new LightScrollbar();
    }
}

// Client code using abstract factory
class UIClient {
    private UIFactory factory;

    public UIClient(UIFactory factory) {
        this.factory = factory;
    }

    public void createUI() {
        Button button = factory.createButton();
        button.click();
        Scrollbar scrollbar = factory.createScrollbar();
        scrollbar.scroll();
    }
}

