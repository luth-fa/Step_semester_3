package string;

import java.util.Scanner;

public class SrmStudent {

    String name;
    String regNo;
    int attendance;

    SrmStudent(String name, String regNo, int attendance) {
        this.name = name;
        this.regNo = regNo;
        this.attendance = attendance;
    }

    void addAttendanceUpdate(int newAttendance) {
        attendance = newAttendance;
    }

    boolean isEligible() {
        return attendance >= 75;
    }

    static double classAverage(SrmStudent[] students) {

        int total = 0;

        for (int i = 0; i < students.length; i++) {
            total += students[i].attendance;
        }

        return (double) total / students.length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SrmStudent[] students = new SrmStudent[5];

        for (int i = 0; i < 5; i++) {

            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter register number: ");
            String regNo = sc.next();

            System.out.print("Enter attendance: ");
            int attendance = sc.nextInt();

            students[i] = new SrmStudent(name, regNo, attendance);
        }

        System.out.println();

        for (int i = 0; i < students.length; i++) {

            if (students[i].isEligible()) {
                System.out.println(students[i].name + " - "
                        + students[i].attendance + "% - Eligible");
            } else {
                System.out.println(students[i].name + " - "
                        + students[i].attendance + "% - Detained");
            }
        }

        System.out.println("Class average: "
                + classAverage(students) + "%");

        sc.close();
    }

    
}