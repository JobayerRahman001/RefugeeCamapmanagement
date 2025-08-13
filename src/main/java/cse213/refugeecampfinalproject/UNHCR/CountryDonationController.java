package cse213.refugeecampfinalproject.UNHCR;

import cse213.refugeecampfinalproject.Admin.DonationsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class CountryDonationController
{
    @javafx.fxml.FXML
    private TableView<CountryDonationSummaryModel> countrydonationTabelView;
    @javafx.fxml.FXML
    private TableView<DonationRecord> donationTabelView;
    @javafx.fxml.FXML
    private TableColumn<DonationRecord,LocalDate> donationdateColum;
    @javafx.fxml.FXML
    private TableColumn<CountryDonationSummaryModel,String> countrynameColum;
    @javafx.fxml.FXML
    private Label labelState;
    @javafx.fxml.FXML
    private TableColumn<DonationsModel,Double> donationammountColum;
    @javafx.fxml.FXML
    private TableColumn<CountryDonationSummaryModel,Double> totalammountColum;


    private ObservableList<CountryDonationSummaryModel> countryList = FXCollections.observableArrayList();
    private ObservableList<DonationRecord> donationHistory = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {countrynameColum.setCellValueFactory(new PropertyValueFactory<>("countryName"));
        totalammountColum.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));

        // Donation history table
        donationdateColum.setCellValueFactory(new PropertyValueFactory<>("donationDate"));
        donationammountColum.setCellValueFactory(new PropertyValueFactory<>("donationAmount"));

        countrydonationTabelView.setItems(countryList);
        donationTabelView.setItems(donationHistory);

        // Sample data for testing
        countryList.add(new CountryDonationSummaryModel("USA", 15000));
        countryList.add(new CountryDonationSummaryModel("UK", 12000));
        countryList.add(new CountryDonationSummaryModel("Canada", 9000));

        // Event: When user clicks a country, show donation history
        countrydonationTabelView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                CountryDonationSummaryModel selectedCountry = countrydonationTabelView.getSelectionModel().getSelectedItem();
                if (selectedCountry != null) {
                    loadDonationHistory(selectedCountry.getCountryName());
                }
            }
        });
    }
    private void loadDonationHistory(String countryName) {
        donationHistory.clear();

        // Simulated data (would normally come from a database)
        if (countryName.equals("USA")) {
            donationHistory.add(new DonationRecord(LocalDate.of(2025, 1, 15), 5000));
            donationHistory.add(new DonationRecord(LocalDate.of(2025, 3, 20), 10000));
        } else if (countryName.equals("UK")) {
            donationHistory.add(new DonationRecord(LocalDate.of(2025, 2, 5), 7000));
            donationHistory.add(new DonationRecord(LocalDate.of(2025, 4, 12), 5000));
        } else if (countryName.equals("Canada")) {
            donationHistory.add(new DonationRecord(LocalDate.of(2025, 1, 10), 4000));
            donationHistory.add(new DonationRecord(LocalDate.of(2025, 5, 8), 5000));
        }

        labelState.setText("Showing donations for: " + countryName);
    }
    @javafx.fxml.FXML
    public void downlodesummaryOnAction(ActionEvent actionEvent) {
        try (FileWriter writer = new FileWriter("CountryDonationsSummary.csv")) {
            writer.write("Country,Total Amount\n");
            for (CountryDonationSummaryModel summary : countryList) {
                writer.write(summary.getCountryName() + "," + summary.getTotalAmount() + "\n");
            }
            labelState.setText("Summary downloaded as CountryDonationsSummary.csv");
        } catch (IOException e) {
            labelState.setText("Error saving file: " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void viewcountrysummaryOnAction(ActionEvent actionEvent) {
        labelState.setText("Select a country to view donation history.");
    }

    @javafx.fxml.FXML
    public void gobacktoundashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/homepage.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Home");
        stage.show();

    }
}