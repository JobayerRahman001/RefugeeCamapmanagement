package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
public class TeacherAssignmentModel {
    private TeacherModel teacher;
    private EducationProgramModel program;

    public TeacherAssignmentModel(TeacherModel teacher, EducationProgramModel program) {
        this.teacher = teacher;
        this.program = program;
    }

    public TeacherModel getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherModel teacher) {
        this.teacher = teacher;
    }

    public EducationProgramModel getProgram() {
        return program;
    }

    public void setProgram(EducationProgramModel program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "TeacherAssignmentModel{" +
                "teacher=" + teacher +
                ", program=" + program +
                '}';
    }
}
