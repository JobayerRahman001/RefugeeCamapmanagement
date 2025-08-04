package cse213.refugeecampfinalproject.RefugeeandAdmin;

public class HealthServicesModel {
    private String refugeeID;
    private String healthcareServiceType;
    private String symptoms;
    private String appointmentTime;
    private String concerns;
    private String counsellingTime;
    private String testName;
    private String result;
    private String prescription;
    private String status;

    public HealthServicesModel(String refugeeID, String healthcareServiceType, String symptoms, String appointmentTime, String concerns, String counsellingTime, String testName, String result, String prescription, String status) {
        this.refugeeID = refugeeID;
        this.healthcareServiceType = healthcareServiceType;
        this.symptoms = symptoms;
        this.appointmentTime = appointmentTime;
        this.concerns = concerns;
        this.counsellingTime = counsellingTime;
        this.testName = testName;
        this.result = result;
        this.prescription = prescription;
        this.status = status;
    }

    public String getRefugeeID() {
        return refugeeID;
    }

    public void setRefugeeID(String refugeeID) {
        this.refugeeID = refugeeID;
    }

    public String getHealthcareServiceType() {
        return healthcareServiceType;
    }

    public void setHealthcareServiceType(String healthcareServiceType) {
        this.healthcareServiceType = healthcareServiceType;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getConcerns() {
        return concerns;
    }

    public void setConcerns(String concerns) {
        this.concerns = concerns;
    }

    public String getCounsellingTime() {
        return counsellingTime;
    }

    public void setCounsellingTime(String counsellingTime) {
        this.counsellingTime = counsellingTime;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HealthServicesModel{" +
                "refugeeID='" + refugeeID + '\'' +
                ", healthcareServiceType='" + healthcareServiceType + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", concerns='" + concerns + '\'' +
                ", counsellingTime='" + counsellingTime + '\'' +
                ", testName='" + testName + '\'' +
                ", result='" + result + '\'' +
                ", prescription='" + prescription + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

