
public class StudentMarksGrid {
    public static void main(String[] args) {
        String[] subjects = {"Math", "Sci", "Eng"};
        String[] students = {"Anu", "Ravi", "Meena"};

        int[][] marks = {
            {80, 90, 70},
            {60, 85, -1},
            {95, 75, 88}
        };

        int[] total = new int[students.length];

        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < subjects.length; j++) {
                if (marks[i][j] != -1) {
                    total[i] += marks[i][j];
                }
            }
            System.out.println(students[i] + " Total: " + total[i]);
        }

        System.out.println("\nSubject Toppers:");

        for (int j = 0; j < subjects.length; j++) {
            int max = -1;
            String topper = "";

            for (int i = 0; i < students.length; i++) {
                if (marks[i][j] > max) {
                    max = marks[i][j];
                    topper = students[i];
                }
            }

            System.out.println(subjects[j] + ": " + topper + " " + max);
        }
    }
}
