package string;

public final class BoardingPenaltyCalculator {

    private final double minimumPenaltyPercent;

    public BoardingPenaltyCalculator(double minimumPenaltyPercent) {

        if (minimumPenaltyPercent < 0) {
            throw new IllegalArgumentException(
                    "Minimum penalty percent cannot be negative.");
        }

        this.minimumPenaltyPercent = minimumPenaltyPercent;
    }

    public final double calculatePenalty(double ticketFare, int minutesLate) {

        if (ticketFare < 0) {
            throw new IllegalArgumentException(
                    "Ticket fare cannot be negative.");
        }

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

        double minimumPenalty =
                ticketFare * minimumPenaltyPercent / 100.0;

        return Math.max(penalty, minimumPenalty);
    }

    public static void main(String[] args) {

        BoardingPenaltyCalculator calculator =
                new BoardingPenaltyCalculator(1.0);

        System.out.println("1 minute late: Rs "
                + calculator.calculatePenalty(1000, 1));

        System.out.println("16 minutes late: Rs "
                + calculator.calculatePenalty(1000, 16));

        System.out.println("On time: Rs "
                + calculator.calculatePenalty(1000, 0));
    }
}