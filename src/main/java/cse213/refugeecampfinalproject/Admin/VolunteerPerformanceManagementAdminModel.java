package cse213.refugeecampfinalproject.Admin;

public class VolunteerPerformanceManagementAdminModel {
    private String volServiceArea;
    private String task;
    private String volSkills;

    public VolunteerPerformanceManagementAdminModel(String volServiceArea, String task, String volSkills) {
        this.volServiceArea = volServiceArea;
        this.task = task;
        this.volSkills = volSkills;
    }

    public String getVolServiceArea() {
        return volServiceArea;
    }

    public void setVolServiceArea(String volServiceArea) {
        this.volServiceArea = volServiceArea;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getVolSkills() {
        return volSkills;
    }

    public void setVolSkills(String volSkills) {
        this.volSkills = volSkills;
    }

    @Override
    public String toString() {
        return "VolunteerPerformanceManagementAdminModel{" +
                "volServiceArea='" + volServiceArea + '\'' +
                ", task='" + task + '\'' +
                ", volSkills='" + volSkills + '\'' +
                '}';
    }
}
