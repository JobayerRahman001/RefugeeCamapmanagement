package cse213.refugeecampfinalproject;

import java.io.File;

public class StudyMaterialsModel {
    private EducationProgramModel program; // Reference to the associated program
    private File file; // The uploaded file
    private String description;

    public StudyMaterialsModel(EducationProgramModel program, File file, String description) {
        this.program = program;
        this.file = file;
        this.description = description;
    }

    public EducationProgramModel getProgram() {
        return program;
    }

    public void setProgram(EducationProgramModel program) {
        this.program = program;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StudyMaterialsModel{" +
                "program=" + program +
                ", file=" + file +
                ", description='" + description + '\'' +
                '}';
    }
}
