package string;

public class RaceEntry {

    protected String bibNumber;
    protected double entryFee;
    protected double balanceDue;

    private double[] lateFeeHistory;
    private int lateFeeCount;

    private static int bibCounter = 0;

    final String entryCode;

    public RaceEntry(String bibNumber, double entryFee) {

        if (bibNumber == null || bibNumber.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid bib number");
        }

        if (entryFee <= 0) {
            throw new IllegalArgumentException("Invalid entry fee");
        }

        this.bibNumber = bibNumber;
        this.entryFee = entryFee;
        this.balanceDue = entryFee;

        lateFeeHistory = new double[10];
        lateFeeCount = 0;

        bibCounter++;
        entryCode = "RACE-" + (1000 + bibCounter);
    }

    public void pay(double amount) {

        if (amount > 0) {
            balanceDue -= amount;
        }
    }

    public void pay(double amount, String mode) {

        System.out.println("Paying via " + mode);

        pay(amount);
    }

    protected void applyLateFee(double amount) {

        if (amount > 0 && lateFeeCount < 10) {

            balanceDue += amount;

            lateFeeHistory[lateFeeCount] = amount;

            lateFeeCount++;
        }
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public double[] getLateFeeHistory() {

        double[] history = new double[lateFeeCount];

        for (int i = 0; i < lateFeeCount; i++) {
            history[i] = lateFeeHistory[i];
        }

        return history;
    }

    public String announce() {

        return "Race Entry | Bib: " + bibNumber
                + " | Balance: " + getBalanceDue();
    }

    public static boolean isValidDiscountCode(String code) {

        if (code == null || code.length() != 5) {
            return false;
        }

        if (code.charAt(0) != 'M') {
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

    public static int getBibCounter() {
        return bibCounter;
    }
}