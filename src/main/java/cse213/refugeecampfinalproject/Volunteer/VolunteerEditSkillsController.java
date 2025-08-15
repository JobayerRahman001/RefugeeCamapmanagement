package cse213.refugeecampfinalproject.Volunteer;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class VolunteerEditSkillsController {

    @FXML private Label validationLabel;
    @FXML private TextField newSkillField;
    @FXML private Button saveButton;
    @FXML private Button addSkillButton;
    @FXML private TableView<VolunteerSkillsModel> skillsTable;
    @FXML private TableColumn<VolunteerSkillsModel, String> skillNameColumn;

    private final ObservableList<VolunteerSkillsModel> skillsList = FXCollections.observableArrayList();

    @FXML public void initialize() {

        skillNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSkill()));


        skillsList.addAll(
                new VolunteerSkillsModel("First Aid Certified"),
                new VolunteerSkillsModel("Fluency in Arabic")
        );

        skillsTable.setItems(skillsList);
    }

    @FXML public void addSkillOnClick(ActionEvent actionEvent) {
        String newSkill = newSkillField.getText().trim();

        if (newSkill.isEmpty()) {
            validationLabel.setText("Skill cannot be empty.");
            return;
        }

        boolean exists = skillsList.stream().anyMatch(s -> s.getSkill().equalsIgnoreCase(newSkill));
        if (exists) {
            validationLabel.setText("Skill already exists.");
            return;
        }

        skillsList.add(new VolunteerSkillsModel(newSkill));
        newSkillField.clear();
        validationLabel.setText("Skill added.");
        skillsTable.refresh();
    }

    @FXML public void saveOnClick(ActionEvent actionEvent) {
        if (skillsList.isEmpty()) {
            validationLabel.setText("Please add at least one skill before saving.");
            return;
        }


        validationLabel.setText("Profile updated successfully.");
    }

    @FXML public void backToDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent dashboard = FXMLLoader.load(Objects.requireNonNull(
                getClass().getResource("/cse213/refugeecampfinalproject/Volunteer/VolunteerDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(dashboard));
        stage.setTitle("Volunteer Dashboard");
        stage.show();
    }
}
