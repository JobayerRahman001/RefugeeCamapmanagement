package cse213.refugeecampfinalproject.Volunteer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class VolunteerManageShiftsController
{
    @javafx.fxml.FXML
    private TableView availableShiftsTable;
    @javafx.fxml.FXML
    private TableColumn shiftTimeColumn;
    @javafx.fxml.FXML
    private TableColumn shiftDateColumn;
    @javafx.fxml.FXML
    private TableColumn shiftRoleColumn;
    @javafx.fxml.FXML
    private Button registerShiftButton;
    @javafx.fxml.FXML
    private TableColumn registeredShiftsList;
    @javafx.fxml.FXML
    private Label registeredShiftsLabel;
    @javafx.fxml.FXML
    private Button cancelShiftButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void registerButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void registerButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void cancelShiftButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) {
    }
}