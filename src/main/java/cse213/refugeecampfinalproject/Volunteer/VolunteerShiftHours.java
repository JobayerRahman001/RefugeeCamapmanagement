package cse213.refugeecampfinalproject.Volunteer;

public class VolunteerShiftHours {
    private String shiftType;
    private double hours;

    public VolunteerShiftHours(String shiftType, double hours) {
        this.shiftType = shiftType;
        this.hours = hours;
    }

    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(String shiftType) {
        this.shiftType = shiftType;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "VolunteerShiftHours{" +
                "shiftType='" + shiftType + '\'' +
                ", hours=" + hours +
                '}';
    }
}