package cse213.refugeecampfinalproject.UNHCR;

public class CountryDonationSummaryModel {
    private String countryName;
    private double totalAmount;

    public CountryDonationSummaryModel(String countryName, double totalAmount) {
        this.countryName = countryName;
        this.totalAmount = totalAmount;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "CountryDonationSummaryModel{" +
                "countryName='" + countryName + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
