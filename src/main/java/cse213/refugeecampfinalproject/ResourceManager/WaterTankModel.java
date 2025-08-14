package cse213.refugeecampfinalproject.ResourceManager;

public class WaterTankModel {
    private String tankName;
    private double level;
    private String status;

    public WaterTankModel(String tankName, double level) {
        this.tankName = tankName;
        this.level = level;
        this.status = calculateStatus(level);
    }

    private String calculateStatus(double level) {
        if (level >= 75) return "Full";
        else if (level >= 30) return "Half";
        else return "Low";
    }

    public String getTankName() {
        return tankName;
    }

    public void setTankName(String tankName) {
        this.tankName = tankName;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
        this.status = calculateStatus(level);
    }

    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WaterTankModel{" +
                "tankName='" + tankName + '\'' +
                ", level=" + level +
                ", status='" + status + '\'' +
                '}';
    }
}
