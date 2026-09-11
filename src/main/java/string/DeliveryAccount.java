package string;

public class DeliveryAccount {

    private String studentId;
    private double orderValue;
    private double amountPaid;

    static int processedCount;
    static int nullSkippedCount;
    static int premiumCount;
    static int regularCount;
    static double totalSurgeFees;

    static {
        processedCount = 0;
        nullSkippedCount = 0;
        premiumCount = 0;
        regularCount = 0;
        totalSurgeFees = 0;
    }

    public DeliveryAccount(String studentId, double orderValue) {

        if (orderValue < 0) {
            throw new IllegalArgumentException(
                    "Order value cannot be negative.");
        }

        this.studentId = studentId;
        this.orderValue = orderValue;
        this.amountPaid = 0;
    }

    public DeliveryAccount(String studentId) {
        this(studentId, 0);
    }

    final double calculateSurgeFee(int delayMinutes) {

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
                orderValue * 0.01;

        return Math.max(surgeFee, minimumSurge);
    }

    void processAccount(
            DeliveryAccount account,
            double amount,
            int delayMinutes) {

        if (account == null) {
            return;
        }

        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Amount cannot be negative.");
        }

        amountPaid += amount;

        double surgeFee =
                calculateSurgeFee(delayMinutes);

        totalSurgeFees += surgeFee;
        processedCount++;
    }

    static void processBatch(
            DeliveryAccount[] accounts,
            double[] amounts,
            int[] delayMinutesArray) {

        if (accounts == null
                || amounts == null
                || delayMinutesArray == null) {

            throw new IllegalArgumentException(
                    "Arrays cannot be null.");
        }

        if (accounts.length != amounts.length
                || accounts.length != delayMinutesArray.length) {

            throw new IllegalArgumentException(
                    "All arrays must have the same length.");
        }

        for (int i = 0; i < accounts.length; i++) {

            DeliveryAccount account = accounts[i];

            if (account == null) {
                nullSkippedCount++;
                continue;
            }

            if (account instanceof PremiumDeliveryAccount) {

                PremiumDeliveryAccount premium =
                        (PremiumDeliveryAccount) account;

                premium.processAccount(
                        premium,
                        amounts[i],
                        delayMinutesArray[i]);

                premiumCount++;

            } else {

                account.processAccount(
                        account,
                        amounts[i],
                        delayMinutesArray[i]);

                regularCount++;
            }
        }

        System.out.println(
                processedCount + " processed | "
                + nullSkippedCount + " null skipped | "
                + premiumCount + " premium | "
                + regularCount + " regular | "
                + "grand total surge fees = Rs "
                + totalSurgeFees);
    }

    public static void main(String[] args) {

        DeliveryAccount[] accounts = {
                new PremiumDeliveryAccount("STU001", 500),
                null,
                new DeliveryAccount("STU002", 300)
        };

        double[] amounts = {
                500,
                400,
                300
        };

        int[] delayMinutesArray = {
                10,
                5,
                0
        };

        processBatch(
                accounts,
                amounts,
                delayMinutesArray);
    }
}