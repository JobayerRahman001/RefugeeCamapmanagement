package cse213.refugeecampfinalproject.UNHCR;

public class AuditReportModel {
    private String complianceStatus;
    private String findings;
    private String remarks;

    // Constructor
    public AuditReportModel(String complianceStatus, String findings) {
        this.complianceStatus = complianceStatus;
        this.findings = findings;
        this.remarks = "";
    }

    public String getComplianceStatus() {
        return complianceStatus;
    }

    public String getFindings() {
        return findings;
    }

    public String getRemarks() {
        return remarks;
    }


    public void setComplianceStatus(String complianceStatus) {
        this.complianceStatus = complianceStatus;
    }

    public void setFindings(String findings) {
        this.findings = findings;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

