package string;

public class CreditCardPayment extends PaymentMethod {

    private String cardNumberLastFour;

    public CreditCardPayment(String cardNumberLastFour) {
        this.cardNumberLastFour = cardNumberLastFour;
    }

    @Override
    public String processPayment(double amount) {
        return "Charged $" + amount
                + " to card ending " + cardNumberLastFour
                + " - Txn " + getTransactionId();
    }
}