package string;

public class RaceHierarchyTest {

    static String classifyGeneration(RaceEntry entry) {

        if (entry instanceof EliteRunnerEntry) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (entry instanceof RelayTeamEntry) {
            return "Hierarchical sibling (independent branch)";
        }

        if (entry instanceof RunnerEntry) {
            return "Hierarchical child";
        }

        return "Standard Race Entry";
    }

    static double getTotalBalanceDue(RaceEntry[] entries) {

        double total = 0;

        for (int i = 0; i < entries.length; i++) {
            total += entries[i].getBalanceDue();
        }

        return total;
    }

    public static void main(String[] args) {

        RunnerEntry runner =
                new RunnerEntry("BIB2001", 80, "Open 10K");

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

        System.out.println(runner.announce());
        System.out.println(elite.announce());
        System.out.println(relay.announce());

        System.out.println();

        System.out.println(
                classifyGeneration(elite));

        System.out.println(
                classifyGeneration(relay));

        RaceEntry[] entries = {
            runner,
            elite,
            relay
        };

        System.out.println(
                "Total Balance Due: "
                + getTotalBalanceDue(entries));
    }
}