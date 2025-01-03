package DesignPatterns.Behavior.Observer.solution;
//?When to Use It:
//! When one object (the subject) needs to notify multiple objects (observers) about changes in its state without
// knowing who or how many observers there are.
//! When the state of an object needs to be reflected in other objects, but you don’t want to tightly couple them.
//! When you want to implement a publish-subscribe mechanism.
//*Benefits:
//*Loose Coupling: The subject does not know details about the observers, only that they implement a specific interface.
//*Dynamic Relationship: Observers can be added or removed at runtime.
//*Automatic Updates: Observers automatically receive updates when the subject’s state changes.
import java.util.ArrayList;
import java.util.List;

// Concrete Observer
class ClientObserver implements Observer {
    private String name;

    public ClientObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

// Subject class
class Stock {
    private String ticker;
    private double price;
    private List<Observer> observers;

    public Stock(String ticker, double price) {
        this.ticker = ticker;
        this.price = price;
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("Stock " + ticker + " price updated to " + price);
        }
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        Stock stock = new Stock("AAPL", 150.00);

        ClientObserver observer1 = new ClientObserver("Client 1");
        ClientObserver observer2 = new ClientObserver("Client 2");

        stock.addObserver(observer1);
        stock.addObserver(observer2);

        // Changing the stock price
        stock.setPrice(155.00);
    }
}
