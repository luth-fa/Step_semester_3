package string;

public class PatientProfile {

    private String patientId;
    private String name;
    private boolean discharged;
    private String lockerPin;


    public PatientProfile() {
        this(null, null);
    }


    public PatientProfile(String name) {
        this(null, name);
    }


    public PatientProfile(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
        this.discharged = false;
    }


    public String getPatientId() {
        return patientId;
    }


    public void setPatientId(String id) {

        if (patientId == null) {
            patientId = id;
        }
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public boolean isDischarged() {
        return discharged;
    }


    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }


    public void setLockerPin(String pin) {

        if (pin != null && pin.matches("\\d{4,6}")) {
            lockerPin = pin;
        }
    }


    public static void main(String[] args) {

        PatientProfile patient1 =
                new PatientProfile("Arjun Iyer");

        System.out.println(patient1.getPatientId());


        PatientProfile patient2 =
                new PatientProfile("PT1001", "Arjun Iyer");

        System.out.println(patient2.getPatientId());


        patient2.setPatientId("PT2002");

        System.out.println(patient2.getPatientId());


        patient2.setDischarged(true);

        System.out.println(patient2.isDischarged());


        patient2.setLockerPin("1234");
    }
}