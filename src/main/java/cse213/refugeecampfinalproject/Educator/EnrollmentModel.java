package cse213.refugeecampfinalproject.Educator;

public class EnrollmentModel {
    private String programName;
    private int enrolledStudents;

    public EnrollmentModel(String programName, int enrolledStudents) {
        this.programName = programName;
        this.enrolledStudents = enrolledStudents;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(int enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    @Override
    public String toString() {
        return "EnrollmentModel{" +
                "programName='" + programName + '\'' +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }
}
