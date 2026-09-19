package string;

public abstract class PaymentMethod {

    private static int transactionCounter = 0;
    private final String transactionId;

    public PaymentMethod() {
        transactionCounter++;
        transactionId = "TXN-" + (1000 + transactionCounter);
    }

    public abstract String processPayment(double amount);

    public String processPayment(double amount, String note) {
        return processPayment(amount) + " (" + note + ")";
    }

    public String getTransactionId() {
        return transactionId;
    }
}