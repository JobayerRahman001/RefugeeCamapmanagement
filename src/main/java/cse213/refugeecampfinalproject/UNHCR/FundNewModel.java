package cse213.refugeecampfinalproject.UNHCR;

public class FundNewModel {
    private String programName;
    private String purpose;
    private double fundAmount;
    private boolean approved;

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public double getFundAmount() {
        return fundAmount;
    }

    public void setFundAmount(double fundAmount) {
        this.fundAmount = fundAmount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "FundNewModel{" +
                "programName='" + programName + '\'' +
                ", purpose='" + purpose + '\'' +
                ", fundAmount=" + fundAmount +
                ", approved=" + approved +
                '}';
    }

    public FundNewModel(String programName, String purpose, double fundAmount, boolean approved) {
        this.programName = programName;
        this.purpose = purpose;
        this.fundAmount = fundAmount;
        this.approved = approved;


    }
}
