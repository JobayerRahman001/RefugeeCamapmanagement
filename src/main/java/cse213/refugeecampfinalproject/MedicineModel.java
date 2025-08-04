package cse213.refugeecampfinalproject;

public class MedicineModel {
    private String medicineName;
    private String medicineType;
    private int stock;

    public MedicineModel(String medicineName, String medicineType, int stock) {
        this.medicineName = medicineName;
        this.medicineType = medicineType;
        this.stock = stock;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "MedicineModel{" +
                "medicineName='" + medicineName + '\'' +
                ", medicineType='" + medicineType + '\'' +
                ", stock=" + stock +
                '}';
    }
}
