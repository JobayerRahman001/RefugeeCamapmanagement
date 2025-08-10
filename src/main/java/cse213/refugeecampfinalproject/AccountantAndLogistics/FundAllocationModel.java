package cse213.refugeecampfinalproject.AccountantAndLogistics;

import java.time.LocalDateTime;

public class FundAllocationModel {
    private String programName;
    private String purpose;
    private double amount;
    private LocalDateTime allocationDate;

    private static double availableBudget = 50000.0;


    public FundAllocationModel(String programName, String purpose, double amount, LocalDateTime allocationDate) {
        this.programName = programName;
        this.purpose = purpose;
        this.amount = amount;
        this.allocationDate = allocationDate;
    }

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(LocalDateTime allocationDate) {
        this.allocationDate = allocationDate;
    }

    @Override
    public String toString() {
        return "FundAllocationModel{" +
                "programName='" + programName + '\'' +
                ", purpose='" + purpose + '\'' +
                ", amount=" + amount +
                ", allocationDate=" + allocationDate +
                '}';
    }
    public static boolean allocateFunds(FundAllocationModel allocation) {
        if (allocation.amount <= availableBudget) {
            availableBudget -= allocation.amount;
            // In a real app, save to database here
            System.out.println("[LOG] Allocated " + allocation.amount + " to " +
                    allocation.programName + " for " + allocation.purpose +
                    " at " + allocation.allocationDate);
            return true;
        }
        return false;
    }
}
