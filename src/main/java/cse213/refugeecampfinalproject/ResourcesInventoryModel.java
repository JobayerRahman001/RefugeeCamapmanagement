package cse213.refugeecampfinalproject;

public class ResourcesInventoryModel {
    private String clothingType;
    private int quantity;
    private String reason;

    public ResourcesInventoryModel(String clothingType, int quantity, String reason) {
        this.clothingType = clothingType;
        this.quantity = quantity;
        this.reason = reason;
    }

    public String getClothingType() {
        return clothingType;
    }

    public void setClothingType(String clothingType) {
        this.clothingType = clothingType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ResourcesInventoryModel{" +
                "clothingType='" + clothingType + '\'' +
                ", quantity=" + quantity +
                ", reason='" + reason + '\'' +
                '}';
    }
}
