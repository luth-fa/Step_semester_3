package string;

public class RaceRegistrationValidator {

    static String registerBatch(String[] bibNumbers, double entryFee) {

        int registered = 0;
        int rejected = 0;

        for (int i = 0; i < bibNumbers.length; i++) {

            try {
                new RaceEntry(bibNumbers[i], entryFee);
                registered++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Registered: " + registered
                + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {

        String[] bibNumbers = {
            "BIB1",
            "B1",
            "BIB2"
        };

        System.out.println(
                registerBatch(bibNumbers, 80));
    }
}