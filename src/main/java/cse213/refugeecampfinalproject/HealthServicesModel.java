package cse213.refugeecampfinalproject;

import java.util.Locale;

public class HealthServicesModel {
    private String refugeeid;
    private String healthcareServiceType;
    private String symptoms;
    private String appointmentTime;
    private String concerns;
    private String counsellingTime;
    private String testName;
    private String result;
    private String prescription;

    public HealthServicesModel(String refugeeid, String healthcareServiceType, String symptoms, String appointmentTime, String concerns, String counsellingTime, String testName, String result, String prescription) {
        this.refugeeid = refugeeid;
        this.healthcareServiceType = healthcareServiceType;
        this.symptoms = symptoms;
        this.appointmentTime = appointmentTime;
        this.concerns = concerns;
        this.counsellingTime = counsellingTime;
        this.testName = testName;
        this.result = result;
        this.prescription = prescription;
    }

    public String getrefugeeid() {
        return refugeeid;
    }

    public void setrefugeeid(String refugeeid) {
        this.refugeeid = refugeeid;
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
    public String getDisplayDate() {
        if (appointmentTime != null && !appointmentTime.isEmpty()) {
            return appointmentTime;
        } else if (counsellingTime != null && !counsellingTime.isEmpty()) {
            return counsellingTime;
        } else {
            return "N/A";
        }
    }
    public String getDisplayDetails() {
        if (symptoms != null && !symptoms.isEmpty()) {
            return symptoms;
        } else if (concerns != null && !concerns.isEmpty()) {
            return concerns;
        } else {
            return "N/A";
        }
    }

    @Override
    public String toString() {
        return "HealthServicesModel{" +
                "refugeeid='" + refugeeid + '\'' +
                ", healthcareServiceType='" + healthcareServiceType + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", concerns='" + concerns + '\'' +
                ", counsellingTime='" + counsellingTime + '\'' +
                ", testName='" + testName + '\'' +
                ", result='" + result + '\'' +
                ", prescription='" + prescription + '\'' +
                '}';
    }
}

