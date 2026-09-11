package string;

public class BusTicketAccount {

    private String bookingId;
    private double ticketFare;
    private double amountPaid;

    static int processedCount;
    static int sleeperCount;
    static int regularCount;
    static int nullSkippedCount;
    static double totalPenalties;

    static {
        processedCount = 0;
        sleeperCount = 0;
        regularCount = 0;
        nullSkippedCount = 0;
        totalPenalties = 0;
    }

    public BusTicketAccount(String bookingId, double ticketFare) {

        if (ticketFare < 0) {
            throw new IllegalArgumentException(
                    "Ticket fare cannot be negative.");
        }

        this.bookingId = bookingId;
        this.ticketFare = ticketFare;
        this.amountPaid = 0;
    }

    public BusTicketAccount(String bookingId) {
        this(bookingId, 0);
    }

    final double calculatePenalty(int minutesLate) {

        if (minutesLate < 0) {
            throw new IllegalArgumentException(
                    "Minutes late cannot be negative.");
        }

        if (minutesLate == 0) {
            return 0;
        }

        int firstTier = Math.min(minutesLate, 5);
        int secondTier = Math.min(
                Math.max(minutesLate - 5, 0), 10);
        int thirdTier = Math.max(minutesLate - 15, 0);

        double penalty = 0;

        penalty += ticketFare * firstTier * 0.005;
        penalty += ticketFare * secondTier * 0.01;
        penalty += ticketFare * thirdTier * 0.02;

        double minimumPenalty = ticketFare * 0.01;

        return Math.max(penalty, minimumPenalty);
    }

    void processAccount(
            BusTicketAccount account,
            double amount,
            int minutesLate) {

        if (account == null) {
            return;
        }

        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Amount cannot be negative.");
        }

        amountPaid += amount;

        double penalty = calculatePenalty(minutesLate);

        totalPenalties += penalty;
        processedCount++;
    }

    static void processBatch(
            BusTicketAccount[] accounts,
            double[] amounts,
            int[] minutesLateArray) {

        if (accounts == null
                || amounts == null
                || minutesLateArray == null) {

            throw new IllegalArgumentException(
                    "Arrays cannot be null.");
        }

        if (accounts.length != amounts.length
                || accounts.length != minutesLateArray.length) {

            throw new IllegalArgumentException(
                    "All arrays must have the same length.");
        }

        for (int i = 0; i < accounts.length; i++) {

            BusTicketAccount account = accounts[i];

            if (account == null) {
                nullSkippedCount++;
                continue;
            }

            if (account instanceof SleeperBusTicketAccount) {

                SleeperBusTicketAccount sleeper =
                        (SleeperBusTicketAccount) account;

                sleeper.processAccount(
                        sleeper,
                        amounts[i],
                        minutesLateArray[i]);

                sleeperCount++;

            } else {

                account.processAccount(
                        account,
                        amounts[i],
                        minutesLateArray[i]);

                regularCount++;
            }
        }

        System.out.println("Processed: " + processedCount);
        System.out.println("Null skipped: " + nullSkippedCount);
        System.out.println("Sleeper accounts: " + sleeperCount);
        System.out.println("Regular accounts: " + regularCount);
        System.out.println("Total penalties: Rs "
                + totalPenalties);
    }

    public static void main(String[] args) {

        BusTicketAccount[] accounts = {
                new SleeperBusTicketAccount("BK001", 2000),
                null,
                new BusTicketAccount("BK002", 1200)
        };

        double[] amounts = {
                1200,
                900,
                700
        };

        int[] minutesLateArray = {
                10,
                5,
                0
        };

        processBatch(
                accounts,
                amounts,
                minutesLateArray);
    }
}