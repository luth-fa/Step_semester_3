package string;

public class InstanceStaticBoundary {

    // Broken version
    static class BrokenSrmStudent {

        static String name;
        static String regNo;
        static int attendance;

        BrokenSrmStudent(String name, String regNo, int attendance) {
            BrokenSrmStudent.name = name;
            BrokenSrmStudent.regNo = regNo;
            BrokenSrmStudent.attendance = attendance;
        }

        void printDetails() {
            System.out.println(name + " " + regNo + " " + attendance + "%");
        }
    }


    // Fixed version
    static class SrmStudent {

        String name;
        String regNo;
        int attendance;

        static String university = "SRM";
        static int admissionCount = 0;

        SrmStudent(String name, int attendance) {

            this.name = name;
            this.attendance = attendance;

            admissionCount++;

            this.regNo = "RA00" + admissionCount;
        }

        void printIdCard() {
            System.out.println("Name: " + name);
            System.out.println("Register Number: " + regNo);
            System.out.println("Attendance: " + attendance + "%");
            System.out.println("University: " + university);
            System.out.println();
        }

        static void printTotalAdmissions() {
            System.out.println("Total Admissions: " + admissionCount);
        }
    }


    public static void main(String[] args) {

        System.out.println("Broken Version:");

        BrokenSrmStudent student1 =
                new BrokenSrmStudent("Ravi", "RA001", 82);

        BrokenSrmStudent student2 =
                new BrokenSrmStudent("Meera", "RA002", 74);

        student1.printDetails();
        student2.printDetails();


        System.out.println();

        System.out.println("Fixed Version:");

        SrmStudent student3 =
                new SrmStudent("Ravi", 82);

        SrmStudent student4 =
                new SrmStudent("Meera", 74);

        student3.printIdCard();
        student4.printIdCard();

        SrmStudent.printTotalAdmissions();
    }


    
}