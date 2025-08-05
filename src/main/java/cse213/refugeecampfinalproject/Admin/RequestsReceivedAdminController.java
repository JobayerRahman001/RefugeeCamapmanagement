package cse213.refugeecampfinalproject.Admin;

import cse213.refugeecampfinalproject.Refugee.AssignedResourcesModel;
import cse213.refugeecampfinalproject.Refugee.ResourceRequestsModel;
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

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class RequestsReceivedAdminController {
    @javafx.fxml.FXML
    private TableColumn<ResourceRequestsModel, String> quantityTableCol;
    @javafx.fxml.FXML
    private TableColumn<ResourceRequestsModel, String> reasonTableCol;
    @javafx.fxml.FXML
    private TableView<ResourceRequestsModel> requestsReceivedTableView;
    @javafx.fxml.FXML
    private TableColumn<ResourceRequestsModel, String> refugeeIDTableCol;
    @javafx.fxml.FXML
    private TableColumn<ResourceRequestsModel, String> statusTableCol;
    @javafx.fxml.FXML
    private TableColumn<ResourceRequestsModel, String> requestTypeTableCol;
    @javafx.fxml.FXML
    private TableColumn<AllResourcesModel, String> availabilityTableCol;
    @javafx.fxml.FXML
    private TableColumn<AllResourcesModel, String> inventoryTableCol;
    @javafx.fxml.FXML
    private TableView<AllResourcesModel> inventoryTableView;
    @javafx.fxml.FXML
    private Label ResourceRequestsMsgLabel;

    public static ArrayList<ResourceRequestsModel> ResourceRequestsList = new ArrayList<>();
    public static ArrayList<AllResourcesModel> InventoryList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        InventoryList.clear();
        InventoryList.add(new AllResourcesModel("Shirt", "15"));
        InventoryList.add(new AllResourcesModel("Jacket", "10"));
        InventoryList.add(new AllResourcesModel("Blanket", "20"));
        InventoryList.add(new AllResourcesModel("Shawl", "12"));
        InventoryList.add(new AllResourcesModel("Female Attire", "17"));
        InventoryList.add(new AllResourcesModel("Male Attire", "18"));
        InventoryList.add(new AllResourcesModel("Children Attire", "13"));
        InventoryList.add(new AllResourcesModel("Extra Food", "25"));
        InventoryList.add(new AllResourcesModel("Medicine", "30"));

        inventoryTableCol.setCellValueFactory(new PropertyValueFactory<>("resourceName"));
        availabilityTableCol.setCellValueFactory(new PropertyValueFactory<>("availableQuantity"));

        inventoryTableView.getItems().clear();
        inventoryTableView.getItems().addAll(InventoryList);

        ResourceRequestsList.clear();
        ResourceRequestsList.addAll(ResourceRequestsModel.ResourceRequestsList);
        //dummy data
        ResourceRequestsList.add(new ResourceRequestsModel("R01", "Jacket", "2", "cold", "Pending"));
        ResourceRequestsList.add(new ResourceRequestsModel("R05", "Female Attire", "1", "-", "Pending"));

        refugeeIDTableCol.setCellValueFactory(new PropertyValueFactory<>("refugeeID"));
        requestTypeTableCol.setCellValueFactory(new PropertyValueFactory<>("requestType"));
        quantityTableCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        reasonTableCol.setCellValueFactory(new PropertyValueFactory<>("reason"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        requestsReceivedTableView.getItems().clear();
        requestsReceivedTableView.getItems().addAll(ResourceRequestsList);
    }

    @javafx.fxml.FXML
    public void goBackToDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Admin/AdminDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Admin Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void rejectRequestsOnClick(ActionEvent actionEvent) {
        ResourceRequestsModel selected = requestsReceivedTableView.getSelectionModel().getSelectedItem();
        if (selected != null && !selected.getStatus().equalsIgnoreCase("Rejected")) {
            selected.setStatus("Rejected");
            requestsReceivedTableView.refresh();
        }
    }

    @javafx.fxml.FXML
    public void approveRequestsOnClick(ActionEvent actionEvent) {
        ResourceRequestsModel selected = requestsReceivedTableView.getSelectionModel().getSelectedItem();
        if (selected != null && !selected.getStatus().equalsIgnoreCase("Approved")) {
            String requestedItem = selected.getRequestType();
            int requestedQty = Integer.parseInt(selected.getQuantity());
            for (AllResourcesModel items : InventoryList) {
                if (items.getResourceName().equalsIgnoreCase(requestedItem)) {
                    int availableQty = Integer.parseInt(items.getAvailableQuantity());
                    if (requestedQty <= availableQty) {
                        int updatedQty = availableQty - requestedQty;
                        items.setAvailableQuantity(String.valueOf(updatedQty));
                        selected.setStatus("Approved");
                        requestsReceivedTableView.refresh();
                        inventoryTableView.refresh();
                        AssignedResourcesModel shelterResource = new AssignedResourcesModel(requestedItem, requestedQty + " Approved", LocalDate.now().toString());
                        AssignedResourcesModel.assignedList.add(shelterResource);
                    } else {
                        ResourceRequestsMsgLabel.setText("Not enough stock.");

                    }
                }
            }
        }
    }
}
