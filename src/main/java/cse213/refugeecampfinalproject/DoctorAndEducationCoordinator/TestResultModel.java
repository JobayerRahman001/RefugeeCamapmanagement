package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import java.io.File;
import java.time.LocalDate;

public class TestResultModel {
    private String patientID, reportType;
    private File filePath;
    private LocalDate date;

    public TestResultModel(String patientID, String reportType, File filePath, LocalDate date) {
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

    public File getFilePath() {
        return filePath;
    }

    public void setFilePath(File filePath) {
        this.filePath = filePath;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TestResultModel{" +
                "patientID='" + patientID + '\'' +
                ", reportType='" + reportType + '\'' +
                ", filePath=" + filePath +
                ", date=" + date +
                '}';
    }
}