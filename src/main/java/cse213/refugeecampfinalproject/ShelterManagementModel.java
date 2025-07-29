package cse213.refugeecampfinalproject;

public class ShelterManagementModel {
    private String refugeeID;
    private String shelterID;
    private String location;
    private Integer capacity;

    public ShelterManagementModel(String refugeeID, String shelterID, String location, Integer capacity) {
        this.refugeeID = refugeeID;
        this.shelterID = shelterID;
        this.location = location;
        this.capacity = capacity;
    }

    public String getRefugeeID() {
        return refugeeID;
    }

    public void setRefugeeID(String refugeeID) {
        this.refugeeID = refugeeID;
    }

    public String getShelterID() {
        return shelterID;
    }

    public void setShelterID(String shelterID) {
        this.shelterID = shelterID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "ShelterManagementModel{" +
                "refugeeID='" + refugeeID + '\'' +
                ", shelterID='" + shelterID + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
