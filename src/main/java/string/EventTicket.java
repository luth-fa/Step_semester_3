package string;

public class EventTicket {

    protected String attendeeId;
    protected double basePrice;
    protected double balanceDue;

    private double[] lateFeeHistory;
    private int lateFeeCount;

    private static int ticketsIssued = 0;

    final String ticketId;

    public EventTicket(String attendeeId, double basePrice) {

        if (attendeeId == null || attendeeId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid attendee ID");
        }

        if (basePrice <= 0) {
            throw new IllegalArgumentException("Invalid base price");
        }

        this.attendeeId = attendeeId;
        this.basePrice = basePrice;
        this.balanceDue = basePrice;

        lateFeeHistory = new double[10];
        lateFeeCount = 0;

        ticketsIssued++;
        ticketId = "TCK-" + (1000 + ticketsIssued);
    }

    public EventTicket(double basePrice) {

        if (basePrice <= 0) {
            throw new IllegalArgumentException("Invalid base price");
        }

        this.basePrice = basePrice;
        this.balanceDue = basePrice;

        lateFeeHistory = new double[10];
        lateFeeCount = 0;

        ticketsIssued++;
        ticketId = "TCK-" + (1000 + ticketsIssued);
    }

    public void pay(double amount) {

        if (amount > 0) {
            balanceDue -= amount;
        }
    }

    public void pay(double amount, String mode) {

        System.out.println("Payment Mode: " + mode);

        pay(amount);
    }

    public double getBalanceDue() {

        return balanceDue;
    }

    protected void applyLateFee(double amount) {

        if (amount > 0 && lateFeeCount < 10) {

            balanceDue += amount;

            lateFeeHistory[lateFeeCount] = amount;

            lateFeeCount++;
        }
    }

    public double[] getLateFeeHistory() {

        double[] history = new double[lateFeeCount];

        for (int i = 0; i < lateFeeCount; i++) {
            history[i] = lateFeeHistory[i];
        }

        return history;
    }

    public String printTicket() {

        return "Standard Event Ticket | Balance Due: "
                + getBalanceDue();
    }

    public static int getTicketsIssued() {

        return ticketsIssued;
    }
    public static boolean isValidPromoCode(String code) {

    if (code == null || code.length() != 5) {
        return false;
    }

    if (code.charAt(0) != 'F') {
        return false;
    }

    if (!Character.isDigit(code.charAt(1))) {
        return false;
    }

    if (!Character.isDigit(code.charAt(2))) {
        return false;
    }

    if (!Character.isDigit(code.charAt(3))) {
        return false;
    }

    if (!Character.isUpperCase(code.charAt(4))) {
        return false;
    }

    return true;
}
}