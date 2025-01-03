package DesignPrinciples.SOLIDPrinciple.OpenClosed.problem;

/*
*Open for Extension: يمكن إضافة وظائف جديدة بسهولة.
*Closed for Modification: لا يتطلب تعديل الكود الأصلي عند إضافة ميزات جديدة.
* الهدف: الحفاظ على استقرار الكود الموجود وتجنب التأثير على سلوك البرنامج عند إضافة ميزات جديدة
  */
class DiscountCalculator {
    public double calculateDiscount(String customerType, double price) {
        if (customerType.equals("Regular")) {
            return price * 0.1; // خصم 10% للعملاء العاديين
        } else if (customerType.equals("Premium")) {
            return price * 0.2; // خصم 20% للعملاء المميزين
        } else {
            return 0; // لا يوجد خصم
        }
    }//# لو بدي اضيف نوع جديد بدي انجبر اعدل هاظ الكلاس وهاد الاشي مش منطقي لما يكون الكوود كبير لانو بسببلي مشاكل وصعوبة في اي تعديل بدي اعمله
}

public class Main {
    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Discount: " + calculator.calculateDiscount("Regular", 100));
    }
}
