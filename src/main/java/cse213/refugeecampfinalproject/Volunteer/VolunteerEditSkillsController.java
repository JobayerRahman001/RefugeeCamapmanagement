package cse213.refugeecampfinalproject.Volunteer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

import static cse213.refugeecampfinalproject.Volunteer.VolunteerSignupController.VolunteerList;

public class VolunteerEditSkillsController {

    @javafx.fxml.FXML
    private Label validationLabel;
    @javafx.fxml.FXML
    private TableView<VolunteerModel> skillsTable;
    @javafx.fxml.FXML
    private TableColumn<VolunteerModel, String> skillNameColumn;
    @javafx.fxml.FXML
    private TextField VolIDTextField;
    @javafx.fxml.FXML
    private TextField newSkillField;


    @javafx.fxml.FXML
    public void initialize() {

        skillNameColumn.setCellValueFactory(new PropertyValueFactory<>("volSkills"));

        skillsTable.getItems().clear();
        for (VolunteerModel volunteer : VolunteerList) {
            if (volunteer.getVolID().equals(LoggedInVolModel.getLoggedInVolID())) {
                skillsTable.getItems().add(volunteer);
            }
        }
        if (VolunteerList.isEmpty()) {
            skillsTable.getItems().add(new VolunteerModel("", "", "Fluency in Arabic", "", true));
        }
    }

    @javafx.fxml.FXML
    public void addSkillButtonOnAction(ActionEvent actionEvent) {
        String volID = VolIDTextField.getText().trim();
        String newSkill = newSkillField.getText().trim();

        if (volID.isEmpty() || newSkill.isEmpty()) {
            validationLabel.setText("Please fill in all fields");
            return;
        }

        if (!volID.equals(LoggedInVolModel.getLoggedInVolID())) {
            validationLabel.setText("Please enter your own ID!");
            return;
        }

        for (VolunteerModel vm : VolunteerList) {
            if (volID.equals(vm.getVolID()) && newSkill.equals(vm.getVolSkills())) {
                validationLabel.setText("Skill already exists");
                return;
            }
        }

        VolunteerModel newVolSkill = new VolunteerModel(volID, null, newSkill, null, true);
        VolunteerList.add(newVolSkill);

        ObservableList<VolunteerModel> loggedInSkills = FXCollections.observableArrayList();
        for (VolunteerModel vm : VolunteerList) {
            if (vm.getVolID().equals(LoggedInVolModel.getLoggedInVolID())) {
                loggedInSkills.add(vm);
            }
        }

        skillsTable.setItems(loggedInSkills);
        skillsTable.refresh();
        validationLabel.setText("Skill added");
        newSkillField.clear();
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/Volunteer/VolunteerDashboard.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Volunteer Dashboard");
        stage.show();
    }
}
