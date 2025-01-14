package DesignPrinciples.SOLIDPrinciple.Liskove.solution;


class Vehicle {
    private String status = "Operational";

    public String getStatus() {
        return status;
    }

    public void resetStatus() {
        this.status = "Operational"; // طريقة عامة لتعديل الحالة
    }
    public String getType() {
        return "Generic Vehicle";
    }

    public void startEngine(Object key) throws Exception {
        System.out.println("Starting engine with key: " + key);
    }

    public boolean isFunctional() {
        return true; // الافتراض أن السيارة تعمل بشكل صحيح
    }
}

class ElectricCar extends Vehicle {
    @Override
    public String getType() { // إصلاح (2)
        return "Electric Car"; // الحفاظ على نوع الإرجاع كـ String
    }

    @Override
    public void startEngine(Object key) throws Exception { // إصلاح (1) و (3)
        if (key instanceof String) {
            System.out.println("Starting electric engine with digital key: " + key);
        } else {
            throw new Exception("Invalid key for electric car");
        }
    }

    @Override
    public boolean isFunctional() { // إصلاح (5)
        return super.isFunctional(); // الحفاظ على السلوك المتوقع
    }

    //  (إصلاح 6)
    @Override
    public void resetStatus() {
        System.out.println("Resetting electric car...");
        super.resetStatus(); // إعادة تعيين الحالة باستخدام الطريقة العامة
    }
}
