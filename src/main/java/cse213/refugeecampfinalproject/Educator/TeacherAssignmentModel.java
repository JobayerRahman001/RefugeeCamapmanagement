<<<<<<<< HEAD:src/main/java/cse213/refugeecampfinalproject/DoctorAndEducationCoordinator/TeacherAssignmentModel.java
package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
========
package cse213.refugeecampfinalproject.Educator;
>>>>>>>> 3766be206684680eb274de4e03789a2b43595b2f:src/main/java/cse213/refugeecampfinalproject/Educator/TeacherAssignmentModel.java

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
