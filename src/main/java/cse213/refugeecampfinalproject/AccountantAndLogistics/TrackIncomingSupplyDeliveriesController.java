package cse213.refugeecampfinalproject.AccountantAndLogistics;

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
import java.time.LocalDate;
import java.util.Objects;

public class TrackIncomingSupplyDeliveriesController
{
    @javafx.fxml.FXML
    private TableColumn<IncomingSupplyDeliveryModel,String> statusColum;
    @javafx.fxml.FXML
    private TableColumn<IncomingSupplyDeliveryModel,String> supplierColum;
    @javafx.fxml.FXML
    private TableColumn<IncomingSupplyDeliveryModel,Integer> quantityColum;
    @javafx.fxml.FXML
    private TableView<IncomingSupplyDeliveryModel> trackincomesupplyTableView;
    @javafx.fxml.FXML
    private DatePicker deliverydatepicker;
    @javafx.fxml.FXML
    private Label deliveryStatusLabel;
    @javafx.fxml.FXML
    private ComboBox<String> catagoryComboBox;
    @javafx.fxml.FXML
    private TextField suppliernameTextField;
    @javafx.fxml.FXML
    private TableColumn<IncomingSupplyDeliveryModel,String> catagoryColum;
    @javafx.fxml.FXML
    private TableColumn<IncomingSupplyDeliveryModel, LocalDate> supplierdateColum;
    @javafx.fxml.FXML
    private TextField quantityTextField;

    private final ObservableList<IncomingSupplyDeliveryModel> deliveryList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() { supplierColum.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        catagoryColum.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantityColum.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        supplierdateColum.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        statusColum.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Bind table view to data list
        trackincomesupplyTableView.setItems(deliveryList);

        // Add some example categories
        catagoryComboBox.getItems().addAll("Food", "Clothing", "Medicine", "Shelter Equipment");

    }

    @javafx.fxml.FXML
    public void gobacktoaccountlogisticsdashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/AccountantAndLogistics/AccountantAndLogisticsDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Accountant Logistics Coordinator Controller");
        stage.show();
    }

    @javafx.fxml.FXML
    public void lognewdeliveryOnAction(ActionEvent actionEvent) {
        suppliernameTextField.clear();
        quantityTextField.clear();
        catagoryComboBox.getSelectionModel().clearSelection();
        deliverydatepicker.setValue(null);
        deliveryStatusLabel.setText("Ready to log new delivery...");
    }

    @javafx.fxml.FXML
    public void submtdeliveryOnAction(ActionEvent actionEvent) {
        String supplier = suppliernameTextField.getText();
        String category = catagoryComboBox.getValue();
        String quantityText = quantityTextField.getText();
        LocalDate date = deliverydatepicker.getValue();

        // Validation
        if (supplier.isEmpty() || category == null || quantityText.isEmpty() || date == null) {
            deliveryStatusLabel.setText("Please fill in all fields.");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            deliveryStatusLabel.setText("Quantity must be a number.");
            return;
        }

        // Add new delivery to the table
        IncomingSupplyDeliveryModel record = new IncomingSupplyDeliveryModel(supplier, category, quantity, date, "Pending Verification");
        deliveryList.add(record);

        deliveryStatusLabel.setText("Delivery logged successfully.");
    }
}