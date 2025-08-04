package cse213.refugeecampfinalproject;

public class MedicalNoteModel {
    private String patientID;
    private String diagnosis;
    private String prescribedMedicine;
    private String remarks;


    public MedicalNoteModel(String patientID, String diagnosis, String prescribedMedicine, String remarks) {
        this.patientID = patientID;
        this.diagnosis = diagnosis;
        this.prescribedMedicine = prescribedMedicine;
        this.remarks = remarks;


    }
    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescribedMedicine() {
        return prescribedMedicine;
    }

    public void setPrescribedMedicine(String prescribedMedicine) {
        this.prescribedMedicine = prescribedMedicine;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



    @Override
    public String toString() {
        return "MedicalNoteModel{" +
                "patientID='" + patientID + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", prescribedMedicine='" + prescribedMedicine + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
