package DesignPrinciples.Encapsulate;

//* encapsulate what varies : separate the code that changes from the code that doesn't  يعني افصل الكود الي بتغير باستمرار عن باقي الكود
class ShoppingCart {
    public void checkout(int amount, String paymentMethod) {
        if (paymentMethod.equals("CreditCard")) {
            // عملية الدفع باستخدام بطاقة ائتمان
            System.out.println("Paying " + amount + " using Credit Card");
        } else if (paymentMethod.equals("PayPal")) {
            // عملية الدفع باستخدام باي بال
            System.out.println("Paying " + amount + " using PayPal");
        }
    }
}//# المشكلة اني بكل مرة بدي اضيف اشي جديد بدي اضطر اعدل بالكود الموجود قدامي وهاد الاشي مش صح

class CreditCard implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Credit Card");
    }
}
class PayPal implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using PayPal");
    }
}
class ShoppingCarts {
    private PaymentStrategy paymentStrategy;
    public ShoppingCarts(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        PaymentStrategy.pay(amount);  // استخدام طريقة الدفع المتاحة
    }
}
public class Encapsulate {
    public static void main(String[] args) {
        // الدفع باستخدام بطاقة ائتمان
        ShoppingCarts cart1 = new ShoppingCarts(new CreditCard());
        cart1.checkout(100);

        // الدفع باستخدام باي بال
        ShoppingCarts cart2 = new ShoppingCarts(new PayPal());
        cart2.checkout(200);
    }
}