package string;

public class WorkshopTicket extends EventTicket {

    protected String track;

    public WorkshopTicket(String attendeeId, double basePrice, String track) {

        super(attendeeId, basePrice);

        this.track = track;
    }

    public WorkshopTicket(double basePrice, String track) {

        super(basePrice);

        this.track = track;
    }

    public WorkshopTicket(double basePrice) {

        super(basePrice);

        this.track = "";
    }

    @Override
    protected void applyLateFee(double amount) {

        super.applyLateFee(amount * 2);
    }

    public String getTrack() {

        return track;
    }

    @Override
    public String printTicket() {

        return "Workshop Ticket | Track: " + track
                + " | Balance Due: " + getBalanceDue();
    }
}