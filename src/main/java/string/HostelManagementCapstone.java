package string;

public class HostelManagementCapstone {

    static class FeeAccount {

        private String regNo;
        private double totalFee;
        private double amountPaid;

        FeeAccount(String regNo, double totalFee) {
            this.regNo = regNo;
            this.totalFee = totalFee;
            this.amountPaid = 0;
        }

        void pay(double amount) {

            if (amount <= 0) {
                System.out.println("Invalid payment.");
            } else {
                amountPaid += amount;
            }
        }

        double getDue() {
            return totalFee - amountPaid;
        }
    }


    static class HostelFeeAccount extends FeeAccount {

        HostelFeeAccount(String regNo, double totalFee) {
            super(regNo, totalFee);
        }

        void payInTwoInstallments(double amount) {
            pay(amount);
            pay(amount);
        }
    }


    static class HostelRoom {

        int roomNo;
        int beds;
        int occupied;

        HostelRoom(int roomNo, int beds) {
            this.roomNo = roomNo;
            this.beds = beds;
            this.occupied = 0;
        }

        void allot(String name) {

            if (occupied < beds) {
                occupied++;
                System.out.println(name + " allotted to Room " + roomNo);
            } else {
                System.out.println("Room " + roomNo + " is full.");
            }
        }
    }


    static HostelRoom findAvailableRoom(HostelRoom[] rooms) {

        for (int i = 0; i < rooms.length; i++) {

            if (rooms[i] != null && rooms[i].occupied < rooms[i].beds) {
                return rooms[i];
            }
        }

        return null;
    }


    static void safeAllot(HostelRoom[] rooms, String name) {

        HostelRoom room = findAvailableRoom(rooms);

        if (room != null) {
            room.allot(name);
        } else {
            System.out.println("No available room for " + name);
        }
    }


    static class SrmStudent {

        String name;
        String regNo;

        HostelFeeAccount feeAccount;
        HostelRoom room;

        static int totalStudents = 0;

        SrmStudent(String name, String regNo, double hostelFee) {

            this.name = name;
            this.regNo = regNo;

            feeAccount = new HostelFeeAccount(regNo, hostelFee);

            totalStudents++;
        }

        void fullStatus() {

            System.out.println("Name: " + name);
            System.out.println("Register Number: " + regNo);
            System.out.println("Fee Due: " + feeAccount.getDue());

            if (room != null) {
                System.out.println("Room: " + room.roomNo);
            } else {
                System.out.println("Room: unallotted");
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {

        SrmStudent student1 =
                new SrmStudent("Ravi", "RA001", 150000);

        SrmStudent student2 =
                new SrmStudent("Anitha", "RA002", 150000);

        SrmStudent student3 =
                new SrmStudent("Karthik", "RA003", 150000);


        HostelRoom[] rooms = new HostelRoom[2];

        rooms[0] = new HostelRoom(101, 1);
        rooms[1] = new HostelRoom(102, 1);


        HostelRoom room1 = findAvailableRoom(rooms);

        if (room1 != null) {
            student1.room = room1;
            room1.allot(student1.name);
        }


        HostelRoom room2 = findAvailableRoom(rooms);

        if (room2 != null) {
            student2.room = room2;
            room2.allot(student2.name);
        }


        student1.feeAccount.pay(50000);

        student2.feeAccount.payInTwoInstallments(30000);

        student3.feeAccount.pay(-5000);


        student1.fullStatus();
        student2.fullStatus();
        student3.fullStatus();


        System.out.println("Total Students: "
                + SrmStudent.totalStudents);
    }
}