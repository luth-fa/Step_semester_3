package string;

public abstract class ServiceableVehicle {

    private double mileage;

    public ServiceableVehicle() {
        mileage = 0;
    }

    public abstract String performMaintenance();

    public double getMileage() {
        return mileage;
    }

    public void addMileage(double km) {
        if (km >= 0) {
            mileage = mileage + km;
        }
    }
}