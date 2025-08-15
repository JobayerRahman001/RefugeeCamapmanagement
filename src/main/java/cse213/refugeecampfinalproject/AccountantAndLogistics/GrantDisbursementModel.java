package cse213.refugeecampfinalproject.AccountantAndLogistics;

import java.time.LocalDate;

public class GrantDisbursementModel {
    private String grantName;
    private LocalDate milestoneDate;
    private String status;
    private String remarks;

    public GrantDisbursementModel(String grantName, LocalDate milestoneDate, String status, String remarks) {
        this.grantName = grantName;
        this.milestoneDate = milestoneDate;
        this.status = status;
        this.remarks = remarks;
    }

    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    public LocalDate getMilestoneDate() {
        return milestoneDate;
    }

    public void setMilestoneDate(LocalDate milestoneDate) {
        this.milestoneDate = milestoneDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "GrantDisbursementModel{" +
                "grantName='" + grantName + '\'' +
                ", milestoneDate=" + milestoneDate +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
