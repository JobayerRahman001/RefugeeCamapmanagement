package cse213.refugeecampfinalproject.AccountantAndLogistics;

import java.time.LocalDate;

public class IncomingSupplyDeliveryModel {
    private String supplierName;
    private String category;
    private int quantity;
    private LocalDate deliveryDate;
    private String status;

    public IncomingSupplyDeliveryModel(String supplierName, String category, int quantity, LocalDate deliveryDate, String status) {
        this.supplierName = supplierName;
        this.category = category;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IncomingSupplyDeliveryModel{" +
                "supplierName='" + supplierName + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", deliveryDate=" + deliveryDate +
                ", status='" + status + '\'' +
                '}';
    }
}
