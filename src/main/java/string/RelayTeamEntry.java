package string;

public class RelayTeamEntry extends RaceEntry {

    private int teamSize;

    public RelayTeamEntry(String bibNumber, double entryFee,
                          int teamSize) {

        super(bibNumber, entryFee);

        if (teamSize <= 0) {
            throw new IllegalArgumentException("Invalid team size");
        }

        this.teamSize = teamSize;
    }

    @Override
    public String announce() {

        return "Relay Team | Bib: " + bibNumber
                + " | Team Size: " + teamSize
                + " | Balance: " + getBalanceDue();
    }

    public int getTeamSize() {
        return teamSize;
    }
}