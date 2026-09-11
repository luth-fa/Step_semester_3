package string;

public class BookIssue {

    String title;
    String borrowerName;
    int daysOverdue;

    BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }

    double fineAmount() {

        if (daysOverdue > 0) {
            return daysOverdue * 5;
        }

        return 0;
    }

    boolean isSeverelyOverdue() {
        return daysOverdue > 14;
    }

    static double totalFineCollected(BookIssue[] issues) {

        double total = 0;

        for (int i = 0; i < issues.length; i++) {
            total += issues[i].fineAmount();
        }

        return total;
    }

    public static void main(String[] args) {

        BookIssue[] issues = new BookIssue[5];

        issues[0] = new BookIssue("Clean Code", "Aditi", 18);
        issues[1] = new BookIssue("Effective Java", "Rohan", 5);
        issues[2] = new BookIssue("Refactoring", "Meera", 0);
        issues[3] = new BookIssue("DSA Handbook", "Karan", 21);
        issues[4] = new BookIssue("Design Patterns", "Divya", 9);

        for (int i = 0; i < issues.length; i++) {

            if (issues[i].isSeverelyOverdue()) {
                System.out.println(issues[i].title + " - "
                        + issues[i].daysOverdue
                        + " days - Severely overdue");
            } else {
                System.out.println(issues[i].title + " - "
                        + issues[i].daysOverdue
                        + " days - OK");
            }
        }

        System.out.println("Total fine collected: Rs "
                + BookIssue.totalFineCollected(issues));
    }

   
}