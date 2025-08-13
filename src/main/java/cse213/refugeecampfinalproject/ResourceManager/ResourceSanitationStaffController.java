package cse213.refugeecampfinalproject.ResourceManager;

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

import java.io.IOException;
import java.util.Objects;

public class ResourceSanitationStaffController
{
    @javafx.fxml.FXML
    private ComboBox<String> zoneComboBox;
    @javafx.fxml.FXML
    private TableView<SanitationStaffModel> familyTableView;
    @javafx.fxml.FXML
    private TableColumn<SanitationStaffModel, String> staffIDColumn;
    @javafx.fxml.FXML
    private TableColumn<SanitationStaffModel, String> staffNameColumn;
    @javafx.fxml.FXML
    private TableColumn<SanitationStaffModel, String> MembersColumn;
    @javafx.fxml.FXML
    private Label AvailableStaffLabel;
    @javafx.fxml.FXML
    private Label selectZoneLabel;
    @javafx.fxml.FXML
    private Button assignToZoneButton;
    @javafx.fxml.FXML
    private Label assignmentConfirmationLabel;

    private final ObservableList<SanitationStaffModel> staffList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        staffIDColumn.setCellValueFactory(new PropertyValueFactory<>("staffID"));
        staffNameColumn.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        MembersColumn.setCellValueFactory(new PropertyValueFactory<>("availabilityStatus"));

        zoneComboBox.setItems(FXCollections.observableArrayList("Zone A", "Zone B", "Zone C"));

        staffList.addAll(
                new SanitationStaffModel("STF-101", "Rahim", "Available"),
                new SanitationStaffModel("STF-102", "Karim", "Busy"),
                new SanitationStaffModel("STF-103", "Salma", "Available")
        );
        familyTableView.setItems(staffList);
    }

    @javafx.fxml.FXML
    public void zoneCmboBoxOnAction(ActionEvent actionEvent) {
        String selectedZone = zoneComboBox.getValue();
        if (selectedZone != null) {
            AvailableStaffLabel.setText("Available Staff in " + selectedZone + ":");
        }
    }

    @javafx.fxml.FXML
    public void assignToZoneBtnOnAction(ActionEvent actionEvent) {
        SanitationStaffModel selectedStaff = familyTableView.getSelectionModel().getSelectedItem();
        String selectedZone = zoneComboBox.getValue();

        if (selectedStaff == null || selectedZone == null) {
            assignmentConfirmationLabel.setText("Please select both a zone and a staff member.");
            return;
        }

        selectedStaff.setAvailabilityStatus("Assigned");
        familyTableView.refresh();

        assignmentConfirmationLabel.setText(
                "Staff " + selectedStaff.getStaffName() + " assigned to " + selectedZone + "."
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Assignment Successful");
        alert.setHeaderText(null);
        alert.setContentText("Staff " + selectedStaff.getStaffName() + " successfully assigned to " + selectedZone + ".");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(
                getClass().getResource("/cse213/refugeecampfinalproject/homepage.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Home");
        stage.show();
    }
}
