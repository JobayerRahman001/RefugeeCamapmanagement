package cse213.refugeecampfinalproject.Volunteer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class VolunteerManageShiftsController {

    @javafx.fxml.FXML
    private TableView<ShiftsModel> availableShiftsTable;

    @javafx.fxml.FXML
    private TableColumn<ShiftsModel, String> shiftDateColumn;

    @javafx.fxml.FXML
    private TableColumn<ShiftsModel, String> shiftTimeColumn;

    @javafx.fxml.FXML
    private TableColumn<ShiftsModel, String> shiftRoleColumn;

    @javafx.fxml.FXML
    private TableView<ShiftsModel> registeredShiftsTable;

    @javafx.fxml.FXML
    private TableColumn<ShiftsModel, String> regShiftDateColumn;

    @javafx.fxml.FXML
    private TableColumn<ShiftsModel, String> regShiftTimeColumn;

    @javafx.fxml.FXML
    private TableColumn<ShiftsModel, String> regShiftRoleColumn;

    @javafx.fxml.FXML
    private Label registeredShiftsLabel;

    private final ObservableList<ShiftsModel> shifts = FXCollections.observableArrayList();
    private final ObservableList<ShiftsModel> registeredShifts = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        shifts.addAll(
                new ShiftsModel("2025-08-12", "10:00", "Food Distribution"),
                new ShiftsModel("2025-08-13", "14:00", "Teaching Aid"),
                new ShiftsModel("2025-08-14", "09:00", "Sanitation Support")
        );

        shiftDateColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("date"));
        shiftTimeColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("time"));
        shiftRoleColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("role"));
        availableShiftsTable.setItems(shifts);

        regShiftDateColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("date"));
        regShiftTimeColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("time"));
        regShiftRoleColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("role"));
        registeredShiftsTable.setItems(registeredShifts);
    }

    @javafx.fxml.FXML
    public void registerButtonOnAction(ActionEvent actionEvent) {
        ShiftsModel selectedShift = availableShiftsTable.getSelectionModel().getSelectedItem();
        if (selectedShift == null) {
            registeredShiftsLabel.setText("Please select a shift to register.");
            return;
        }
        if (registeredShifts.stream().anyMatch(s -> s.getDate().equals(selectedShift.getDate())
                && s.getTime().equals(selectedShift.getTime())
                && s.getRole().equals(selectedShift.getRole()))) {
            registeredShiftsLabel.setText("You have already registered for this shift.");
            return;
        }
        registeredShifts.add(selectedShift);
        registeredShiftsLabel.setText("Shift registered.");
    }

    @javafx.fxml.FXML
    public void cancelShiftButtonOnAction(ActionEvent actionEvent) {
        ShiftsModel selectedShift = registeredShiftsTable.getSelectionModel().getSelectedItem();
        if (selectedShift == null) {
            registeredShiftsLabel.setText("Please select a registered shift to cancel.");
            return;
        }
        registeredShifts.remove(selectedShift);
        registeredShiftsLabel.setText("Shift cancelled.");
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(
                getClass().getResource("/cse213/refugeecampfinalproject/Volunteer/VolunteerDashboard.fxml")));
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Volunteer Dashboard");
    }
}
