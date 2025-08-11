package cse213.refugeecampfinalproject.Volunteer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class VolunteerSafetyAndSupplyController
{
    @javafx.fxml.FXML
    private javafx.scene.control.ComboBox<String> supplyComboBox;
    @javafx.fxml.FXML
    private javafx.scene.control.Button flagSupplyButton;
    @javafx.fxml.FXML
    private javafx.scene.control.Label reportLabel;
    @javafx.fxml.FXML
    private javafx.scene.control.TextField noteTextField;
    @javafx.fxml.FXML
    private javafx.scene.control.TextArea emergencyGuideArea;
    @javafx.fxml.FXML
    private javafx.scene.control.Label headinglabel;

    public static java.util.ArrayList<SupplyReportModel> supplyReportsList = new java.util.ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        supplyComboBox.getItems().addAll("Water", "Food", "Medical Supplies", "Sanitation Kits", "Shelter Materials");
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(javafx.event.ActionEvent actionEvent) throws java.io.IOException {
        javafx.scene.Parent home = javafx.fxml.FXMLLoader.load(java.util.Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Volunteer/VolunteerDashboard.fxml")));
        javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new javafx.scene.Scene(home));
        stage.setTitle("Volunteer Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void flagSupplyButtonOnAction(javafx.event.ActionEvent actionEvent) {
        String selectedItem = supplyComboBox.getValue();
        String note = noteTextField.getText().trim();

        if (selectedItem == null || selectedItem.isEmpty()) {
            reportLabel.setText("Please select an item.");
            return;
        }
        if (note.isEmpty()) {
            reportLabel.setText("Please add a note.");
            return;
        }

        SupplyReportModel report = new SupplyReportModel(selectedItem, note);
        supplyReportsList.add(report);

        reportLabel.setText("Report flagged for review.");
        noteTextField.clear();
        supplyComboBox.getSelectionModel().clearSelection();
    }
}