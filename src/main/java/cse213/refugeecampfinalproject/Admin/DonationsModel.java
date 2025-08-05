package cse213.refugeecampfinalproject.Admin;

public class DonationsModel {
    private String donationID;
    private String donorName;
    private double donatedAmount;
    private double allocatedAmount;
    private String status;
    private String category;
    private String budget;

    public DonationsModel(String donationID, String donorName, double donatedAmount, double allocatedAmount, String status, String category, String budget) {
        this.donationID = donationID;
        this.donorName = donorName;
        this.donatedAmount = donatedAmount;
        this.allocatedAmount = allocatedAmount;
        this.status = status;
        this.category = category;
        this.budget = budget;
    }

    public String getDonationID() {
        return donationID;
    }

    public void setDonationID(String donationID) {
        this.donationID = donationID;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public double getDonatedAmount() {
        return donatedAmount;
    }

    public void setDonatedAmount(double donatedAmount) {
        this.donatedAmount = donatedAmount;
    }

    public double getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "DonationsModel{" +
                "donationID='" + donationID + '\'' +
                ", donorName='" + donorName + '\'' +
                ", donatedAmount=" + donatedAmount +
                ", allocatedAmount=" + allocatedAmount +
                ", status='" + status + '\'' +
                ", category='" + category + '\'' +
                ", budget='" + budget + '\'' +
                '}';
    }
}
