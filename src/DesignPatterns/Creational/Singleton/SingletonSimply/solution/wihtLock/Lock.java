package DesignPatterns.Creational.Singleton.SingletonSimply.solution.wihtLock;

class DatabaseConnection {
    private String connectionString;

    // The single instance of the class
    private static DatabaseConnection instance;

    // Lock object for synchronizing the creation of the instance
    private static final Object lock = new Object();

    // Private constructor to prevent instantiation
    private DatabaseConnection(String connectionString) {
        this.connectionString = connectionString;
    }

    // Public method to get the instance
    public static DatabaseConnection getInstance(String connectionString) {
        if (instance == null) { // Check if the instance is already created
            synchronized (lock) {  // Synchronize to make it thread-safe
                if (instance == null) {  // Double-check to avoid creating multiple instances
                    instance = new DatabaseConnection(connectionString);
                }
            }
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connecting to database with connection string: " + connectionString);
    }
}

class DatabaseClient {
    public static void main(String[] args) {
        // Accessing the singleton instance
        DatabaseConnection db1 = DatabaseConnection.getInstance("DB1_URL");
        db1.connect();

        DatabaseConnection db2 = DatabaseConnection.getInstance("DB2_URL"); // Still uses DB1_URL
        db2.connect();
    }
}
