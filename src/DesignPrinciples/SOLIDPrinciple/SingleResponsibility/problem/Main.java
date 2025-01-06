package DesignPrinciples.SOLIDPrinciple.SingleResponsibility.problem;

/* what the problem that single responsibility comes to solve it ?
*Complexity Increases: Classes grow too large as the program expands.
*Hard to Maintain: Understanding and managing large classes becomes difficult.
*Slow Navigation: Finding specific code in monolithic classes wastes time.
*Cognitive Overload: Too many details in one class overwhelm developers
 */
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public void saveToDatabase() {
        System.out.println("Saving employee to database...");
    }
    public double calculateTax() {
        return salary * 0.2; // افتراض ضريبة 20%
    }
    public void printDetails() {
        System.out.println("Name: " + name + ", Salary: " + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Marcel", 5000);
        employee.saveToDatabase();
        System.out.println("Tax: " + employee.calculateTax());
        employee.printDetails();
    }
}
