package cse213.refugeecampfinalproject.Volunteer;

public class VolunteerLoginModel {
    private String VolID;
    private String passcode;

    public VolunteerLoginModel(String volID, String passcode) {
        VolID = volID;
        this.passcode = passcode;
    }

    public String getVolID() {
        return VolID;
    }

    public void setVolID(String volID) {
        VolID = volID;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    @Override
    public String toString() {
        return "VolunteerLoginModel{" +
                "VolID='" + VolID + '\'' +
                ", passcode='" + passcode + '\'' +
                '}';
    }
}

