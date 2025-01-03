package DesignPatterns.Structural.Facade.solution;

//?When to Use It:
//! When you want to simplify a complex system by providing a unified interface.
//! When you want to decouple clients from the internal complexity of subsystems.
//! When a system involves multiple classes with intricate interactions that clients don't need to understand.
//*Benefits:
//*Simplification: Provides an easy-to-use interface for complex systems.
//*Decoupling: Reduces dependencies between clients and subsystems.
//*Improved Maintainability: Changes to the subsystem do not directly affect the client.
// Facade Class
class Computer {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public Computer() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    public void start() {
        System.out.println("Starting computer...");
        cpu.start();
        String data = hardDrive.read(0, 1024);
        memory.load(0, data);
        cpu.execute();
        System.out.println("Computer started.");
    }

    public void shutdown() {
        System.out.println("Shutting down computer...");
        cpu.shutdown();
        memory.clear();
        System.out.println("Computer shut down.");
    }
}

// Subsystem Classes
class CPU {
    public void start() {
        System.out.println("CPU started.");
    }

    public void execute() {
        System.out.println("CPU is executing instructions.");
    }

    public void shutdown() {
        System.out.println("CPU shut down.");
    }
}

class Memory {
    public void load(long position, String data) {
        System.out.println("Memory loaded at position " + position + " with data: " + data);
    }

    public void clear() {
        System.out.println("Memory cleared.");
    }
}

class HardDrive {
    public String read(long lba, int size) {
        return "Data from LBA: " + lba;
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
        computer.shutdown();
    }
}
//Before Facade Pattern: The client must understand and manage subsystem interactions, leading to tight coupling and complexity.
//After Facade Pattern: The facade provides a unified interface, hiding subsystem details and simplifying client interaction.