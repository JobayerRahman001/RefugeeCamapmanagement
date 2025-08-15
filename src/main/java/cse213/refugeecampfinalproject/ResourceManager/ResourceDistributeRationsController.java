package cse213.refugeecampfinalproject.ResourceManager;

import cse213.refugeecampfinalproject.Admin.AllResourcesModel;
import cse213.refugeecampfinalproject.Refugee.AssignedResourcesModel;
import cse213.refugeecampfinalproject.Refugee.Refugee;
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

import static cse213.refugeecampfinalproject.Refugee.AssignedResourcesController.assignedList;
import static cse213.refugeecampfinalproject.Refugee.RefugeeRegisterController.RefugeeList;

public class ResourceDistributeRationsController
{
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableView<Refugee> DistributionTableView;
    @javafx.fxml.FXML
    private ComboBox<String> itemComboBox;
    @javafx.fxml.FXML
    private TableColumn<Refugee, String> RefIDTableCol;
    @javafx.fxml.FXML
    private TableColumn<Refugee, String> FamSizeTableCol;
    @javafx.fxml.FXML
    private TableView<AllResourcesModel> StockTableView;
    @javafx.fxml.FXML
    private TableColumn<AllResourcesModel, String> AvailabilityTableCol;
    @javafx.fxml.FXML
    private TableColumn<AllResourcesModel, String> ItemTableCol;
    @javafx.fxml.FXML
    private TextField servingsSizeTextField;

    ArrayList<AllResourcesModel>ResourcesList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        itemComboBox.getItems().addAll("Rice", "Lentil", "Water", "Fish", "Meat", "Eggs");

        ResourcesList.clear();
        ResourcesList.add(new AllResourcesModel("Rice", "95"));
        ResourcesList.add(new AllResourcesModel("Lentil", "100"));
        ResourcesList.add(new AllResourcesModel("Eggs", "100"));
        ResourcesList.add(new AllResourcesModel("Fish", "98"));
        ResourcesList.add(new AllResourcesModel("Meat", "100"));
        ResourcesList.add(new AllResourcesModel("Water", "200"));

        ItemTableCol.setCellValueFactory(new PropertyValueFactory<>("resourceName"));
        AvailabilityTableCol.setCellValueFactory(new PropertyValueFactory<>("availableQuantity"));

        StockTableView.getItems().clear();
        StockTableView.getItems().addAll(ResourcesList);

        RefIDTableCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        FamSizeTableCol.setCellValueFactory(new PropertyValueFactory<>("refFamSize"));

        DistributionTableView.setItems(RefugeeList);
        //dummy data
        if(RefugeeList.isEmpty()) {
            RefugeeList.add(new Refugee("R01", null, null, 0, null, "5", null));
            RefugeeList.add(new Refugee("R05", null, null, 0, null, "3", null));
        }
    }

    @javafx.fxml.FXML
    public void distributeRationsOnClick(ActionEvent actionEvent) {
        Refugee selected = DistributionTableView.getSelectionModel().getSelectedItem();
        String item = itemComboBox.getValue();
        String servings = servingsSizeTextField.getText().trim();

        if (selected == null) {
            messageLabel.setText("Please select Refugee");
            return;
        }
        if (item == null || servings.isEmpty()) {
            messageLabel.setText("PLease select item and quantity");
            return;
        }
        for (AllResourcesModel items : ResourcesList) {
            int servingsQty = Integer.parseInt(servings);
            if (items.getResourceName().equalsIgnoreCase(item)) {
                int availableQty = Integer.parseInt(items.getAvailableQuantity());
                if (servingsQty > availableQty) {
                    messageLabel.setText("Not enough in stock");
                    return;
                } else {
                    int updatedQty = availableQty - servingsQty;
                    items.setAvailableQuantity(String.valueOf(updatedQty));
                    messageLabel.setText("Ration Successfully Distributed");
                    StockTableView.refresh();
                    DistributionTableView.refresh();
                    assignedList.add(new AssignedResourcesModel("Ration", item + servings + "servings", java.time.LocalDate.now().toString()));
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void backToDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/ResourceManager/ResourcesDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Resources Dashboard");
        stage.show();
    }

    @Deprecated
    public void servingsSizeTextField(ActionEvent actionEvent) {
    }
}