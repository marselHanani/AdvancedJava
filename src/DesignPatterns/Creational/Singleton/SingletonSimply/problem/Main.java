package DesignPatterns.Creational.Singleton.SingletonSimply.problem;

//?Singleton Pattern:
// ensures that a class has only one instance and provides a global point of access to that instance.
// It's useful when you need to manage shared resources, like database connections or logging,
// where having multiple instances could lead to problems.
//*Cons:
//*Global State: Since the instance is globally accessible, it can lead to issues with global state management.
//*Difficulty in Testing: The Singleton pattern can be difficult to test because it tightly couples code and can create hidden dependencies.
//*Concurrency Issues: In multi-threaded environments, special care is needed to ensure that the instance is created only once.
class DatabaseConnection {
    private String connectionString;

    // Constructor initializes connection string
    public DatabaseConnection(String connectionString) {
        this.connectionString = connectionString;
    }

    public void connect() {
        System.out.println("Connecting to database with connection string: " + connectionString);
    }
}

// Client code creating multiple instances
class DatabaseClient {
    public static void main(String[] args) {
        // Multiple instances created
        DatabaseConnection db1 = new DatabaseConnection("DB1_URL");
        db1.connect();

        DatabaseConnection db2 = new DatabaseConnection("DB2_URL");
        db2.connect();
    }
}
