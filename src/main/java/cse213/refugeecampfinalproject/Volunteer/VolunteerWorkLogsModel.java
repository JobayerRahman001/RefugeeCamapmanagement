package cse213.refugeecampfinalproject.Volunteer;

public class VolunteerWorkLogsModel {
    private String VolServiceArea;
    private String task;
    private String Volskills;

    public VolunteerWorkLogsModel(String volServiceArea, String task, String volskills) {
        VolServiceArea = volServiceArea;
        this.task = task;
        Volskills = volskills;
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
                "VolServiceArea='" + VolServiceArea + '\'' +
                ", task='" + task + '\'' +
                ", Volskills='" + Volskills + '\'' +
                '}';
    }
}
