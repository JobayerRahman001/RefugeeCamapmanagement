package cse213.refugeecampfinalproject.UNHCR;

import java.time.LocalDate;

public class DonationRecord {
    private LocalDate donationDate;
    private double donationAmount;

    public DonationRecord(LocalDate donationDate, double donationAmount) {
        this.donationDate = donationDate;
        this.donationAmount = donationAmount;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(double donationAmount) {
        this.donationAmount = donationAmount;
    }

    @Override
    public String toString() {
        return "DonationRecord{" +
                "donationDate=" + donationDate +
                ", donationAmount=" + donationAmount +
                '}';
    }
}
