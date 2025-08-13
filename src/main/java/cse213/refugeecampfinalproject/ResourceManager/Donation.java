package cse213.refugeecampfinalproject.ResourcesManager;

public class Donation {

    private String itemName;
    private int quantity;
    private String expiryDate;
    private String recipient;
    private boolean lowStock;

    public Donation(String itemName, int quantity, String expiryDate, String recipient, boolean lowStock) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.recipient = recipient;
        this.lowStock = lowStock;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public boolean isLowStock() {
        return lowStock;
    }

    public void setLowStock(boolean lowStock) {
        this.lowStock = lowStock;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", expiryDate='" + expiryDate + '\'' +
                ", recipient='" + recipient + '\'' +
                ", lowStock=" + lowStock +
                '}';
    }
}
