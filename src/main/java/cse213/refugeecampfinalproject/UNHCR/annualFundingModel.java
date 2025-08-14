package cse213.refugeecampfinalproject.UNHCR;

public class annualFundingModel {
    private String sectorName;
    private double allocatedAmount;

    public annualFundingModel(String sectorName, double allocatedAmount) {
        this.sectorName = sectorName;
        this.allocatedAmount = allocatedAmount;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public double getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    @Override
    public String toString() {
        return "SectorAllocationModel{" +
                "sectorName='" + sectorName + '\'' +
                ", allocatedAmount=" + allocatedAmount +
                '}';
    }
}
