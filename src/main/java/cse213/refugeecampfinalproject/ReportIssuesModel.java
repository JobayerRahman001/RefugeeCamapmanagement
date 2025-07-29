package cse213.refugeecampfinalproject;

public class ReportIssuesModel {
    private String issueCategory;
    private String issueDetails;
    private String issueUrgencyLvl;
    private String issueLocation;

    public ReportIssuesModel(String issueCategory, String issueDetails, String issueUrgencyLvl, String issueLocation) {
        this.issueCategory = issueCategory;
        this.issueDetails = issueDetails;
        this.issueUrgencyLvl = issueUrgencyLvl;
        this.issueLocation = issueLocation;
    }

    public String getIssueCategory() {
        return issueCategory;
    }

    public void setIssueCategory(String issueCategory) {
        this.issueCategory = issueCategory;
    }

    public String getIssueDetails() {
        return issueDetails;
    }

    public void setIssueDetails(String issueDetails) {
        this.issueDetails = issueDetails;
    }

    public String getIssueUrgencyLvl() {
        return issueUrgencyLvl;
    }

    public void setIssueUrgencyLvl(String issueUrgencyLvl) {
        this.issueUrgencyLvl = issueUrgencyLvl;
    }

    public String getIssueLocation() {
        return issueLocation;
    }

    public void setIssueLocation(String issueLocation) {
        this.issueLocation = issueLocation;
    }

    @Override
    public String toString() {
        return "ReportIssuesModel{" +
                "issueCategory='" + issueCategory + '\'' +
                ", issueDetails='" + issueDetails + '\'' +
                ", issueUrgencyLvl='" + issueUrgencyLvl + '\'' +
                ", issueLocation='" + issueLocation + '\'' +
                '}';
    }
}
