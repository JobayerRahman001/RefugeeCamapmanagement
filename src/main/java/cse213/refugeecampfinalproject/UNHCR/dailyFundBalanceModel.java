package cse213.refugeecampfinalproject.UNHCR;

public class dailyFundBalanceModel {
    private double availableBalance;
    private String lastUpdated;
    private boolean isFresh;

    public dailyFundBalanceModel(double availableBalance, String lastUpdated, boolean isFresh) {
        this.availableBalance = availableBalance;
        this.lastUpdated = lastUpdated;
        this.isFresh = isFresh;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isFresh() {
        return isFresh;
    }

    public void setFresh(boolean fresh) {
        isFresh = fresh;
    }

    @Override
    public String toString() {
        return "dailyFundBalanceModel{" +
                "availableBalance=" + availableBalance +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", isFresh=" + isFresh +
                '}';
    }
}
