package DesignPrinciples.CompositionOverInheritance.solution;

// واجهة لتحديد أنواع القيادة
interface DriveBehavior {
    void drive();
}

// تنفيذ أنواع القيادة المختلفة
class NormalDrive implements DriveBehavior {
    public void drive() {
        System.out.println("Driving normally");
    }
}

class SportDrive implements DriveBehavior {
    public void drive() {
        System.out.println("Driving in sport mode");
    }
}

class OffRoadDrive implements DriveBehavior {
    public void drive() {
        System.out.println("Driving off-road");
    }
}

// فئة المركبة تستخدم التركيب بدلاً من الوراثة
class Vehicle {
    private DriveBehavior driveBehavior;

    public Vehicle(DriveBehavior driveBehavior) {
        this.driveBehavior = driveBehavior;
    }

    public void performDrive() {
        driveBehavior.drive();
    }

    public void setDriveBehavior(DriveBehavior driveBehavior) {
        this.driveBehavior = driveBehavior; // تغيير السلوك ديناميكيًا
    }
}

public class Main {
    public static void main(String[] args) {
        // سيارة بقيادة عادية
        Vehicle car = new Vehicle(new NormalDrive());
        car.performDrive(); // Driving normally

        // تغيير وضع القيادة إلى رياضي
        car.setDriveBehavior(new SportDrive());
        car.performDrive(); // Driving in sport mode

        // شاحنة تقود على الطرق الوعرة
        Vehicle truck = new Vehicle(new OffRoadDrive());
        truck.performDrive(); // Driving off-road
    }
}
