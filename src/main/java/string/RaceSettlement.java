package string;

public class RaceSettlement {

    static String settleNight(RaceEntry[] entries) {

        int processed = 0;
        int nullSkipped = 0;
        int relay = 0;
        int individual = 0;

        for (int i = 0; i < entries.length; i++) {

            if (entries[i] == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (entries[i] instanceof RelayTeamEntry) {
                relay++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + relay + " relay | "
                + individual + " individual";
    }

    public static void main(String[] args) {

        EliteRunnerEntry elite =
                new EliteRunnerEntry(
                        "BIB3001",
                        150,
                        "Elite Full Marathon",
                        500);

        RelayTeamEntry relay =
                new RelayTeamEntry(
                        "BIB4001",
                        300,
                        4);

        RaceEntry[] entries = {
            elite,
            null,
            relay
        };

        System.out.println(
                RaceEntry.isValidDiscountCode("M123A"));

        System.out.println(
                RaceEntry.isValidDiscountCode("M12A"));

        System.out.println(
                RaceEntry.isValidDiscountCode("X123A"));

        elite.pay(10, "UPI");

        System.out.println(
                settleNight(entries));

        System.out.println(
                RaceEntry.getBibCounter());
    }
}