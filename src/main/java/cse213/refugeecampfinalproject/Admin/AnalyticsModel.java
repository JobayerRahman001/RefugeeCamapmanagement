package cse213.refugeecampfinalproject.Admin;

public class AnalyticsModel {
    private String refugeeID;
    private String type;
    private String status;

    private String program;
    private String classTime;

    private String itemName;
    private String distributed;
    private String remaining;

    public AnalyticsModel(String refugeeID, String type, String status, String program, String classTime, String itemName, String distributed, String remaining) {
        this.refugeeID = refugeeID;
        this.type = type;
        this.status = status;
        this.program = program;
        this.classTime = classTime;
        this.itemName = itemName;
        this.distributed = distributed;
        this.remaining = remaining;
    }

    public String getRefugeeID() {
        return refugeeID;
    }

    public void setRefugeeID(String refugeeID) {
        this.refugeeID = refugeeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDistributed() {
        return distributed;
    }

    public void setDistributed(String distributed) {
        this.distributed = distributed;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    @Override
    public String toString() {
        return "AnalyticsModel{" +
                "refugeeID='" + refugeeID + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", program='" + program + '\'' +
                ", classTime='" + classTime + '\'' +
                ", itemName='" + itemName + '\'' +
                ", distributed='" + distributed + '\'' +
                ", remaining='" + remaining + '\'' +
                '}';
    }
}
