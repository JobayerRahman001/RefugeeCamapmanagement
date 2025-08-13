package cse213.refugeecampfinalproject.UNHCR;

public class QuaterlyImpactModel {
    private double educationPercent;
    private double healthPercent;
    private String infrastructureDate;
    private int enrollmentCount;
    private int patientCount;
    private String remarks;


    public QuaterlyImpactModel(double educationPercent, double healthPercent, String infrastructureDate, int enrollmentCount, int patientCount, String remarks) {
        this.educationPercent = educationPercent;
        this.healthPercent = healthPercent;
        this.infrastructureDate = infrastructureDate;
        this.enrollmentCount = enrollmentCount;
        this.patientCount = patientCount;
        this.remarks = remarks;
    }

    public double getEducationPercent() {
        return educationPercent;
    }

    public void setEducationPercent(double educationPercent) {
        this.educationPercent = educationPercent;
    }

    public double getHealthPercent() {
        return healthPercent;
    }

    public void setHealthPercent(double healthPercent) {
        this.healthPercent = healthPercent;
    }

    public String getInfrastructureDate() {
        return infrastructureDate;
    }

    public void setInfrastructureDate(String infrastructureDate) {
        this.infrastructureDate = infrastructureDate;
    }

    public int getEnrollmentCount() {
        return enrollmentCount;
    }

    public void setEnrollmentCount(int enrollmentCount) {
        this.enrollmentCount = enrollmentCount;
    }

    public int getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "quaterlyImpactModel{" +
                "educationPercent=" + educationPercent +
                ", healthPercent=" + healthPercent +
                ", infrastructureDate='" + infrastructureDate + '\'' +
                ", enrollmentCount=" + enrollmentCount +
                ", patientCount=" + patientCount +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
