package string;

public class CompanyEmployeeRecord {

    static class Employee {

        private int empId;
        private String empName;
        private double salary;

        Employee(int empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
        }

        double getSalary() {
            return salary;
        }
    }


    static class ManagerEmployee extends Employee {

        private double teamBonus;

        ManagerEmployee(int empId, String empName,
                        double salary, double teamBonus) {

            super(empId, empName, salary);
            this.teamBonus = teamBonus;
        }

        double effectiveSalary() {
            return getSalary() + teamBonus;
        }
    }


    static class ParkingSlot {

        int slotNo;
        int capacity;
        int occupiedCount;

        ParkingSlot(int slotNo, int capacity) {
            this.slotNo = slotNo;
            this.capacity = capacity;
            this.occupiedCount = 0;
        }

        void allot(String vehicleNo) {

            if (occupiedCount < capacity) {
                occupiedCount++;
                System.out.println(vehicleNo
                        + " allotted to Slot " + slotNo);
            }
        }
    }


    static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {

        for (int i = 0; i < slots.length; i++) {

            if (slots[i] != null
                    && slots[i].occupiedCount < slots[i].capacity) {

                return slots[i];
            }
        }

        return null;
    }


    static void safeAllot(ParkingSlot[] slots, String vehicleNo) {

        ParkingSlot slot = findAvailableSlot(slots);

        if (slot != null) {
            slot.allot(vehicleNo);
        } else {
            System.out.println("No parking available for " + vehicleNo);
        }
    }


    String name;
    int empId;

    Employee employee;
    ParkingSlot slot;

    static int totalRecords = 0;


    CompanyEmployeeRecord(String name, int empId, Employee employee) {

        this.name = name;
        this.empId = empId;
        this.employee = employee;

        totalRecords++;
    }


    void fullProfile() {

        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + empId);

        if (employee instanceof ManagerEmployee) {

            ManagerEmployee manager =
                    (ManagerEmployee) employee;

            System.out.println("Effective Pay: Rs "
                    + manager.effectiveSalary());

        } else {

            System.out.println("Effective Pay: Rs "
                    + employee.getSalary());
        }

        if (slot != null) {
            System.out.println("Parking Slot: " + slot.slotNo);
        } else {
            System.out.println("Parking Slot: no parking assigned");
        }

        System.out.println();
    }


    public static void main(String[] args) {

        Employee employee =
                new Employee(101, "Karan", 40000);

        ManagerEmployee manager =
                new ManagerEmployee(102, "Divya", 70000, 8000);

        Employee intern =
                new Employee(103, "Meera", 10000);


        CompanyEmployeeRecord record1 =
                new CompanyEmployeeRecord("Divya", 102, manager);

        CompanyEmployeeRecord record2 =
                new CompanyEmployeeRecord("Karan", 101, employee);

        CompanyEmployeeRecord record3 =
                new CompanyEmployeeRecord("Meera", 103, intern);


        ParkingSlot[] slots = new ParkingSlot[2];

        slots[0] = new ParkingSlot(1, 1);
        slots[1] = new ParkingSlot(2, 1);


        record1.slot = findAvailableSlot(slots);

        if (record1.slot != null) {
            record1.slot.allot("TN01AB1234");
        }


        record2.slot = findAvailableSlot(slots);

        if (record2.slot != null) {
            record2.slot.allot("TN01CD5678");
        }


        record1.fullProfile();
        record2.fullProfile();
        record3.fullProfile();

        System.out.println("Total Records: "
                + CompanyEmployeeRecord.totalRecords);
    }
}