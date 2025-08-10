package cse213.refugeecampfinalproject.AccountantAndLogistics;

import java.time.LocalDate;
import java.util.ArrayList;

public class recordCostModel {
    private String serviceName;
    private double amount;
    private LocalDate date;
    private String description;

    private static final ArrayList<recordCostModel> expenseList = new ArrayList<>();

    public recordCostModel(String serviceName, double amount, LocalDate date, String description) {
        this.serviceName = serviceName;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public static boolean addExpense(recordCostModel expense) {
        if (expense.amount > 0 && expense.serviceName != null && !expense.serviceName.isEmpty()) {
            expenseList.add(expense);
            return true;
        }
        return false;
    }

    public static ArrayList<recordCostModel> getAllExpenses() {
        return expenseList;
    }

    @Override
    public String toString() {
        return "recordCostModel{" +
                "serviceName='" + serviceName + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
