<<<<<<<< HEAD:src/main/java/cse213/refugeecampfinalproject/DoctorAndEducationCoordinator/EnrollmentModel.java
package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
========
package cse213.refugeecampfinalproject.Educator;
>>>>>>>> 3766be206684680eb274de4e03789a2b43595b2f:src/main/java/cse213/refugeecampfinalproject/Educator/EnrollmentModel.java

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
