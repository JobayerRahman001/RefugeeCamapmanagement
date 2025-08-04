package cse213.refugeecampfinalproject;

public class TeacherPerformanceFeddbackDataModel {

    private String teacherName;
    private double averageRating;
    private int attendance; // Attendance percentage
    private String commentsSummary;

    public TeacherPerformanceFeddbackDataModel(String teacherName, double averageRating, int attendance, String commentsSummary) {
        this.teacherName = teacherName;
        this.averageRating = averageRating;
        this.attendance = attendance;
        this.commentsSummary = commentsSummary;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public String getCommentsSummary() {
        return commentsSummary;
    }

    public void setCommentsSummary(String commentsSummary) {
        this.commentsSummary = commentsSummary;
    }

    @Override
    public String toString() {
        return "TeacherPerformanceFeddbackDataModel{" +
                "teacherName='" + teacherName + '\'' +
                ", averageRating=" + averageRating +
                ", attendance=" + attendance +
                ", commentsSummary='" + commentsSummary + '\'' +
                '}';
    }
}
