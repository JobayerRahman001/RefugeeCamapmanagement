package cse213.refugeecampfinalproject.ResourceManager;

public class RepairTicketModel {
    private String issue;
    private String priority;
    private String status;
    private String assignedStaff;
    private String eta;

    public RepairTicketModel(String issue, String priority, String status) {
        this.issue = issue;
        this.priority = priority;
        this.status = status;
        this.assignedStaff = "";
        this.eta = "";
    }


    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedStaff() {
        return assignedStaff;
    }

    public void setAssignedStaff(String assignedStaff) {
        this.assignedStaff = assignedStaff;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "RepairTicketModel{" +
                "issue='" + issue + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", assignedStaff='" + assignedStaff + '\'' +
                ", eta='" + eta + '\'' +
                '}';
    }
}
