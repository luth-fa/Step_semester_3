package string;

public class Canteen implements Comparable<Canteen> {

    private String canteenCode;
    private String canteenName;
    private int trustScore;

    public Canteen(String canteenCode, String canteenName, int trustScore) {
        this.canteenCode = canteenCode;
        this.canteenName = canteenName;
        this.trustScore = trustScore;
    }

    public Canteen(String canteenCode, String canteenName) {
        this(canteenCode, canteenName, 3);
    }

    @Override
    public int compareTo(Canteen other) {

        if (this.trustScore != other.trustScore) {
            return other.trustScore - this.trustScore;
        }

        int codeCompare =
                this.canteenCode.compareToIgnoreCase(other.canteenCode);

        if (codeCompare != 0) {
            return codeCompare;
        }

        return this.canteenName.length() - other.canteenName.length();
    }

    static Canteen[] rankCanteens(Canteen[] canteens) {

        Canteen[] result = new Canteen[canteens.length];

        for (int i = 0; i < canteens.length; i++) {
            result[i] = canteens[i];
        }

        // Insertion sort
        for (int i = 1; i < result.length; i++) {

            Canteen current = result[i];
            int j = i - 1;

            while (j >= 0 && result[j].compareTo(current) > 0) {
                result[j + 1] = result[j];
                j--;
            }

            result[j + 1] = current;
        }

        return result;
    }

    public static void main(String[] args) {

        Canteen[] canteens = {
                new Canteen("HB3-C", "Spice Junction", 3),
                new Canteen("hb1-c", "Grand Mess", 5),
                new Canteen("HB2-C", "Southern Treats")
        };

        Canteen[] ranked = rankCanteens(canteens);

        System.out.println("Ranked Canteens:");

        for (int i = 0; i < ranked.length; i++) {
            System.out.println(
                    ranked[i].canteenCode + " - "
                    + ranked[i].canteenName + " - Score "
                    + ranked[i].trustScore);
        }
    }
}