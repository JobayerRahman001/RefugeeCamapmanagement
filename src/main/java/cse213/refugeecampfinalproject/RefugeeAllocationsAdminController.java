package cse213.refugeecampfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class RefugeeAllocationsAdminController {
    @javafx.fxml.FXML
    private TableColumn<RefugeeAllocationsAdminModel, String> moneyTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> categoryComboBox;
    @javafx.fxml.FXML
    private TableColumn<RefugeeAllocationsAdminModel, String> FoodWaterTableCol;
    @javafx.fxml.FXML
    private TableColumn<RefugeeAllocationsAdminModel, String> ShelterTableCol;
    @javafx.fxml.FXML
    private TableView<RefugeeAllocationsAdminModel> RefugeeAllocatiionsTableView;
    @javafx.fxml.FXML
    private Label RefugeeAllocationsMsgLabel;
    @javafx.fxml.FXML
    private TableColumn<RefugeeAllocationsAdminModel, String> refugeeIDTableCol;
    @javafx.fxml.FXML
    private TableColumn<RefugeeAllocationsAdminModel, String> clothesTableCol;

public static ArrayList<RefugeeAllocationsAdminModel> allocationList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        categoryComboBox.getItems().addAll("Food and Water", "Clothes", "Shelter", "Money");

        moneyTableCol.setCellValueFactory(new PropertyValueFactory<>("money"));
        FoodWaterTableCol.setCellValueFactory(new PropertyValueFactory<>("foodWater"));
        ShelterTableCol.setCellValueFactory(new PropertyValueFactory<>("shelter"));
        clothesTableCol.setCellValueFactory(new PropertyValueFactory<>("clothes"));
        refugeeIDTableCol.setCellValueFactory(new PropertyValueFactory<>("refugeeID"));

        RefugeeAllocatiionsTableView.getItems().clear();
        if(allocationList.isEmpty()) {
            //dummy data
            RefugeeAllocatiionsTableView.getItems().addAll(new RefugeeAllocationsAdminModel("R001", "", "", "", ""));
            RefugeeAllocatiionsTableView.getItems().addAll(new RefugeeAllocationsAdminModel("R002", "", "", "", ""));
            RefugeeAllocatiionsTableView.getItems().addAll(new RefugeeAllocationsAdminModel("R003", "", "", "", ""));
            RefugeeAllocatiionsTableView.getItems().addAll(new RefugeeAllocationsAdminModel("R004", "", "", "", ""));
            RefugeeAllocatiionsTableView.getItems().addAll(new RefugeeAllocationsAdminModel("R005", "", "", "", ""));
            RefugeeAllocatiionsTableView.getItems().addAll(new RefugeeAllocationsAdminModel("R006", "", "", "", ""));
            RefugeeAllocatiionsTableView.getItems().addAll(new RefugeeAllocationsAdminModel("R007", "", "", "", ""));
            RefugeeAllocatiionsTableView.getItems().addAll(new RefugeeAllocationsAdminModel("R008", "", "", "", ""));
            RefugeeAllocatiionsTableView.getItems().addAll(new RefugeeAllocationsAdminModel("R009", "", "", "", ""));
            RefugeeAllocatiionsTableView.getItems().addAll(new RefugeeAllocationsAdminModel("R0010", "", "", "", ""));
        }


        RefugeeAllocatiionsTableView.getItems().addAll(allocationList);
    }

    @javafx.fxml.FXML
    public void allocateResourcesOnClick(ActionEvent actionEvent) {
        RefugeeAllocationsAdminModel selected = RefugeeAllocatiionsTableView.getSelectionModel().getSelectedItem();

        if (selected == null || categoryComboBox.getValue() == null) {
            RefugeeAllocationsMsgLabel.setText("Please select refugee and category.");
            return;
        }
        if (categoryComboBox.getValue().equals("Food and Water")) {
            selected.setFoodWater("Allocated");
        }
        if (categoryComboBox.getValue().equals("Clothes")) {
            selected.setClothes("Allocated");
        }
        if (categoryComboBox.getValue().equals("Shelter")) {
            selected.setShelter("Allocated");
        }
        if (categoryComboBox.getValue().equals("Money")) {
            selected.setMoney("Allocated");
        }
        RefugeeAllocatiionsTableView.refresh();
    }

    @javafx.fxml.FXML
    public void GoBackToDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/AdminDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Admin Dashboard");
        stage.show();
    }
}