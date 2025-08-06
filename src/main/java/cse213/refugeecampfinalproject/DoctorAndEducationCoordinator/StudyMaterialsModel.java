package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

public class StudyMaterialsModel {
    private String fileName;
    private String description;
    private String programName;

    public StudyMaterialsModel(String fileName, String description, String programName) {
        this.fileName = fileName;
        this.description = description;
        this.programName = programName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @Override
    public String toString() {
        return "StudyMaterialsModel{" +
                "fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                ", programName='" + programName + '\'' +
                '}';
    }
}
