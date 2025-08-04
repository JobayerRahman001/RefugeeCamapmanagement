package cse213.refugeecampfinalproject.Refugee;

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
import java.util.ArrayList;
import java.util.Objects;

public class RefugeeSkillsProfileController
{
    @javafx.fxml.FXML
    private TableView<RefugeeSkillsModel> skillProfileTableView;
    @javafx.fxml.FXML
    private TableView<RefugeeSkillsModel> possibleWorkTableView;
    @javafx.fxml.FXML
    private TableColumn<RefugeeSkillsModel, String> programTableCol;
    @javafx.fxml.FXML
    private Label skillProfileMsgLabel;
    @javafx.fxml.FXML
    private TextField certificateTextField;
    @javafx.fxml.FXML
    private TableColumn<RefugeeSkillsModel, String> skillsTableCol;
    @javafx.fxml.FXML
    private TableColumn<RefugeeSkillsModel, String> reqSkillsTableCol;
    @javafx.fxml.FXML
    private TextField addSkillsTextField;
    @javafx.fxml.FXML
    private TableColumn<RefugeeSkillsModel, String> certificatesTableCol;
    @javafx.fxml.FXML
    private TextField addPrevJobTextField;
    @javafx.fxml.FXML
    private TableColumn<RefugeeSkillsModel, String> prevJobTableCol;


    ArrayList<RefugeeSkillsModel> RefugeeSkillsList = new ArrayList<>();
    ArrayList<RefugeeSkillsModel> availablePrograms = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        skillsTableCol.setCellValueFactory(new PropertyValueFactory<>("skills"));
        prevJobTableCol.setCellValueFactory(new PropertyValueFactory<>("previousJob"));
        certificatesTableCol.setCellValueFactory(new PropertyValueFactory<>("certificates"));

        programTableCol.setCellValueFactory(new PropertyValueFactory<>("matchedPrograms"));
        reqSkillsTableCol.setCellValueFactory(new PropertyValueFactory<>("requiredSkills"));

        availablePrograms.add(new RefugeeSkillsModel(null, null, null,  "Tailoring Workshop", "tailoring"));
        availablePrograms.add(new RefugeeSkillsModel(null, null, null,  "Carpentry Workshop", "carpentry"));
        availablePrograms.add(new RefugeeSkillsModel(null, null, null,  "Tech Workshop", "IT Skills"));
        availablePrograms.add(new RefugeeSkillsModel(null, null, null,  "Healthcare Assistance", "first-aid"));
    }


    @javafx.fxml.FXML
    public void addInProfileOnClick(ActionEvent actionEvent) {
        if (addSkillsTextField.getText().isEmpty() && addPrevJobTextField.getText().isEmpty() && certificateTextField.getText().isEmpty()) {
            skillProfileMsgLabel.setText("Fill up at least one field to add into profile");
            return;
        }
        skillProfileMsgLabel.setText("Added to profile");

        String skills = addSkillsTextField.getText().trim();
        String previousJob = addPrevJobTextField.getText().trim();
        String certificates = certificateTextField.getText().trim();

        ArrayList<String> matchedProgramsList = new ArrayList<>();
        ArrayList<String> requiredSkillsList = new ArrayList<>();

        for(RefugeeSkillsModel refugeeSkillsModel : availablePrograms) {
            if (skills.contains(refugeeSkillsModel.getRequiredSkills().toLowerCase())) {
                matchedProgramsList.add(refugeeSkillsModel.getMatchedPrograms());
                requiredSkillsList.add(refugeeSkillsModel.getRequiredSkills());
            }
        }

        String matchedPrograms = String.join(", ", matchedProgramsList);
        String requiredSkills = String.join(", ", requiredSkillsList);

        RefugeeSkillsModel profileEntry = new RefugeeSkillsModel(skills, previousJob, certificates, matchedPrograms, requiredSkills);

        RefugeeSkillsList.add(profileEntry);
        skillProfileTableView.getItems().clear();
        skillProfileTableView.getItems().addAll(RefugeeSkillsList);
        possibleWorkTableView.getItems().clear();;
        possibleWorkTableView.getItems().addAll(profileEntry);
    }

    @javafx.fxml.FXML
    public void backtoDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Refugee/RefugeeDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Refugee Dashboard");
        stage.show();
    }
}