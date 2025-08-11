package cse213.refugeecampfinalproject.Volunteer;

public class ShiftsModel {
    private String date;
    private String time;
    private String role;
    private boolean available;

    public ShiftsModel(String date, String time, String role) {
        this.date = date;
        this.time = time;
        this.role = role;
        this.available = true;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "ShiftsModel{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", role='" + role + '\'' +
                ", available=" + available +
                '}';
    }

}
