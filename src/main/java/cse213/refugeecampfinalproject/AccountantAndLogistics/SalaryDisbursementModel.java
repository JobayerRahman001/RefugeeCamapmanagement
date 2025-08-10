package cse213.refugeecampfinalproject.AccountantAndLogistics;

public class SalaryDisbursementModel {
    private String name;
    private String role;
    private double baseSalary;
    private int attendanceDays;
    private double deductions;
    private double netSalary;

    public SalaryDisbursementModel(String name, String role, double baseSalary, int attendanceDays, double deductions, double netSalary) {
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
        this.attendanceDays = attendanceDays;
        this.deductions = deductions;
        this.netSalary = netSalary;
        calculateNetSalary();

    }
    private void calculateNetSalary() {

        this.netSalary = baseSalary - deductions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getAttendanceDays() {
        return attendanceDays;
    }

    public void setAttendanceDays(int attendanceDays) {
        this.attendanceDays = attendanceDays;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return "salaryDisbursementModel{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", baseSalary=" + baseSalary +
                ", attendanceDays=" + attendanceDays +
                ", deductions=" + deductions +
                ", netSalary=" + netSalary +
                '}';
    }
}
