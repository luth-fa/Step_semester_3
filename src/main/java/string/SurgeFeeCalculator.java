package string;

public final class SurgeFeeCalculator {

    private final double minimumSurgePercent;

    public SurgeFeeCalculator(double minimumSurgePercent) {
        this.minimumSurgePercent = minimumSurgePercent;
    }

    public final double calculateSurgeFee(double orderValue, int delayMinutes) {

        if (orderValue < 0) {
            throw new IllegalArgumentException(
                    "Order value cannot be negative.");
        }

        if (delayMinutes < 0) {
            throw new IllegalArgumentException(
                    "Delay minutes cannot be negative.");
        }

        if (delayMinutes == 0) {
            return 0;
        }

        int firstTier = Math.min(delayMinutes, 5);

        int secondTier = Math.min(
                Math.max(delayMinutes - 5, 0), 10);

        int thirdTier = Math.max(delayMinutes - 15, 0);

        double surgeFee = 0;

        surgeFee += orderValue * firstTier * 0.005;
        surgeFee += orderValue * secondTier * 0.01;
        surgeFee += orderValue * thirdTier * 0.02;

        double minimumSurge =
                orderValue * minimumSurgePercent / 100.0;

        return Math.max(surgeFee, minimumSurge);
    }

    public static void main(String[] args) {

        SurgeFeeCalculator calculator =
                new SurgeFeeCalculator(1.0);

        System.out.println("0 minutes late: Rs "
                + calculator.calculateSurgeFee(500, 0));

        System.out.println("1 minute late: Rs "
                + calculator.calculateSurgeFee(500, 1));

        System.out.println("16 minutes late: Rs "
                + calculator.calculateSurgeFee(500, 16));
    }
}