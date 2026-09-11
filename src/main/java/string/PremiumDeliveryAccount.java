package string;

public class PremiumDeliveryAccount extends DeliveryAccount {

    public PremiumDeliveryAccount(
            String studentId,
            double orderValue) {

        super(studentId, orderValue);
    }

    public PremiumDeliveryAccount(String studentId) {
        this(studentId, 0);
    }
}