package string;

public class ExportTest {

    static void exportAll(Exportable[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].exportData());
        }
    }

    public static void main(String[] args) {
        ReportGenerator r = new ReportGenerator("Sales Q1");
        UserProfile u = new UserProfile("jane_doe");

        System.out.println(r.exportData());
        System.out.println(u.exportData());

        Exportable ref = r;

        exportAll(new Exportable[]{ref, u});

        System.out.println(ExportCounter.getTotalExports());
    }
}