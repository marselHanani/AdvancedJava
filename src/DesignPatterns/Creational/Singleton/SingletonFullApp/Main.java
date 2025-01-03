package DesignPatterns.Creational.Singleton.SingletonFullApp;

public class Main {
    static LazyLoadingSingleton logger ;

    //هدفها بس تسندلي الكوبون على ايميلي انو انو معي كوبون
    public static void main(String[] args) {
        AssignVoucher("nH8t9@example.com", "1234");
        UseVoucher("1234");
        //- بما اني بستخدم الميثود الثنتين المفروض ان يطبعلي عدد logInfo 2 وعدد ال LogWarning 1 و LogError 1
        logger.ShowLogs();
    }

    public static void AssignVoucher(String email, String voucher) {
        logger = LazyLoadingSingleton.getInstance();
        // there is logic code to save data in database it not important for us now
        logger.LogInfo("voucher assigned"+ voucher);
        // another logic code
        logger.LogError("Unable to send Email"+ email);
    }
    public static void UseVoucher(String voucher) {
        logger = LazyLoadingSingleton.getInstance();
        //Logic code
        logger.LogInfo("Voucher used"+ voucher);
        //logic code
        logger.LogWarning("3 attempts made to validate the voucher");
    }

}