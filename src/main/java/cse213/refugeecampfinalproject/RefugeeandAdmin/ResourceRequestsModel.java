package cse213.refugeecampfinalproject.RefugeeandAdmin;

import java.util.ArrayList;

public class ResourceRequestsModel {
    private String refugeeID;
    private String requestType;
    private String quantity;
    private String reason;
    private String status;

    public static ArrayList<ResourceRequestsModel> ResourceRequestsList = new ArrayList<>();

    public ResourceRequestsModel(String refugeeID, String requestType, String quantity, String reason, String status) {
        this.refugeeID = refugeeID;
        this.requestType = requestType;
        this.quantity = quantity;
        this.reason = reason;
        this.status = status;
    }

    public String getRefugeeID() {
        return refugeeID;
    }

    public void setRefugeeID(String refugeeID) {
        this.refugeeID = refugeeID;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RequestsReceivedAdminModel{" +
                "refugeeID='" + refugeeID + '\'' +
                ", requestType='" + requestType + '\'' +
                ", quantity='" + quantity + '\'' +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
