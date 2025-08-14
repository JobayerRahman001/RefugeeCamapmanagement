package cse213.refugeecampfinalproject.ResourcesManager;

import cse213.refugeecampfinalproject.ResourcesManager.Donation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ResourceMedicalDonationsLogController {

    @javafx.fxml.FXML
    private TableView<Donation> donationsTable;
    @javafx.fxml.FXML
    private TableColumn<Donation, String> itemNameCol;
    @javafx.fxml.FXML
    private TableColumn<Donation, Integer> quantityCol;
    @javafx.fxml.FXML
    private TableColumn<Donation, String> expiryCol;
    @javafx.fxml.FXML
    private TableColumn<Donation, String> recipientCol;
    @javafx.fxml.FXML
    private TableColumn<Donation, Boolean> lowStockCol;

    @javafx.fxml.FXML
    private Button updateInventoryBtn;
    @javafx.fxml.FXML
    private Label statusLabel;

    private final ObservableList<Donation> donationList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        expiryCol.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        recipientCol.setCellValueFactory(new PropertyValueFactory<>("recipient"));
        lowStockCol.setCellValueFactory(new PropertyValueFactory<>("lowStock"));


        donationList.addAll(
                new Donation("Bandages", 50, "2025-12-31", "Clinic A", false),
                new Donation("Paracetamol", 10, "2025-06-30", "Elderly", true),
                new Donation("Syringes", 100, "2026-01-15", "Clinic B", false)
        );

        donationsTable.setItems(donationList);
        statusLabel.setText("Select an item to update inventory.");
    }

    @javafx.fxml.FXML
    public void updateInventoryBtnOnAction(ActionEvent event) {
        Donation selected = donationsTable.getSelectionModel().getSelectedItem();
        if (selected != null) {

            selected.setQuantity(selected.getQuantity() + 10);
            statusLabel.setText("Updated quantity for: " + selected.getItemName());
            donationsTable.refresh(); // needed since Donation is not using JavaFX properties
        } else {
            statusLabel.setText("Please select an item first.");
        }
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                "/cse213/refugeecampfinalproject/ResourcesManager/ResourcesDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Resources Dashboard");
        stage.show();
    }
}
