package cse213.refugeecampfinalproject;

public class AllResourcesModel {
    private String resourceName;
    private String availableQuantity;

    public AllResourcesModel(String resourceName, String availableQuantity) {
        this.resourceName = resourceName;
        this.availableQuantity = availableQuantity;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(String availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public String toString() {
        return "AllResourcesModel{" +
                "resourceName='" + resourceName + '\'' +
                ", availableQuantity='" + availableQuantity + '\'' +
                '}';
    }
}
