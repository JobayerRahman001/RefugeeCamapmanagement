package cse213.refugeecampfinalproject.RefugeeandAdmin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class DonationsController
{
    @javafx.fxml.FXML
    private TableColumn<DonationsModel, String> DonorNameTableCol;
    @javafx.fxml.FXML
    private TextField budgetTextField;
    @javafx.fxml.FXML
    private ComboBox<String> categoryComboBox;
    @javafx.fxml.FXML
    private TableView<DonationsModel> donationsTableView;
    @javafx.fxml.FXML
    private TableColumn<DonationsModel, String> DonationIDTableCol;
    @javafx.fxml.FXML
    private TableColumn<DonationsModel, String> StatusTableCol;
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private Label donationsMsgLabel;
    @javafx.fxml.FXML
    private TableColumn<DonationsModel, String> CategoryTableCol;
    @javafx.fxml.FXML
    private TableColumn<DonationsModel, String> DonatedAmountTableCol;
    @javafx.fxml.FXML
    private TableColumn<DonationsModel, String> AllocatedAmountTableCol;

    ArrayList<DonationsModel>donationsList = new ArrayList<>();



    @javafx.fxml.FXML
    public void initialize() {
        donationsList.clear();
        donationsList.add(new DonationsModel("D001", "Alice", 1000,0 , "Pending", "", ""));
        donationsList.add(new DonationsModel("D002", "UNICEF", 15000,0 , "Pending", "", ""));
        donationsList.add(new DonationsModel("D003", "Anonymous", 2000,0 , "Pending", "", ""));

        categoryComboBox.getItems().addAll("Shelters", "Clothing", "Food and Water", "Education", "Healthcare", "Emergency Resources");

        DonationIDTableCol.setCellValueFactory(new PropertyValueFactory<>("donationID"));
        DonorNameTableCol.setCellValueFactory(new PropertyValueFactory<>("donorName"));
        DonatedAmountTableCol.setCellValueFactory(new PropertyValueFactory<>("donatedAmount"));
        AllocatedAmountTableCol.setCellValueFactory(new PropertyValueFactory<>("allocatedAmount"));
        StatusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        CategoryTableCol.setCellValueFactory(new PropertyValueFactory<>("category"));

        donationsTableView.getItems().clear();
        donationsTableView.getItems().addAll(donationsList);
    }

    @javafx.fxml.FXML
    public void backtoDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/AdminDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Admin Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void allocateOnClick(ActionEvent actionEvent) {
        DonationsModel selectedDonation = donationsTableView.getSelectionModel().getSelectedItem();
        String category = categoryComboBox.getValue();
        String enteredAmount = amountTextField.getText().trim();
        String enteredBudget = budgetTextField.getText().trim();

        if (selectedDonation == null) {
            donationsMsgLabel.setText("Select a donation to assign");
            return;
        }
        if(category ==null || enteredAmount.isEmpty() || enteredBudget.isEmpty()) {
            donationsMsgLabel.setText("Missing Fields");
            return;
        }
        double Amount = Double.parseDouble(enteredAmount);
        double Budget = Double.parseDouble(enteredBudget);
        if(Amount>Budget) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Budget Limit is exceeding");
            alert.setContentText("Entered amount is exceeding the budget set for this category.");
            alert.showAndWait();
        }
        double updatedAllocatedAmount = selectedDonation.getAllocatedAmount()+Amount;
        double updatedDonatedAmount = selectedDonation.getDonatedAmount() - Amount;
        selectedDonation.setCategory(category);
        selectedDonation.setAllocatedAmount(updatedAllocatedAmount);
        selectedDonation.setDonatedAmount(updatedDonatedAmount);
        selectedDonation.setBudget(String.valueOf(enteredBudget));
        selectedDonation.setStatus("Allocated");

        donationsTableView.refresh();
        donationsMsgLabel.setText("Allocation successful!");
    }
}