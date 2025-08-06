package cse213.refugeecampfinalproject.ResourceManager;

public class ResourceInventorySpoiledGoodsModel {
    private String itemName;
    private String expiryDate;
    private String expiryQty;
    private String status;

    public ResourceInventorySpoiledGoodsModel(String itemName, String expiryDate, String expiryQty, String status) {
        this.itemName = itemName;
        this.expiryDate = expiryDate;
        this.expiryQty = expiryQty;
        this.status = status;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getExpiryQty() {
        return expiryQty;
    }

    public void setExpiryQty(String expiryQty) {
        this.expiryQty = expiryQty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResourceInventorySpoiledGoodsModel{" +
                "itemName='" + itemName + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", expiryQty='" + expiryQty + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
