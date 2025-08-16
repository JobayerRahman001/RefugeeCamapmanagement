package cse213.refugeecampfinalproject.Volunteer;

public class VolunteerWorkLogsModel {
    private String volID;
    private String VolServiceArea;
    private String task;
    private String VolSkills;

    public VolunteerWorkLogsModel(String volID, String volServiceArea, String task, String volSkills) {
        this.volID = volID;
        VolServiceArea = volServiceArea;
        this.task = task;
        VolSkills = volSkills;
    }

    public String getVolID() {
        return volID;
    }

    public void setVolID(String volID) {
        this.volID = volID;
    }

    public String getVolServiceArea() {
        return VolServiceArea;
    }

    public void setVolServiceArea(String volServiceArea) {
        VolServiceArea = volServiceArea;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getVolSkills() {
        return VolSkills;
    }

    public void setVolSkills(String volSkills) {
        VolSkills = volSkills;
    }

    @Override
    public String toString() {
        return "VolunteerWorkLogsModel{" +
                "volID='" + volID + '\'' +
                ", VolServiceArea='" + VolServiceArea + '\'' +
                ", task='" + task + '\'' +
                ", VolSkills='" + VolSkills + '\'' +
                '}';
    }
}
