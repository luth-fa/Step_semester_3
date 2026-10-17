
public class SmartHomePlatform {

    interface Dimmable {
        void dim(int level);
    }

    interface Schedulable {
        void schedule(String time);
    }

    interface EnergyMonitor {
        void showEnergy();
    }

    static abstract class Device {
        String id;
        boolean isOn;

        Device(String id) {
            this.id = id;
            this.isOn = false;
        }

        void turnOn() {
            isOn = true;
            System.out.println(id + " is ON");
        }
    }

    static class Light extends Device
            implements Dimmable, Schedulable {

        Light(String id) {
            super(id);
        }

        public void dim(int level) {
            System.out.println(id + " dimmed to " + level);
        }

        public void schedule(String time) {
            System.out.println(id + " scheduled " + time);
        }
    }

    static class Fan extends Device implements Schedulable {

        Fan(String id) {
            super(id);
        }

        public void schedule(String time) {
            System.out.println(id + " scheduled " + time);
        }
    }

    static class Plug extends Device implements EnergyMonitor {
        int energy;

        Plug(String id, int energy) {
            super(id);
            this.energy = energy;
        }

        public void showEnergy() {
            System.out.println(id + " energy " + energy + " kWh");
        }
    }

    Device[] devices = {
        new Light("L1"),
        new Fan("F1"),
        new Plug("P1", 12)
    };

    Device findDevice(String id) {
        for (Device device : devices) {
            if (device.id.equals(id)) {
                return device;
            }
        }

        return null;
    }

    void processCommand(String command) {
        String[] parts = command.split(" ");
        String action = parts[0];
        String id = parts[1];

        Device device = findDevice(id);

        if (device == null) {
            System.out.println(id + " rejected: device not found");
            return;
        }

        switch (action) {
            case "ON":
                device.turnOn();
                break;

            case "DIM":
                if (device instanceof Dimmable) {
                    ((Dimmable) device).dim(
                        Integer.parseInt(parts[2])
                    );
                } else {
                    System.out.println(
                        id + " rejected: DIM unsupported"
                    );
                }
                break;

            case "SCHEDULE":
                if (device instanceof Schedulable) {
                    ((Schedulable) device).schedule(parts[2]);
                } else {
                    System.out.println(
                        id + " rejected: SCHEDULE unsupported"
                    );
                }
                break;

            case "ENERGY":
                if (device instanceof EnergyMonitor) {
                    ((EnergyMonitor) device).showEnergy();
                } else {
                    System.out.println(
                        id + " rejected: ENERGY unsupported"
                    );
                }
                break;

            default:
                System.out.println("Invalid command");
        }
    }

    public static void main(String[] args) {
        SmartHomePlatform home = new SmartHomePlatform();

        home.processCommand("ON L1");
        home.processCommand("DIM L1 40");
        home.processCommand("DIM F1 30");
        home.processCommand("SCHEDULE F1 22:00");
        home.processCommand("ENERGY P1");
        home.processCommand("ENERGY L1");
    }
}
