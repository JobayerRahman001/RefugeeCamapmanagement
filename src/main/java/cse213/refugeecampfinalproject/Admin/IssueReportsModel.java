package cse213.refugeecampfinalproject.Admin;

import java.util.ArrayList;

public class IssueReportsModel {
    private String refugeeID;
    private String category;
    private String details;
    private String urgency;
    private String location;
    private String status;

public static ArrayList<IssueReportsModel> IssueReportsList = new ArrayList<>();

    public IssueReportsModel(String refugeeID, String category, String details, String urgency, String location, String status) {
        this.refugeeID = refugeeID;
        this.category = category;
        this.details = details;
        this.urgency = urgency;
        this.location = location;
        this.status = status;
    }

    public String getRefugeeID() {
        return refugeeID;
    }

    public void setRefugeeID(String refugeeID) {
        this.refugeeID = refugeeID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReportsReceivedAdminModel{" +
                "refugeeID='" + refugeeID + '\'' +
                ", category='" + category + '\'' +
                ", details='" + details + '\'' +
                ", urgency='" + urgency + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
