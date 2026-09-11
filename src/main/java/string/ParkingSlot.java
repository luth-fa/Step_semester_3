package string;

public class ParkingSlot {

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
            System.out.println(vehicleNo + " allotted to Slot " + slotNo);
        } else {
            System.out.println("Slot " + slotNo + " is full.");
        }
    }

    static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {

        for (int i = 0; i < slots.length; i++) {

            if (slots[i] != null && slots[i].occupiedCount < slots[i].capacity) {
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
            System.out.println("No slots available for " + vehicleNo);
        }
    }

    public static void main(String[] args) {

        ParkingSlot[] slots = new ParkingSlot[2];

        slots[0] = new ParkingSlot(1, 1);
        slots[1] = new ParkingSlot(2, 1);

        safeAllot(slots, "TN01AB1234");

        slots[0].allot("TN01CD5678");
        slots[1].allot("TN01EF9012");

        safeAllot(slots, "TN01GH3456");
    }

    /*
     * Passing an object array to a method does not copy the
     * ParkingSlot objects. The array contains references to
     * the original objects, so changes affect the same slots.
     */
}