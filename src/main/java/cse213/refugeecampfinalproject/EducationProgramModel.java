package cse213.refugeecampfinalproject;

public class EducationProgramModel {
    private String programName;
    private String programType;
    private String ageGroup;
    private String duration;
    private int studentCapacity;

    public EducationProgramModel(String programName, String programType, String ageGroup, String duration, int studentCapacity) {
        this.programName = programName;
        this.programType = programType;
        this.ageGroup = ageGroup;
        this.duration = duration;
        this.studentCapacity = studentCapacity;
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

    public int getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(int studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    @Override
    public String toString() {
        return "EducationProgramModel{" +
                "programName='" + programName + '\'' +
                ", programType='" + programType + '\'' +
                ", ageGroup='" + ageGroup + '\'' +
                ", duration='" + duration + '\'' +
                ", studentCapacity=" + studentCapacity +
                '}';
    }
}
