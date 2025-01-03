package DesignPatterns.Behavior.Observer.problem;

//?The Observer Pattern allows a subject to notify multiple observers when its state changes.
//? This is often used when implementing event systems or reactive systems.
//*Cons:
//*Unnecessary Updates: If not managed properly, observers can receive frequent updates even when they aren’t interested.
//*Memory Leaks: If observers aren’t properly deregistered, it can lead to memory leaks.
//*Complexity: The relationship between subjects and observers can become complicated with many listeners.
// Subject class
class Stock {
    private String ticker;
    private double price;

    public Stock(String ticker, double price) {
        this.ticker = ticker;
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Notify the client
    public void notifyClient(String message) {
        System.out.println("Notification: " + message);
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        Stock stock = new Stock("AAPL", 150.00);

        // Updating stock price and notifying the client manually
        stock.setPrice(155.00);
        stock.notifyClient("Stock price updated to " + stock.getPrice());
    }
}
//Problem:
//The Stock class is directly responsible for notifying clients, making it tightly coupled with the notification mechanism.
//If there are multiple clients (observers), we have to manually call notifyClient() for each, leading to duplicated logic.