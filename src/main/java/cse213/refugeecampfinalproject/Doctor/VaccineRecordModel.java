<<<<<<<< HEAD:src/main/java/cse213/refugeecampfinalproject/DoctorAndEducationCoordinator/VaccineRecordModel.java
package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
========
package cse213.refugeecampfinalproject.Doctor;
>>>>>>>> 3766be206684680eb274de4e03789a2b43595b2f:src/main/java/cse213/refugeecampfinalproject/Doctor/VaccineRecordModel.java

import java.time.LocalDate;

public class VaccineRecordModel {
    private String patientID;
    private String vaccineName;
    private String dose;
    private LocalDate date;
    private String batchNo;

    public VaccineRecordModel(String patientID, String vaccineName, String dose, LocalDate date, String batchNo) {
        this.patientID = patientID;
        this.vaccineName = vaccineName;
        this.dose = dose;
        this.date = date;
        this.batchNo = batchNo;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    @Override
    public String toString() {
        return "VaccineRecordModel{" +
                "patientID='" + patientID + '\'' +
                ", vaccineName='" + vaccineName + '\'' +
                ", dose='" + dose + '\'' +
                ", date=" + date +
                ", batchNo='" + batchNo + '\'' +
                '}';
    }
}
