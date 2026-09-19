package string;

public class BonusCalculatorTest {

    static String getAuditIfApplicable(StaffMember s) {
        if (s instanceof Auditable) {
            Auditable a = (Auditable) s;
            return a.auditRecord();
        }

        return "No audit required";
    }

    public static void main(String[] args) {
        TeamLead t = new TeamLead(60000, 5);
        TeamLead t2 = new TeamLead(60000, 0.20, 5);

        System.out.println(t.calculateBonus());
        System.out.println(t2.calculateBonus());

        t.setSalary(-5000);
        System.out.println(t.getSalary());

        StaffMember ref = t; // upcasting

        System.out.println(getAuditIfApplicable(ref));
    }
}