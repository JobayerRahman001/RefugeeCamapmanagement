package cse213.refugeecampfinalproject;

public class UpdateProgramScheduleModel {
    private EducationProgramModel program; // Reference to the associated program
    private String time; // New time for the program
    private String date;

    public UpdateProgramScheduleModel(String program, String time, String date) {
        this.program = program;
        this.time = time;
        this.date = date;
    }

    public EducationProgramModel getProgram() {
        return program;
    }

    public void setProgram(EducationProgramModel program) {
        this.program = program;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UpdateProgramScheduleModel{" +
                "program=" + program +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
