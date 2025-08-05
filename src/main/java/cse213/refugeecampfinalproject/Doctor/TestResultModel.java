<<<<<<<< HEAD:src/main/java/cse213/refugeecampfinalproject/DoctorAndEducationCoordinator/TestResultModel.java
package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
========
package cse213.refugeecampfinalproject.Doctor;
>>>>>>>> 3766be206684680eb274de4e03789a2b43595b2f:src/main/java/cse213/refugeecampfinalproject/Doctor/TestResultModel.java

public class TestResultModel {
    private String patientID, reportType, filePath, date;

    public TestResultModel(String patientID, String reportType, String filePath, String date) {
        this.patientID = patientID;
        this.reportType = reportType;
        this.filePath = filePath;
        this.date = date;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TestResultModel{" +
                "patientID='" + patientID + '\'' +
                ", reportType='" + reportType + '\'' +
                ", filePath='" + filePath + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
