package cse213.refugeecampfinalproject.AccountantAndLogistics;

import cse213.refugeecampfinalproject.Refugee.HealthServicesModel;
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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class ManageEquipmentMaintenanceRepairsContrller {
    @javafx.fxml.FXML
    private TextField equipmentnameTextField;
    @javafx.fxml.FXML
    private TableView<EquipmentManagementModel> manageequipmentTabelView;
    @javafx.fxml.FXML
    private TextArea issuedescriptionTextArea;
    @javafx.fxml.FXML
    private ComboBox prioritylabelComboBox;
    @javafx.fxml.FXML
    private TableColumn<EquipmentManagementModel, String> statusColum;
    @javafx.fxml.FXML
    private TableColumn<EquipmentManagementModel, String> issueColum;
    @javafx.fxml.FXML
    private TableColumn<EquipmentManagementModel, Double> costColum;
    @javafx.fxml.FXML
    private TableColumn<EquipmentManagementModel, String> equipmentColum;
    @javafx.fxml.FXML
    private TableColumn<EquipmentManagementModel, String> technicinColum;
    @javafx.fxml.FXML
    private TableColumn<EquipmentManagementModel, LocalDate> repairdateColum;
    @javafx.fxml.FXML
    private TableColumn<EquipmentManagementModel, String> priorityColum;
    @javafx.fxml.FXML
    private Label maintencelabel;

    private final ObservableList<EquipmentManagementModel> maintenanceList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        equipmentColum.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
        issueColum.setCellValueFactory(new PropertyValueFactory<>("issueDescription"));
        priorityColum.setCellValueFactory(new PropertyValueFactory<>("priority"));
        technicinColum.setCellValueFactory(new PropertyValueFactory<>("technician"));
        repairdateColum.setCellValueFactory(new PropertyValueFactory<>("repairDate"));
        statusColum.setCellValueFactory(new PropertyValueFactory<>("status"));
        costColum.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Bind table to list
        manageequipmentTabelView.setItems(maintenanceList);

        prioritylabelComboBox.setItems(FXCollections.observableArrayList("High", "Medium", "Low"));

    }

    @javafx.fxml.FXML
    public void GoBacktoAccountLogisticDashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/AccountantAndLogistics/AccountantAndLogisticsDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Accountant Logistics Coordinator Controller");
        stage.show();
    }

    @javafx.fxml.FXML
    public void schedulerepairOnAction(ActionEvent actionEvent) {
        try {
            String equipmentName = equipmentnameTextField.getText();
            String issue = issuedescriptionTextArea.getText();
            String priority = prioritylabelComboBox.getValue().toString();

            if (equipmentName.isEmpty() || issue.isEmpty() || priority == null) {
                maintencelabel.setText("Please fill in all fields!");
                return;
            }

            // Simulate system assigning technician & repair date
            String technician = "Technician A";
            LocalDate repairDate = LocalDate.now().plusDays(3); // Example: repair after 3 days
            String status = "Scheduled";
            double cost = 0.0; // Will be updated after repair

            EquipmentManagementModel maintenance = new EquipmentManagementModel(
                    equipmentName, issue, priority, technician, repairDate, status, cost
            );

            maintenanceList.add(maintenance);
            maintencelabel.setText("Repair scheduled successfully!");

            // Clear fields
            equipmentnameTextField.clear();
            issuedescriptionTextArea.clear();
            prioritylabelComboBox.setValue(null);

        } catch (Exception e) {
            maintencelabel.setText("Error scheduling repair!");
        }
    }

    @javafx.fxml.FXML
    public void saveastxtOnAction(ActionEvent actionEvent) {
        FileWriter fw = null;
        try {
            File f = new File("Equipment.txt");
            if (f.exists()) {
                fw = new FileWriter(f);
            } else {
                fw = new FileWriter(f);
            }

            String str = "";
            for (EquipmentManagementModel a : maintenanceList) {
                str += a.toString() + "\n";
            }

            fw.write(str);
            fw.close();
            showAlert("Appointments saved as text file successfully!");
        } catch (Exception e) {
            showAlert("Error saving appointments as text: " + e.getMessage());
        } finally {
            try {
                if (fw != null) fw.close();
            } catch (Exception e) {
                showAlert("Error closing file: " + e.getMessage());
            }
        }
    }
    public void showAlert(String m){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(m);
        alert.showAndWait();
    }
}