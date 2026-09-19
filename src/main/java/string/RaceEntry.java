package string;

public class RaceEntry {

    protected String bibNumber;
    protected double entryFee;
    protected double balanceDue;

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
    }

    public void pay(double amount) {

        if (amount > 0) {
            balanceDue -= amount;
        }
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public String announce() {

        return "Race Entry | Bib: " + bibNumber
                + " | Balance: " + getBalanceDue();
    }
}