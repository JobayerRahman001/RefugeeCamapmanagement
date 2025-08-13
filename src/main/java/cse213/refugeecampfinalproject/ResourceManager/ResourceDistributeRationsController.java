package cse213.refugeecampfinalproject.ResourceManager;

import cse213.refugeecampfinalproject.Admin.AllResourcesModel;
import cse213.refugeecampfinalproject.Refugee.Refugee;
import cse213.refugeecampfinalproject.Refugee.RefugeeRegisterController;
import cse213.refugeecampfinalproject.Refugee.ResourceRequestsModel;
import cse213.refugeecampfinalproject.Refugee.ResourcesInventoryController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static cse213.refugeecampfinalproject.Refugee.RefugeeRegisterController.RefugeeList;
import static cse213.refugeecampfinalproject.Refugee.ResourcesInventoryController.ResourceRequestsList;

public class ResourceDistributeRationsController
{
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableView<Refugee> DistributionTableView;
    @javafx.fxml.FXML
    private ComboBox<String> QuantityComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> itemComboBox;
    @javafx.fxml.FXML
    private TableColumn<ResourcesDistributeRationsModel, String> FoodDistributeTableCol;
    @javafx.fxml.FXML
    private TableColumn<Refugee, String> RefIDTableCol;
    @javafx.fxml.FXML
    private TableColumn<Refugee, String> FamSizeTableCol;
    @javafx.fxml.FXML
    private TableColumn<ResourcesDistributeRationsModel, String> WaterTableCol;
    @javafx.fxml.FXML
    private TableView<AllResourcesModel> StockTableView;
    @javafx.fxml.FXML
    private TableColumn<AllResourcesModel, String> AvailabilityTableCol;
    @javafx.fxml.FXML
    private TableColumn<AllResourcesModel, String> ItemTableCol;

    ArrayList<AllResourcesModel>ResourcesList = new ArrayList<>();
    
    @javafx.fxml.FXML
    public void initialize() {
        ResourcesList.clear();
        ResourcesList.add(new AllResourcesModel("Rice", "100kg"));
        ResourcesList.add(new AllResourcesModel("Lentil", "70 kg"));
        ResourcesList.add(new AllResourcesModel("Eggs", "15 dozens"));
        ResourcesList.add(new AllResourcesModel("Fish", "60kg"));
        ResourcesList.add(new AllResourcesModel("Meat", "50kg"));

        ItemTableCol.setCellValueFactory(new PropertyValueFactory<>("resourceName"));
        AvailabilityTableCol.setCellValueFactory(new PropertyValueFactory<>("availableQuantity"));

        StockTableView.getItems().clear();
        StockTableView.getItems().addAll(ResourcesList);

        RefugeeList.add(new Refugee("R01", null, null, 0, null, "5", null));
        RefugeeList.add(new Refugee("R05", null, null, 0, null, "3", null));

        RefIDTableCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        FamSizeTableCol.setCellValueFactory(new PropertyValueFactory<>("refFamSize"));
        FoodDistributeTableCol.setCellValueFactory(new PropertyValueFactory<>("food"));
        WaterTableCol.setCellValueFactory(new PropertyValueFactory<>("water"));

        DistributionTableView.setItems(RefugeeList);
    }

    @javafx.fxml.FXML
    public void distributeRationsOnClick(ActionEvent actionEvent) {
        Refugee selectedRef = DistributionTableView.getSelectionModel().getSelectedItem();
        String item = itemComboBox.getValue();
        String quantity = QuantityComboBox.getValue();
        if (selectedRef == null) {
            messageLabel.setText("Please select Refugee");
            return;
        }
        if (item == null || quantity == null) {
            messageLabel.setText("PLease select item and quantity");
            return;
        }
        int requestedQty = Integer.parseInt(quantity);
        for (AllResourcesModel items : ResourcesList) {
            if (items.getResourceName().equalsIgnoreCase(item)) {
                int availableQty = Integer.parseInt(items.getAvailableQuantity());
                if (requestedQty <= availableQty) {
                    int updatedQty = availableQty - requestedQty;
                    items.setAvailableQuantity(String.valueOf(updatedQty));
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void backToDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/ResourcesManager/ResourcesDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Resources Dashboard");
        stage.show();
    }
}