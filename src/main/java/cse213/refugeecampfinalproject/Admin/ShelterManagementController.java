package cse213.refugeecampfinalproject.Admin;

import cse213.refugeecampfinalproject.Refugee.AssignedResourcesModel;
import cse213.refugeecampfinalproject.Refugee.Refugee;
import cse213.refugeecampfinalproject.Refugee.RefugeeRegisterController;
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

public class ShelterManagementController
{
    @javafx.fxml.FXML
    private TableView<ShelterManagementModel> availableSheltersTableView;
    @javafx.fxml.FXML
    private TableColumn<ShelterManagementModel, String> newRefugeeAgeTableCol;
    @javafx.fxml.FXML
    private TableColumn<ShelterManagementModel, String> newRefugeeIDTableCol;
    @javafx.fxml.FXML
    private TableView<ShelterManagementModel> assignedShelterTableView;
    @javafx.fxml.FXML
    private TableColumn<ShelterManagementModel, String> newRefugeeNameTableCol;
    @javafx.fxml.FXML
    private TableColumn<ShelterManagementModel, String> newRefugeeGenderTableCol;
    @javafx.fxml.FXML
    private TableColumn<ShelterManagementModel, String> assignedShelterTableCol;
    @javafx.fxml.FXML
    private TableColumn<ShelterManagementModel, String> newRefugeeFamSizeTableCol;
    @javafx.fxml.FXML
    private TextField shelterIDTextField;
    @javafx.fxml.FXML
    private TableView<Refugee> newRefugeeTableView;
    @javafx.fxml.FXML
    private TableColumn<ShelterManagementModel, String> avShelterCapacityTableCol;
    @javafx.fxml.FXML
    private TableColumn<ShelterManagementModel, String> avShelterIDTableCol;
    @javafx.fxml.FXML
    private TableColumn<ShelterManagementModel, String> assignedShelterRefTableCol;
    @javafx.fxml.FXML
    private TableColumn<ShelterManagementModel, String> avShelterLocaTableCol;
    @javafx.fxml.FXML
    private TextField refugeeIDTextField;
    @javafx.fxml.FXML
    private Label shelterManagementMsgLabel;

    ArrayList<ShelterManagementModel>shelterList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        shelterList.clear();;

        shelterList.add(new ShelterManagementModel(null, "S001", "Block A", 5));
        shelterList.add(new ShelterManagementModel(null, "S002", "Block A", 4));
        shelterList.add(new ShelterManagementModel(null, "S003", "Block A", 2));
        shelterList.add(new ShelterManagementModel(null, "S004", "Block B", 7));
        shelterList.add(new ShelterManagementModel(null, "S005", "Block B", 5));
        shelterList.add(new ShelterManagementModel(null, "S006", "Block B", 6));
        shelterList.add(new ShelterManagementModel(null, "S007", "Block C", 7));

        RefugeeRegisterController.RefugeeList.add(new Refugee("R01", "Amina", "1234", 32, "Female", "4", "Bangladeshi"));
        RefugeeRegisterController.RefugeeList.add(new Refugee("R02", "Roy", "5678", 45, "Male", "5", "Yemen"));
        RefugeeRegisterController.RefugeeList.add(new Refugee("R03", "Sohel", "9101", 37, "Male", "4", "Rohingya"));

        newRefugeeIDTableCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        newRefugeeNameTableCol.setCellValueFactory(new PropertyValueFactory<>("refName"));
        newRefugeeGenderTableCol.setCellValueFactory(new PropertyValueFactory<>("refGender"));
        newRefugeeAgeTableCol.setCellValueFactory(new PropertyValueFactory<>("refAge"));
        newRefugeeFamSizeTableCol.setCellValueFactory(new PropertyValueFactory<>("refFamSize"));

        avShelterIDTableCol.setCellValueFactory(new PropertyValueFactory<>("shelterID"));
        avShelterLocaTableCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        avShelterCapacityTableCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));

        assignedShelterRefTableCol.setCellValueFactory(new PropertyValueFactory<>("refugeeID"));
        assignedShelterTableCol.setCellValueFactory(new PropertyValueFactory<>("shelterID"));

        availableSheltersTableView.getItems().clear();
        availableSheltersTableView.getItems().addAll(shelterList);

        newRefugeeTableView.getItems().clear();
        newRefugeeTableView.getItems().addAll(RefugeeRegisterController.RefugeeList);

        assignedShelterTableView.getItems().clear();
    }

    @javafx.fxml.FXML
    public void backtoDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Admin/AdminDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Admin Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void assignShelterOnClick(ActionEvent actionEvent) {
        String refugeeID = refugeeIDTextField.getText().trim();
        String shelterID = shelterIDTextField.getText().trim();
        String location = null;

        if (refugeeID.isEmpty() || shelterID.isEmpty()) {
            shelterManagementMsgLabel.setText("Input Errorr");
            return;
        }
        Refugee selectedRefugee = null;
        for (Refugee r : newRefugeeTableView.getItems()) {
            if (r.getId().equals(refugeeID)) {
                selectedRefugee = r;
                break;
            }
        }
        ShelterManagementModel selectedShelter = null;
        for (ShelterManagementModel smm : availableSheltersTableView.getItems()) {
            if (smm.getShelterID().equals(shelterID)) {
                selectedShelter = smm;
            }
        }
        if (selectedRefugee != null & selectedShelter != null) {
            int famSize = Integer.parseInt(selectedRefugee.getRefFamSize());
            int sheleterCapacity = selectedShelter.getCapacity();

            if (sheleterCapacity < famSize) {
                shelterManagementMsgLabel.setText("Capacity Error");
                return;
            }
            selectedShelter.setCapacity(sheleterCapacity - famSize);
            availableSheltersTableView.refresh();

            newRefugeeTableView.getItems().remove(selectedRefugee);
            newRefugeeTableView.refresh();

            location = selectedShelter.getLocation();
            ShelterManagementModel shelterManagementModel = new ShelterManagementModel(refugeeID, shelterID, location, null);
            assignedShelterTableView.getItems().add(shelterManagementModel);
            assignedShelterTableView.refresh();

            String assignedDate = java.time.LocalDate.now().toString();
            String shelterDetails = selectedShelter.getLocation() + selectedShelter.getShelterID();

            AssignedResourcesModel shelterResource = new AssignedResourcesModel("Shelter", shelterDetails, assignedDate);
            AssignedResourcesModel.assignedList.add(shelterResource);

            shelterManagementMsgLabel.setText("Success");
        }
    }
}
