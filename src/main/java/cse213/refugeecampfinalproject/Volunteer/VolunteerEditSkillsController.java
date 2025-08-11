package cse213.refugeecampfinalproject.Volunteer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class VolunteerEditSkillsController
{
    @javafx.fxml.FXML
    private javafx.scene.control.TextField newSkillField;
    @javafx.fxml.FXML
    private javafx.scene.control.Label validationLabel;
    @javafx.fxml.FXML
    private javafx.scene.control.Button saveButton;
    @javafx.fxml.FXML
    private javafx.scene.control.Label InputLabel;
    @javafx.fxml.FXML
    private javafx.scene.control.Button addSkillButton;
    @javafx.fxml.FXML
    private javafx.scene.control.TableColumn<String, String> skillNameColumn;
    @javafx.fxml.FXML
    private javafx.scene.control.TableView<String> skillsTable;

    private javafx.collections.ObservableList<String> skills = javafx.collections.FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        skillNameColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()));

        skills.addAll("First Aid Certified", "Fluency in Arabic");

        skillsTable.setItems(skills);
    }

    @javafx.fxml.FXML
    public void addSkillButtonOnAction(javafx.event.ActionEvent actionEvent) {
        String newSkill = newSkillField.getText().trim();

        if (newSkill.isEmpty()) {
            validationLabel.setText("Skill cannot be empty.");
            return;
        }

        if (skills.contains(newSkill)) {
            validationLabel.setText("Skill already exists.");
            return;
        }

        skills.add(newSkill);
        newSkillField.clear();
        validationLabel.setText("Skill added.");
    }

    @javafx.fxml.FXML
    public void saveButtonOnAction(javafx.event.ActionEvent actionEvent) {
        if (skills.isEmpty()) {
            validationLabel.setText("Please add at least one skill before saving.");
            return;
        }

        // Save logic here (e.g., update volunteer profile or persist data)

        validationLabel.setText("Profile updated successfully.");
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