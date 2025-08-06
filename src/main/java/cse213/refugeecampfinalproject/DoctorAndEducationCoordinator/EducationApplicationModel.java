package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

public class EducationApplicationModel {
    private String refugeeName;
    private int age;
    private String selectedProgram;
    private String requestedTime;
    private String status;

    public EducationApplicationModel(String refugeeName, int age, String selectedProgram, String requestedTime, String status) {
        this.refugeeName = refugeeName;
        this.age = age;
        this.selectedProgram = selectedProgram;
        this.requestedTime = requestedTime;
        this.status = status;
    }

    public String getRefugeeName() {
        return refugeeName;
    }

    public void setRefugeeName(String refugeeName) {
        this.refugeeName = refugeeName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSelectedProgram() {
        return selectedProgram;
    }

    public void setSelectedProgram(String selectedProgram) {
        this.selectedProgram = selectedProgram;
    }

    public String getRequestedTime() {
        return requestedTime;
    }

    public void setRequestedTime(String requestedTime) {
        this.requestedTime = requestedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EducationApplicationModel{" +
                "refugeeName='" + refugeeName + '\'' +
                ", age=" + age +
                ", selectedProgram='" + selectedProgram + '\'' +
                ", requestedTime='" + requestedTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
