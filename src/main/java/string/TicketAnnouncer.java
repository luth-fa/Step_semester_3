package string;

public class TicketAnnouncer {

    static String batchPrint(EventTicket[] tickets) {

        StringBuilder report = new StringBuilder();

        for (int i = 0; i < tickets.length; i++) {

            System.out.println(tickets[i].printTicket());

            if (tickets[i] instanceof WorkshopTicket) {

                WorkshopTicket workshop =
                        (WorkshopTicket) tickets[i];

                report.append("Workshop | Track: ")
                      .append(workshop.getTrack())
                      .append(" | Balance: ")
                      .append(workshop.getBalanceDue())
                      .append(" [Track via downcast: ")
                      .append(workshop.getTrack())
                      .append("] | ");

            } else {

                report.append("Standard | Balance: ")
                      .append(tickets[i].getBalanceDue())
                      .append(" | ");
            }
        }

        return report.toString();
    }

    public static void main(String[] args) {

        EventTicket standard =
                new EventTicket("STU1", 500);

        WorkshopTicket workshop =
                new WorkshopTicket("STU2", 1200, "AI/ML");

        EventTicket[] tickets = {
            standard,
            workshop
        };

        System.out.println();
        System.out.println(batchPrint(tickets));
    }
}