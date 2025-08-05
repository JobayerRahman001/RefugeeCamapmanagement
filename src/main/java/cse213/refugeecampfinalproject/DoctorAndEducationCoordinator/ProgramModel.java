package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

public class ProgramModel {
    private String programName;
    private String programType; // Literacy, Language, Vocational
    public String schedule;

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

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public ProgramModel(String programName, String programType, String schedule) {
        this.programName = programName;
        this.programType = programType;
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "ProgramModel{" +
                "programName='" + programName + '\'' +
                ", programType='" + programType + '\'' +
                ", schedule='" + schedule + '\'' +
                '}';
    }

    public void schedule(String newSchedule) {
    }
}
