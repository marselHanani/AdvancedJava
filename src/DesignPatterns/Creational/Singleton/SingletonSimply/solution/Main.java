package DesignPatterns.Creational.Singleton.SingletonSimply.solution;

//?When to Use It:
//! When you need exactly one instance of a class.
//! When you want to globally access that instance from anywhere in your application.
//! When you want to restrict instantiation of a class to only one object and ensure that the same object is used throughout the application.
//*Benefits:
//*Global Access: Provides a single point of access to an instance.
//*Controlled Instantiation: Ensures only one instance of the class is created, saving resources.
//*Consistency: The single instance ensures consistent state across the application.
//# without lock
class DatabaseConnection {
    private String connectionString;

    // The single instance of the class
    private static DatabaseConnection instance;

    // Private constructor to prevent instantiation
    private DatabaseConnection(String connectionString) {
        this.connectionString = connectionString;
    }

    // Public method to get the instance
    public static DatabaseConnection getInstance(String connectionString) {
        if (instance == null) {
            instance = new DatabaseConnection(connectionString); // Create instance only once
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connecting to database with connection string: " + connectionString);
    }
}

// Client code accessing the singleton instance
class DatabaseClient {
    public static void main(String[] args) {
        // Both get the same instance
        DatabaseConnection db1 = DatabaseConnection.getInstance("DB1_URL");
        db1.connect();

        DatabaseConnection db2 = DatabaseConnection.getInstance("DB2_URL"); // Will still use DB1_URL
        db2.connect();
    }
}
