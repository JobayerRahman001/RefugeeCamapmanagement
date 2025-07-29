package cse213.refugeecampfinalproject;

import java.time.LocalDate;
import java.util.ArrayList;

public class AssignedResourcesModel {
    private String category;
    private String details;
    private String assignedDate;

public static ArrayList<AssignedResourcesModel> assignedList = new ArrayList<>();
    public AssignedResourcesModel(String category, String details, String assignedDate) {
        this.category = category;
        this.details = details;
        this.assignedDate = assignedDate;
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

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    @Override
    public String toString() {
        return "AssignedResourcesModel{" +
                "category='" + category + '\'' +
                ", details='" + details + '\'' +
                ", assignedDate='" + assignedDate + '\'' +
                '}';
    }
}
