package string;

public class AlertNetworkTest {

    static void broadcastAll(Alertable[] devices, String message) {
        for (int i = 0; i < devices.length; i++) {
            System.out.println(devices[i].sendAlert(message));
        }
    }

    static String getZoneIfMotionSensor(Alertable a) {
        if (a instanceof MotionSensor) {
            MotionSensor motion = (MotionSensor) a;
            return motion.getZoneName();
        }

        return "Not a motion sensor";
    }

    public static void main(String[] args) {
        MotionSensor m = new MotionSensor("Living Room");
        DualZoneMotionSensor d =
                new DualZoneMotionSensor("Hallway", "Stairwell");
        SmokeDetector s = new SmokeDetector("SD-01");

        System.out.println(m.sendAlert("Motion detected"));
        System.out.println(d.sendAlert("Motion detected"));
        System.out.println(s.sendAlert("Smoke detected"));

        System.out.println(getZoneIfMotionSensor(m));
        System.out.println(getZoneIfMotionSensor(s));

        Alertable[] devices = {m, d, s};

        broadcastAll(devices, "Alert detected");
    }
}