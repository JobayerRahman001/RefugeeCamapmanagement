package cse213.refugeecampfinalproject.Doctor;

public class PrescriptionModel {
    private String patientID;
    private MedicineModel medicine; // Assuming you have a MedicineModel
    private String dose;
    private String duration;

    public PrescriptionModel(String patientID, MedicineModel medicine, String dose, String duration) {
        this.patientID = patientID;
        this.medicine = medicine;
        this.dose = dose;
        this.duration = duration;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public MedicineModel getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicineModel medicine) {
        this.medicine = medicine;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "PrescriptionModel{" +
                "patientID='" + patientID + '\'' +
                ", medicine=" + medicine +
                ", dose='" + dose + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
