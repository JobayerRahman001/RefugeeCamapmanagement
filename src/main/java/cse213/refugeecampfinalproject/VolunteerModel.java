package cse213.refugeecampfinalproject;

public class VolunteerModel {
    private String volID;
    private String volName;
    private String volSkills;
    private String volServiceArea;
    private boolean volAvailability;

    public VolunteerModel(String volID, String volName, String volSkills, String volServiceArea, boolean volAvailability) {
        this.volID = volID;
        this.volName = volName;
        this.volSkills = volSkills;
        this.volServiceArea = volServiceArea;
        this.volAvailability = volAvailability;
    }

    public String getVolID() {
        return volID;
    }

    public void setVolID(String volID) {
        this.volID = volID;
    }

    public String getVolName() {
        return volName;
    }

    public void setVolName(String volName) {
        this.volName = volName;
    }

    public String getVolSkills() {
        return volSkills;
    }

    public void setVolSkills(String volSkills) {
        this.volSkills = volSkills;
    }

    public String getVolServiceArea() {
        return volServiceArea;
    }

    public void setVolServiceArea(String volServiceArea) {
        this.volServiceArea = volServiceArea;
    }

    public boolean isVolAvailability() {
        return volAvailability;
    }

    public void setVolAvailability(boolean volAvailability) {
        this.volAvailability = volAvailability;
    }

    @Override
    public String toString() {
        return "VolunteerModel{" +
                "volID='" + volID + '\'' +
                ", volName='" + volName + '\'' +
                ", volSkills='" + volSkills + '\'' +
                ", volServiceArea='" + volServiceArea + '\'' +
                ", volAvailability=" + volAvailability +
                '}';
    }
}
