/*
package DesignPrinciples.SOLIDPrinciple.Liskove.problem;

*/
/*
*Liskov Substitution Principle states that:
*Objects from subclasses can be used as substitutes for objects from base classes without affecting the correctness of the program.
#Goal: Ensure that subclasses maintain the expected behavior of the parent class.
 *//*

*/
/* LSP Conditions :
# 1-Parameter types:
 !A subclass method should accept the same or more general parameter types than the superclass method.
 !This ensures the subclass can handle all valid inputs of the superclass.
# 2-Return type:
    !A subclass method’s return type must be the same as or a subtype of the return type of the superclass method,
    !ensuring compatibility with the expectations of the superclass.
# 3-Exceptions:
    !A subclass method shouldn’t introduce new types of exceptions that the superclass method doesn’t throw.
    !This avoids breaking code that assumes the base class’s exception behavior.
# 4-Pre-conditions:
    !A subclass method shouldn’t impose stricter conditions on the inputs than the superclass method.
    !This ensures that all inputs valid for the superclass remain valid for the subclass.
# 5-Post-conditions:
    !A subclass method shouldn’t relax the guarantees made by the superclass method about the state or result after execution.
     !This ensures consistent behavior.
# 6-Private fields:
    !A subclass shouldn’t modify or depend on private fields of the superclass directly.
    !Doing so breaks encapsulation and ties the subclass to implementation details of the superclass.
 */

class Vehicle {
    private String status = "Operational";
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
    public int getType() { // انتهاك مبدأ (2)
        return 123; // تغيير نوع الإرجاع
    }

    @Override
    public void startEngine(String key) throws RuntimeException { // انتهاك (1)غيرنا النوع و (3)غيرنا نوع ال exception
        System.out.println("Starting electric engine with digital key: " + key);
    }

    @Override
    public boolean isFunctional() { // انتهاك (5)
        return false; // تغيير شرط ما بعد التنفيذ
    }

    // إضافة طريقة تتغير فيها القيم الخاصة للفئة الأساسية (انتهاك 6)
    public void resetVehicle() {
        // محاولات لتعديل الحقل الخاص للفئة الأساسية
        // لا يمكن الوصول إلى `status` لأنه خاص
        // لكن يمكن أن يتم هذا عبر طرق ملتوية مثل Reflection (وهذا انتهاك صارخ).
        System.out.println("Resetting vehicle...");
    }
}

