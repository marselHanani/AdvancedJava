package DesignPrinciples.SOLIDPrinciple.InterfaceSegregation.problem;

/*
*Interface Segregation Principle (ISP):
?The Interface Segregation Principle states that a class should not be forced to implement methods it does not use.
? Instead of creating a large, generalized interface, it’s better to break it into smaller, more specific interfaces tailored
? to the needs of the clients.
! the problems :
!Unused Methods:Classes that implement a large interface might have to provide empty implementations for methods they don’t use.
!Difficulty in Maintenance:Adding or modifying methods in a large interface may affect multiple unrelated classes.
!Tight Coupling:Classes become tightly coupled to large interfaces, making the codebase less flexible.
 */
//# A large interface with unrelated responsibilities
interface Worker {
    void work();
    void manageTeam();
    void prepareReport();
}

// Class that violates ISP
class Developer implements Worker {
    @Override
    public void work() {
        System.out.println("Writing code...");
    }

    @Override
    public void manageTeam() {
        // Unused method
        throw new UnsupportedOperationException("Developer doesn't manage a team!");
    }

    @Override
    public void prepareReport() {
        // Unused method
        throw new UnsupportedOperationException("Developer doesn't prepare reports!");
    }
}

class Manager implements Worker {
    @Override
    public void work() {
        System.out.println("Supervising the team...");
    }

    @Override
    public void manageTeam() {
        System.out.println("Managing the team...");
    }

    @Override
    public void prepareReport() {
        System.out.println("Preparing reports...");
    }
}
