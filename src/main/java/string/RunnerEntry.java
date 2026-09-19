package string;

public class RunnerEntry extends RaceEntry {

    private String category;

    public RunnerEntry(String bibNumber, double entryFee, String category) {

        super(bibNumber, entryFee);

        this.category = category;
    }

    public String announce() {

        return "Runner Entry | Bib: " + bibNumber
                + " | Category: " + category
                + " | Balance: " + getBalanceDue();
    }
}