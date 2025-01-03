package DesignPrinciples.SOLIDPrinciple.SingleResponsibility.solution;

/**
 * * Solution: Split responsibilities into smaller, focused classes to improve clarity and maintainability.
 */
// هيك كل كود صار اله كلاسه الخاص فيه
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
class EmployeeDatabase {
    public void saveToDatabase(Employee employee) {
        System.out.println("Saving " + employee.getName() + " to database...");
    }
}
class TaxCalculator {
    public double calculateTax(Employee employee) {
        return employee.getSalary() * 0.2; // افتراض ضريبة 20%
    }
}
class EmployeePrinter {
    public void printDetails(Employee employee) {
        System.out.println("Name: " + employee.getName() + ", Salary: " + employee.getSalary());
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Marcel", 5000);
        EmployeeDatabase database = new EmployeeDatabase();
        database.saveToDatabase(employee);

        TaxCalculator taxCalculator = new TaxCalculator();
        System.out.println("Tax: " + taxCalculator.calculateTax(employee));

        EmployeePrinter printer = new EmployeePrinter();
        printer.printDetails(employee);
    }
}
