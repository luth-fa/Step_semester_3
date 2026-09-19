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

runner.pay(30);
runner.applyLateFee(20);

System.out.println(runner.getBalanceDue());

double[] history = runner.getLateFeeHistory();

history[0] = 999;

System.out.println(runner.getLateFeeHistory()[0]);
    }
}