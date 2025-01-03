package DesignPatterns.Structural.Facade.problem;

//?The Facade Pattern provides a single interface to a set of interfaces in a subsystem, making it easier for
//? clients to interact with the subsystem.
//*Cons:
//*Limited Flexibility: May restrict direct access to advanced subsystem features.
//*Overhead: Adding a facade may introduce extra layers of abstraction.
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
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();

        cpu.start();
        String data = hardDrive.read(0, 1024);
        memory.load(0, data);
        cpu.execute();
        cpu.shutdown();
    }
}
//Problem:
//The client must directly interact with multiple subsystems (CPU, Memory, HardDrive), increasing complexity and coupling.