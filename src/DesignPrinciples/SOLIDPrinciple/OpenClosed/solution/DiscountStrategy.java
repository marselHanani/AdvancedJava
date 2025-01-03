package DesignPrinciples.SOLIDPrinciple.OpenClosed.solution;

//? الحل انو انا افصل الكودات بالشكل التالي بحيث كل ما بدي اضيف اشي جديد ما بضطر اعدل الكودات القديمة كل الي علي اني اعمل class جديد بكل بساطة
public interface DiscountStrategy {
    double calculateDiscount(double price);
}
