package cse213.refugeecampfinalproject.ResourceManager;

import cse213.refugeecampfinalproject.Refugee.ResourceRequestsModel;
import cse213.refugeecampfinalproject.Volunteer.VolunteerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ResourceInventorySpoiledGoodsController {
    @javafx.fxml.FXML
    private TableView<ResourceInventorySpoiledGoodsModel> expiryTableView;
    @javafx.fxml.FXML
    private Label updateConfirmationLabel;
    @javafx.fxml.FXML
    private TableColumn<ResourceInventorySpoiledGoodsModel, String> itemNameTableCol;
    @javafx.fxml.FXML
    private TableColumn<ResourceInventorySpoiledGoodsModel, String> expiryQtyTableCol;
    @javafx.fxml.FXML
    private TableColumn<ResourceInventorySpoiledGoodsModel, String> expiryDateTableCol;
    @javafx.fxml.FXML
    private TableColumn<ResourceInventorySpoiledGoodsModel, String> statusTableCol;

    ArrayList<ResourceInventorySpoiledGoodsModel>GoodsList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        itemNameTableCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        expiryDateTableCol.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        expiryQtyTableCol.setCellValueFactory(new PropertyValueFactory<>("expiryQty"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        if(GoodsList.isEmpty()) {
            //dummy data
            expiryTableView.getItems().addAll(new ResourceInventorySpoiledGoodsModel("Milk Powder", "2025-07-15", "10 kg", "Expired"));
            expiryTableView.getItems().addAll(new ResourceInventorySpoiledGoodsModel("Canned Beans", "2025-08-01", "24 cans", "Expired"));
            expiryTableView.getItems().addAll(new ResourceInventorySpoiledGoodsModel("Rice", "2025-06-30", "50 kg", "Expired"));
            expiryTableView.getItems().addAll(new ResourceInventorySpoiledGoodsModel("Bread", "2025-08-03", "30 loaves", "Expired"));
            expiryTableView.getItems().addAll(new ResourceInventorySpoiledGoodsModel("Medicine - Paracetamol", "2025-07-20", "120 tablets", "Expired"));
            expiryTableView.getItems().addAll(new ResourceInventorySpoiledGoodsModel("Vegetable Oil", "2025-07-28", "20 liters", "Expired"));
        }
    }

    @javafx.fxml.FXML
    public void markDisposalButtonOnAction(ActionEvent actionEvent) {
        ResourceInventorySpoiledGoodsModel selected = expiryTableView.getSelectionModel().getSelectedItem();
        if (selected != null && !selected.getStatus().equalsIgnoreCase("Disposed")) {
            selected.setStatus("Disposed");
            expiryTableView.refresh();
        }
    }

        @javafx.fxml.FXML
        public void backToHomeOnClick (ActionEvent actionEvent) throws IOException {
            Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ResourcesDashboardController.fxml")));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(home));
            stage.setTitle("Resources Manager Dashboard");
            stage.show();
        }
    }