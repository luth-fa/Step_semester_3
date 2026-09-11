package string;

public class SleeperBusTicketAccount extends BusTicketAccount {

    public SleeperBusTicketAccount(
            String bookingId,
            double ticketFare) {

        super(bookingId, ticketFare);
    }

    public SleeperBusTicketAccount(String bookingId) {
        this(bookingId, 0);
    }
}