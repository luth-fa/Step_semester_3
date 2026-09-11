package string;

public class HostelRoom {

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
            System.out.println("No available room.");
        }
    }

    public static void main(String[] args) {

        HostelRoom[] rooms = new HostelRoom[3];

        rooms[0] = new HostelRoom(101, 2);
        rooms[1] = new HostelRoom(102, 2);
        rooms[2] = new HostelRoom(103, 2);

        safeAllot(rooms, "Ravi");
        safeAllot(rooms, "Anitha");

        HostelRoom[] fullRooms = new HostelRoom[2];

        fullRooms[0] = new HostelRoom(201, 1);
        fullRooms[1] = new HostelRoom(202, 1);

        fullRooms[0].allot("Karthik");
        fullRooms[1].allot("Meera");

        safeAllot(fullRooms, "Suresh");
    }

}
