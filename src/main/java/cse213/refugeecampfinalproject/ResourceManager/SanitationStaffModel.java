package cse213.refugeecampfinalproject.ResourceManager;

public class SanitationStaffModel
{
    private String staffID;
    private String staffName;
    private String availabilityStatus;

    public SanitationStaffModel(String staffID, String staffName, String availabilityStatus) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.availabilityStatus = availabilityStatus;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
