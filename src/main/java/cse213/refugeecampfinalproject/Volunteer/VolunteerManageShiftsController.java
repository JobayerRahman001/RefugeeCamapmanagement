package cse213.refugeecampfinalproject.Volunteer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class VolunteerManageShiftsController
{
    @javafx.fxml.FXML
    private TableView<ShiftsModel> availableShiftsTable;
    @javafx.fxml.FXML
    private TableColumn<ShiftsModel, String> shiftTimeColumn;
    @javafx.fxml.FXML
    private TableColumn<ShiftsModel, String> shiftDateColumn;
    @javafx.fxml.FXML
    private TableColumn<ShiftsModel, String> shiftRoleColumn;
    @javafx.fxml.FXML
    private Button registerShiftButton;
    @javafx.fxml.FXML
    private TableColumn registeredShiftsList;
    @javafx.fxml.FXML
    private Label registeredShiftsLabel;
    @javafx.fxml.FXML
    private Button cancelShiftButton;

    private javafx.collections.ObservableList<ShiftsModel> shifts = javafx.collections.FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Sample data
        shifts.add(new ShiftsModel("2025-08-12", "10:00", "Food Distribution"));
        shifts.add(new ShiftsModel("2025-08-13", "14:00", "Teaching Aid"));
        shifts.add(new ShiftsModel("2025-08-14", "09:00", "Sanitation Support"));

        // Bind TableColumns to ShiftsModel fields (must match getter names)
        shiftDateColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("date"));
        shiftTimeColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("time"));
        shiftRoleColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("role"));

        // Show the data in TableView
        availableShiftsTable.setItems(shifts);
    }

    @Deprecated
    public void registerButton(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void registerButtonOnAction(javafx.event.ActionEvent actionEvent) {
        shifts.add(new ShiftsModel("2025-08-12", "10:00", "Food Distribution"));
        shifts.add(new ShiftsModel("2025-08-13", "14:00", "Teaching Aid"));
        shifts.add(new ShiftsModel("2025-08-14", "09:00", "Sanitation Support"));

        shiftDateColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("date"));
        shiftTimeColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("time"));
        shiftRoleColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("role"));

        availableShiftsTable.setItems(shifts);
    }

    @javafx.fxml.FXML
    public void cancelShiftButtonOnAction(javafx.event.ActionEvent actionEvent) {
        ShiftsModel selectedShift = availableShiftsTable.getSelectionModel().getSelectedItem();

        if (selectedShift == null) {
            registeredShiftsLabel.setText("Please select a shift to cancel.");
            return;
        }

        if (selectedShift.isAvailable()) {
            registeredShiftsLabel.setText("Shift is not registered yet.");
            return;
        }

        selectedShift.setAvailable(true);
        registeredShiftsLabel.setText("Shift cancelled.");
        availableShiftsTable.refresh();
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(javafx.event.ActionEvent actionEvent) throws java.io.IOException {
        javafx.scene.Parent home = javafx.fxml.FXMLLoader.load(java.util.Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Volunteer/VolunteerDashboard.fxml")));
        javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new javafx.scene.Scene(home));
        stage.setTitle("Volunteer Dashboard");
        stage.show();
    }
}