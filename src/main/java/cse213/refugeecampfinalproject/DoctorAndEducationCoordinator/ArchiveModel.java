package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

public class ArchiveModel {
    private String programName;
    private String programType; // Literacy, Language, Vocational
    private String schedule; // e.g., "Monday 10 AM - 12 PM"
    private boolean isArchived;

    public ArchiveModel(String programName, String programType, String schedule, boolean isArchived) {
        this.programName = programName;
        this.programType = programType;
        this.schedule = schedule;
        this.isArchived =false;
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

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }
    public void setArchived(){
        isArchived = true;
    }

    @Override
    public String toString() {
        return "ArchiveModel{" +
                "programName='" + programName + '\'' +
                ", programType='" + programType + '\'' +
                ", schedule='" + schedule + '\'' +
                ", isArchived=" + isArchived +
                '}';
    }


}
