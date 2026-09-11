package string;

import java.util.HashSet;

public class BusTicket {

    private String passengerName;
    private String destination;
    private boolean checkedIn;

    public BusTicket(String passengerName, String destination) {

        if (passengerName == null || passengerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Passenger name cannot be blank.");
        }

        if (!passengerName.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Passenger name must contain only letters and spaces.");
        }

        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be blank.");
        }

        this.passengerName = passengerName.trim();
        this.destination = destination.trim();
        this.checkedIn = false;
    }

    public void markCheckedIn() {

        if (checkedIn) {
            throw new IllegalStateException("Ticket is already checked in.");
        }

        checkedIn = true;
    }

    static void processBatch(String[][] rawBookings) {

        int valid = 0;
        int rejected = 0;
        int duplicatesSkipped = 0;

        HashSet<String> bookings = new HashSet<>();

        for (int i = 0; i < rawBookings.length; i++) {

            try {

                String passengerName = rawBookings[i][0];
                String destination = rawBookings[i][1];

                BusTicket ticket =
                        new BusTicket(passengerName, destination);

                String key = passengerName.trim().toLowerCase()
                        + "|"
                        + destination.trim().toLowerCase();

                if (bookings.contains(key)) {
                    duplicatesSkipped++;
                } else {
                    bookings.add(key);
                    valid++;
                }

            } catch (Exception e) {
                rejected++;
            }
        }

        System.out.println("Valid: " + valid
                + " | Rejected: " + rejected
                + " | Duplicates skipped: " + duplicatesSkipped);
    }

    public static void main(String[] args) {

        String[][] rawBookings = {
                {"Divya", "Chennai"},
                {"", "Bangalore"},
                {"Ravi123", "Pune"},
                {"Divya", "Chennai"},
                {" ", " "}
        };

        processBatch(rawBookings);
    }
}
