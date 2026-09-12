package string;

public class TicketSettlement {

    static String processNightlySettlement(EventTicket[] tickets) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (int i = 0; i < tickets.length; i++) {

            if (tickets[i] == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (tickets[i] instanceof GroupTicket) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }

    public static void main(String[] args) {

    GroupTicket groupTicket =
            new GroupTicket(2000, 5);

    EventTicket individualTicket =
            new EventTicket(500);

    EventTicket[] tickets = {
        groupTicket,
        null,
        individualTicket
    };

    System.out.println(
            processNightlySettlement(tickets));

    System.out.println(
            EventTicket.isValidPromoCode("F123A"));

    System.out.println(
            EventTicket.isValidPromoCode("F12AA"));

    System.out.println(
            groupTicket.ticketId);

    System.out.println(
            EventTicket.getTicketsIssued());
}