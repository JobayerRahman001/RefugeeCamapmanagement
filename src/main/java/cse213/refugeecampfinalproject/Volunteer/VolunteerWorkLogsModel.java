package cse213.refugeecampfinalproject.Volunteer;

public class VolunteerWorkLogsModel {
    private String volID;
    private String VolServiceArea;
    private String task;
    private String Volskills;

    public VolunteerWorkLogsModel(String volID, String volServiceArea, String task, String volskills) {
        this.volID = volID;
        VolServiceArea = volServiceArea;
        this.task = task;
        Volskills = volskills;
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

    public String getVolskills() {
        return Volskills;
    }

    public void setVolskills(String volskills) {
        Volskills = volskills;
    }

    @Override
    public String toString() {
        return "VolunteerWorkLogsModel{" +
                "volID='" + volID + '\'' +
                ", VolServiceArea='" + VolServiceArea + '\'' +
                ", task='" + task + '\'' +
                ", Volskills='" + Volskills + '\'' +
                '}';
    }
}
