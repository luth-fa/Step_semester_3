package string;

public class FareSplitter {

    private String tripId;
    private double totalFare;
    private int passengerCount;

    public FareSplitter(String tripId, double totalFare, int passengerCount) {

        if (totalFare < 0) {
            throw new IllegalArgumentException("Fare cannot be negative.");
        }

        if (passengerCount <= 0) {
            throw new IllegalArgumentException("Passenger count must be positive.");
        }

        this.tripId = tripId;
        this.totalFare = totalFare;
        this.passengerCount = passengerCount;
    }

    public FareSplitter(String tripId, double totalFare) {
        this(tripId, totalFare, 2);
    }

    public FareSplitter(String tripId) {
        this(tripId, 0.0, 2);
    }

    public double[] fareBreakdown() {

        double[] shares = new double[passengerCount];

        long totalCents = Math.round(totalFare * 100);
        long baseCents = totalCents / passengerCount;
        long remainder = totalCents % passengerCount;

        for (int i = 0; i < passengerCount - 1; i++) {
            shares[i] = baseCents / 100.0;
        }

        shares[passengerCount - 1] =
                (baseCents + remainder) / 100.0;

        return shares;
    }

    public boolean isConfirmationOverdue(int confirmed, int expected) {
        return confirmed < expected;
    }

    public static void main(String[] args) {

        FareSplitter trip1 =
                new FareSplitter("TRIP001", 100000, 3);

        double[] result1 = trip1.fareBreakdown();

        System.out.println("TRIP001:");

        for (int i = 0; i < result1.length; i++) {
            System.out.printf("%.2f ", result1[i]);
        }

        System.out.println();

        FareSplitter trip2 =
                new FareSplitter("TRIP003");

        double[] result2 = trip2.fareBreakdown();

        System.out.println("TRIP003:");

        for (int i = 0; i < result2.length; i++) {
            System.out.printf("%.2f ", result2[i]);
        }

        System.out.println();
    }
}