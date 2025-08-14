package cse213.refugeecampfinalproject.ResourceManager;

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

public class ResourcesInventoryRestockController
{
    @javafx.fxml.FXML
    private TextField clarityLabel;
    @javafx.fxml.FXML
    private Label phLabel;
    @javafx.fxml.FXML
    private Label ETALabel;
    @javafx.fxml.FXML
    private TableColumn<ResourceStockModel, String> tankStatusColumn;
    @javafx.fxml.FXML
    private Button updateStockButton;
    @javafx.fxml.FXML
    private TableColumn<ResourceStockModel, String> CurrentQtyColumn;
    @javafx.fxml.FXML
    private TableView<ResourceStockModel> restockTableView;
    @javafx.fxml.FXML
    private Label updateConfirmationLabel;
    @javafx.fxml.FXML
    private Label assignStaffLabel;
    @javafx.fxml.FXML
    private TextField phField;
    @javafx.fxml.FXML
    private TableColumn<ResourceStockModel, String> ItemNameColumn;

    private final ObservableList<ResourceStockModel> stockList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        ItemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        CurrentQtyColumn.setCellValueFactory(new PropertyValueFactory<>("currentQty"));
        tankStatusColumn.setCellValueFactory(new PropertyValueFactory<>("receivedQty"));

        stockList.addAll(
                new ResourceStockModel("Rice", "120", "0"),
                new ResourceStockModel("Water", "300", "0"),
                new ResourceStockModel("Lentil", "150", "0")
        );

        restockTableView.setItems(stockList);
    }

    @javafx.fxml.FXML
    public void updateStockButtonOnAction(ActionEvent actionEvent) {
        ResourceStockModel selectedItem = restockTableView.getSelectionModel().getSelectedItem();
        String phValue = phField.getText().trim();
        String clarityValue = clarityLabel.getText().trim();

        if (selectedItem == null) {
            updateConfirmationLabel.setText("Please select an item to update.");
            return;
        }
        if (phValue.isEmpty() || clarityValue.isEmpty()) {
            updateConfirmationLabel.setText("Please enter pH and clarity levels.");
            return;
        }

        try {
            int receivedQty = Integer.parseInt(clarityValue);
            int currentQty = Integer.parseInt(selectedItem.getCurrentQty());
            int updatedQty = currentQty + receivedQty;

            selectedItem.setCurrentQty(String.valueOf(updatedQty));
            selectedItem.setReceivedQty(String.valueOf(receivedQty));
            restockTableView.refresh();

            updateConfirmationLabel.setText(
                    selectedItem.getItemName() + " updated. pH: " + phValue + ", Added: " + receivedQty
            );

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Stock Update");
            alert.setHeaderText(null);
            alert.setContentText("Inventory successfully updated for " + selectedItem.getItemName());
            alert.showAndWait();

        } catch (NumberFormatException e) {
            updateConfirmationLabel.setText("Invalid clarity/quantity input.");
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
