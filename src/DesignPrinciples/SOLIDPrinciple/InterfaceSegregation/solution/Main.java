package DesignPrinciples.SOLIDPrinciple.InterfaceSegregation.solution;

//# Smaller, specific interfaces
interface Coder {
    void writeCode();
}

interface TeamManager {
    void manageTeam();
}

interface ReportPreparer {
    void prepareReport();
}

// Developer class only implements the relevant interface
class Developer implements Coder {
    @Override
    public void writeCode() {
        System.out.println("Writing code...");
    }
}

// Manager class implements the relevant interfaces
class Manager implements TeamManager, ReportPreparer {
    @Override
    public void manageTeam() {
        System.out.println("Managing the team...");
    }

    @Override
    public void prepareReport() {
        System.out.println("Preparing reports...");
    }
}
/*
Benefits After Applying ISP:
No Unused Methods:
Each class only implements the methods it actually needs.
Better Maintenance:
Changes to one interface don’t affect unrelated classes.
Increased Flexibility:
Classes can evolve independently by only implementing the interfaces they need.
 */