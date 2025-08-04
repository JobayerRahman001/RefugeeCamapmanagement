package cse213.refugeecampfinalproject.RefugeeandAdmin;

public class RefugeeDashboardTableViewEntriesModel {
    private String type;
    private String date;
    private String details;

    public RefugeeDashboardTableViewEntriesModel(String type, String date, String details) {
        this.type = type;
        this.date = date;
        this.details = details;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "RefugeeDashboardTableViewEntriesModel{" +
                "type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
