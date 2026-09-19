package string;

public class PaymentTest {

    static void printConfirmation(PaymentMethod payment, double amount) {
        System.out.println(payment.processPayment(amount));
    }

    public static void main(String[] args) {
        CreditCardPayment cc = new CreditCardPayment("4471");
        CashPayment cash = new CashPayment();

        System.out.println(cc.processPayment(250.0));
        System.out.println(cash.processPayment(40.0));
        System.out.println(cc.processPayment(250.0, "Birthday gift"));

        PaymentMethod ref = cc; // upcasting

        printConfirmation(ref, 250.0);
    }
}