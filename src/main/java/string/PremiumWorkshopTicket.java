package string;

public class PremiumWorkshopTicket extends WorkshopTicket {

    private double kitFee;

    public PremiumWorkshopTicket(String attendeeId, double basePrice,
                                  String track, double kitFee) {

        super(attendeeId, basePrice, track);

        this.kitFee = kitFee;
    }

    @Override
    public String printTicket() {

        return "Premium Workshop Ticket | Track: " + track
                + " | Kit Fee: " + kitFee
                + " | Balance Due: " + getBalanceDue();
    }
}