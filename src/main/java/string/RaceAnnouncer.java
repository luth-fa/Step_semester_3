package string;

public class RaceAnnouncer {

    static String announceAll(RaceEntry[] entries) {

        StringBuilder report = new StringBuilder();

        for (int i = 0; i < entries.length; i++) {

            report.append(entries[i].announce());
            report.append(" ");

            if (entries[i] instanceof RelayTeamEntry) {

                RelayTeamEntry relay =
                        (RelayTeamEntry) entries[i];

                report.append("[Team size via downcast: ");
                report.append(relay.getTeamSize());
                report.append("] ");
            }
        }

        return report.toString();
    }

    public static void main(String[] args) {

        RunnerEntry runner =
                new RunnerEntry("BIB2001", 80, "Open 10K");

        RelayTeamEntry relay =
                new RelayTeamEntry("BIB4001", 300, 4);

        RaceEntry[] entries = {
            runner,
            relay
        };

        System.out.println(announceAll(entries));
    }
}