package cse213.refugeecampfinalproject.ResourceManager;

public class ResourceStockModel
{
    private String itemName;
    private String currentQty;
    private String receivedQty;

    public ResourceStockModel(String itemName, String currentQty, String receivedQty) {
        this.itemName = itemName;
        this.currentQty = currentQty;
        this.receivedQty = receivedQty;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCurrentQty() {
        return currentQty;
    }

    public void setCurrentQty(String currentQty) {
        this.currentQty = currentQty;
    }

    public String getReceivedQty() {
        return receivedQty;
    }

    public void setReceivedQty(String receivedQty) {
        this.receivedQty = receivedQty;
    }
}
