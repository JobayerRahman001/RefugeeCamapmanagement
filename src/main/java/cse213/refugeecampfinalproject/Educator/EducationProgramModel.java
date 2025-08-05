<<<<<<<< HEAD:src/main/java/cse213/refugeecampfinalproject/DoctorAndEducationCoordinator/EducationProgramModel.java
package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
========
package cse213.refugeecampfinalproject.Educator;
>>>>>>>> 3766be206684680eb274de4e03789a2b43595b2f:src/main/java/cse213/refugeecampfinalproject/Educator/EducationProgramModel.java

public class EducationProgramModel {
    private String programName;
    private String programType; // Literacy, Language, Vocational
    private String ageGroup;
    private String duration;
    private int capacity;

    public EducationProgramModel(String programName, String programType, String ageGroup, String duration, int capacity) {
        this.programName = programName;
        this.programType = programType;
        this.ageGroup = ageGroup;
        this.duration = duration;
        this.capacity = capacity;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "EducationProgramModel{" +
                "programName='" + programName + '\'' +
                ", programType='" + programType + '\'' +
                ", ageGroup='" + ageGroup + '\'' +
                ", duration='" + duration + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
