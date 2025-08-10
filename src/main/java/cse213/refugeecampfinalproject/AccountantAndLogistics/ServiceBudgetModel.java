package cse213.refugeecampfinalproject.AccountantAndLogistics;

public class ServiceBudgetModel {
    private String serviceName;
    private double allocatedAmount;
    private double spentAmount;

    public ServiceBudgetModel(String serviceName, double allocatedAmount, double spentAmount) {
        this.serviceName = serviceName;
        this.allocatedAmount = allocatedAmount;
        this.spentAmount = spentAmount;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public double getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(double spentAmount) {
        this.spentAmount = spentAmount;
    }

    @Override
    public String toString() {
        return "ServiceBudgetModel{" +
                "serviceName='" + serviceName + '\'' +
                ", allocatedAmount=" + allocatedAmount +
                ", spentAmount=" + spentAmount +
                '}';
    }
}
