<<<<<<<< HEAD:src/main/java/cse213/refugeecampfinalproject/DoctorAndEducationCoordinator/MedicineModel.java
package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
========
package cse213.refugeecampfinalproject.Doctor;
>>>>>>>> 3766be206684680eb274de4e03789a2b43595b2f:src/main/java/cse213/refugeecampfinalproject/Doctor/MedicineModel.java

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
