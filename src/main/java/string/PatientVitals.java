package string;

public class PatientVitals {

    private double[] readings;

    public PatientVitals(double[] initialReadings) {

        readings = new double[initialReadings.length];

        for (int i = 0; i < initialReadings.length; i++) {
            recordReading(initialReadings[i]);
        }
    }

    void recordReading(double reading) {

        if (reading > 0 && reading <= 45) {

            double[] newReadings = new double[readings.length + 1];

            for (int i = 0; i < readings.length; i++) {
                newReadings[i] = readings[i];
            }

            newReadings[readings.length] = reading;

            readings = newReadings;
        }
    }

    double getAverage() {

        if (readings.length == 0) {
            return 0;
        }

        double total = 0;

        for (int i = 0; i < readings.length; i++) {
            total += readings[i];
        }

        return total / readings.length;
    }

    double[] getAllReadings() {

        double[] copy = new double[readings.length];

        for (int i = 0; i < readings.length; i++) {
            copy[i] = readings[i];
        }

        return copy;
    }

    public static void main(String[] args) {

        double[] initial = {36.5, -2, 37.1};

        PatientVitals patient = new PatientVitals(initial);

        System.out.println("Average: " + patient.getAverage());

        double[] readings = patient.getAllReadings();

        System.out.println("Before changing copy:");
        for (int i = 0; i < readings.length; i++) {
            System.out.println(readings[i]);
        }

        readings[0] = 100;

        System.out.println("After changing copy:");
        double[] newReadings = patient.getAllReadings();

        for (int i = 0; i < newReadings.length; i++) {
            System.out.println(newReadings[i]);
        }
    }
}