package string;

public class BMIWellnessReport {

    static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println("------------------------------------------------");
        System.out.println("Person\tHeight\tWeight\tBMI\tStatus");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    getBmiStatus(bmi));
        }

        System.out.println("------------------------------------------------");
    }

    public static void main(String[] args) {

        double[] heights = {
            1.65, 1.70, 1.75, 1.60, 1.80,
            1.68, 1.72, 1.58, 1.77, 1.63
        };

        double[] weights = {
            55, 68, 80, 50, 90,
            65, 75, 48, 85, 60
        };

        printWellnessReport(heights, weights);
    }
}