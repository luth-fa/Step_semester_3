package string;

public class ExportCounter {

    private static int totalExports = 0;

    public static void increment() {
        totalExports++;
    }

    public static int getTotalExports() {
        return totalExports;
    }
}