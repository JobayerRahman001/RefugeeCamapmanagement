package cse213.refugeecampfinalproject.UNHCR;

public class monthlySummaryModel {
    private String month;
    private boolean dataComplete;

    public monthlySummaryModel(String month, boolean dataComplete) {
        this.month = month;
        this.dataComplete = dataComplete;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public boolean isDataComplete() {
        return dataComplete;
    }

    public void setDataComplete(boolean dataComplete) {
        this.dataComplete = dataComplete;
    }

    @Override
    public String toString() {
        return "monthlySummaryModel{" +
                "month='" + month + '\'' +
                ", dataComplete=" + dataComplete +
                '}';
    }
}
