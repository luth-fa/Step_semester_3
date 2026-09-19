package string;

public class FleetMaintenanceTest {

    static String getInsuranceIfApplicable(ServiceableVehicle v) {
        if (v instanceof Insurable) {
            Insurable i = (Insurable) v;
            return i.getInsuranceInfo();
        }

        return "No insurance record exists";
    }

    public static void main(String[] args) {
        Forklift f = new Forklift("FL-22");
        f.addMileage(120);

        System.out.println(f.getMileage());
        System.out.println(f.performMaintenance());

        HeavyDutyForklift hd = new HeavyDutyForklift("HD-9");

        System.out.println(hd.performMaintenance());

        ServiceableVehicle ref = f;

        System.out.println(getInsuranceIfApplicable(ref));
    }
}