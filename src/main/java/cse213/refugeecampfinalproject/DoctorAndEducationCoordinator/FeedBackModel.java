package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

public class FeedBackModel {
    private String teacherName;
    private double averageRating;
    private int attendanceCount;
    private String commentsSummary;

    public FeedBackModel(String teacherName, double averageRating, int attendanceCount, String commentsSummary) {
        this.teacherName = teacherName;
        this.averageRating = averageRating;
        this.attendanceCount = attendanceCount;
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

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public String getCommentsSummary() {
        return commentsSummary;
    }

    public void setCommentsSummary(String commentsSummary) {
        this.commentsSummary = commentsSummary;
    }

    @Override
    public String toString() {
        return "FeedBackModel{" +
                "teacherName='" + teacherName + '\'' +
                ", averageRating=" + averageRating +
                ", attendanceCount=" + attendanceCount +
                ", commentsSummary='" + commentsSummary + '\'' +
                '}';
    }
}
