<<<<<<<< HEAD:src/main/java/cse213/refugeecampfinalproject/DoctorAndEducationCoordinator/TeacherModel.java
package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
========
package cse213.refugeecampfinalproject.Educator;
>>>>>>>> 3766be206684680eb274de4e03789a2b43595b2f:src/main/java/cse213/refugeecampfinalproject/Educator/TeacherModel.java

public class TeacherModel {
        private String name;
        private String subject; // Optional: subject expertise
        private boolean isAvailable;

    public TeacherModel(String name, String subject, boolean isAvailable) {
        this.name = name;
        this.subject = subject;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "TeacherModel{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
