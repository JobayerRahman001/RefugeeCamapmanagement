package cse213.refugeecampfinalproject.AccountantAndLogistics;

import java.time.LocalDate;

public class EquipmentManagementModel {
    private String equipmentName;
    private String issueDescription;
    private String priority;
    private String technician;
    private LocalDate repairDate;
    private String status;
    private double cost;

    public EquipmentManagementModel(String equipmentName, String issueDescription, String priority, String technician, LocalDate repairDate, String status, double cost) {
        this.equipmentName = equipmentName;
        this.issueDescription = issueDescription;
        this.priority = priority;
        this.technician = technician;
        this.repairDate = repairDate;
        this.status = status;
        this.cost = cost;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }

    public LocalDate getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(LocalDate repairDate) {
        this.repairDate = repairDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "EquipmentManagementModel{" +
                "equipmentName='" + equipmentName + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", priority='" + priority + '\'' +
                ", technician='" + technician + '\'' +
                ", repairDate=" + repairDate +
                ", status='" + status + '\'' +
                ", cost=" + cost +
                '}';
    }
}
