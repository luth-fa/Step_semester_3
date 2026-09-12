package string;

public class EventTicket {

    protected String attendeeId;
    protected double basePrice;
    protected double balanceDue;

    private double[] lateFeeHistory;
    private int lateFeeCount;

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
    }

    public EventTicket(double basePrice) {

        if (basePrice <= 0) {
            throw new IllegalArgumentException("Invalid base price");
        }

        this.basePrice = basePrice;
        this.balanceDue = basePrice;

        lateFeeHistory = new double[10];
        lateFeeCount = 0;
    }

    public void pay(double amount) {

        if (amount > 0) {
            balanceDue -= amount;
        }
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
}