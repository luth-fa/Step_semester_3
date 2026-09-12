package string;

public class TicketHierarchyTest {

    static String classifyGeneration(EventTicket ticket) {

        if (ticket instanceof PremiumWorkshopTicket) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (ticket instanceof HackathonTicket) {
            return "Hierarchical sibling (independent branch)";
        }

        if (ticket instanceof WorkshopTicket) {
            return "Hierarchical child";
        }

        return "Standard Event Ticket";
    }

    static double getTotalBalanceDue(EventTicket[] tickets) {

        double total = 0;

        for (int i = 0; i < tickets.length; i++) {
            total += tickets[i].getBalanceDue();
        }

        return total;
    }

    public static void main(String[] args) {

        EventTicket standard =
                new EventTicket("STU1", 500);

        WorkshopTicket workshop =
                new WorkshopTicket("STU2", 1200, "AI/ML");

        PremiumWorkshopTicket premium =
                new PremiumWorkshopTicket(
                        "STU3", 2000, "Cloud Native", 300);

        HackathonTicket hackathon =
                new HackathonTicket(
                        "STU4", 800, "Byte Force");

        System.out.println(standard.printTicket());
        System.out.println(workshop.printTicket());
        System.out.println(premium.printTicket());
        System.out.println(hackathon.printTicket());

        System.out.println();

        System.out.println(
                classifyGeneration(premium));

        System.out.println(
                classifyGeneration(hackathon));

        EventTicket[] tickets = {
            standard,
            workshop,
            premium,
            hackathon
        };

        System.out.println(
                "Total Balance Due: "
                + getTotalBalanceDue(tickets));
    }
}