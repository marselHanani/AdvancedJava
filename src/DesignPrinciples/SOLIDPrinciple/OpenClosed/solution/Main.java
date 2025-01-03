package DesignPrinciples.SOLIDPrinciple.OpenClosed.solution;

class RegularCustomerDiscount implements DiscountStrategy {
    public double calculateDiscount(double price) {
        return price * 0.1; // خصم 10%
    }
}
class PremiumCustomerDiscount implements DiscountStrategy {
    public double calculateDiscount(double price) {
        return price * 0.2; // خصم 20%
    }
}
class NoDiscount implements DiscountStrategy {
    public double calculateDiscount(double price) {
        return 0; // لا يوجد خصم
    }
}
class DiscountCalculator {
    private DiscountStrategy discountStrategy;

    public DiscountCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateDiscount(double price) {
        return discountStrategy.calculateDiscount(price);
    }
}

public class Main {
    public static void main(String[] args) {
        DiscountCalculator regularCalculator = new DiscountCalculator(new RegularCustomerDiscount());
        System.out.println("Regular Discount: " + regularCalculator.calculateDiscount(100));

        DiscountCalculator premiumCalculator = new DiscountCalculator(new PremiumCustomerDiscount());
        System.out.println("Premium Discount: " + premiumCalculator.calculateDiscount(100));

        DiscountCalculator noDiscountCalculator = new DiscountCalculator(new NoDiscount());
        System.out.println("No Discount: " + noDiscountCalculator.calculateDiscount(100));
    }
}
