package cse213.refugeecampfinalproject.UNHCR;

import java.time.LocalDate;

public class EmergencyFundRequestModel {
    private String requesterName;
    private LocalDate requestDate;
    private double requestedAmount;
    private String emergencyReason;
    private boolean verifiedEmergency;
    private String remarks;
    private String status; // Pending, Approved, Rejected

    public EmergencyFundRequestModel(String requesterName, LocalDate requestDate, double requestedAmount, String emergencyReason, boolean verifiedEmergency, String remarks, String status) {
        this.requesterName = requesterName;
        this.requestDate = requestDate;
        this.requestedAmount = requestedAmount;
        this.emergencyReason = emergencyReason;
        this.verifiedEmergency = verifiedEmergency;
        this.remarks = remarks;
        this.status = status;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(double requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public String getEmergencyReason() {
        return emergencyReason;
    }

    public void setEmergencyReason(String emergencyReason) {
        this.emergencyReason = emergencyReason;
    }

    public boolean isVerifiedEmergency() {
        return verifiedEmergency;
    }

    public void setVerifiedEmergency(boolean verifiedEmergency) {
        this.verifiedEmergency = verifiedEmergency;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmergencyFundRequestModel{" +
                "requesterName='" + requesterName + '\'' +
                ", requestDate=" + requestDate +
                ", requestedAmount=" + requestedAmount +
                ", emergencyReason='" + emergencyReason + '\'' +
                ", verifiedEmergency=" + verifiedEmergency +
                ", remarks='" + remarks + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
