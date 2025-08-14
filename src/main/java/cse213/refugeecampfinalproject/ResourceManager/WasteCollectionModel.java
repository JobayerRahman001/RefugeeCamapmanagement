package cse213.refugeecampfinalproject.ResourceManager;

public class WasteCollectionModel {
    private String zone;
    private String truck;
    private String priority;

    public WasteCollectionModel(String zone, String truck, String priority) {
        this.zone = zone;
        this.truck = truck;
        this.priority = priority;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "WasteCollectionModel{" +
                "zone='" + zone + '\'' +
                ", truck='" + truck + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
