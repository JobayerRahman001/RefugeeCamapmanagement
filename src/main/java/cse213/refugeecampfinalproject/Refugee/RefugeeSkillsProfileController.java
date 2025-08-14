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
import java.util.Locale;
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

        RefugeeSkillsModel skillsEntry = new RefugeeSkillsModel(skills, previousJob, certificates, null, null);
        RefugeeSkillsList.add(skillsEntry);
        skillProfileTableView.getItems().setAll(RefugeeSkillsList);

        for(RefugeeSkillsModel refugeePrograms : availablePrograms) {
            String reqProgramSkills = refugeePrograms.getRequiredSkills().toLowerCase(Locale.ROOT);
            if(skills.toLowerCase().contains(reqProgramSkills)) {
                RefugeeSkillsModel matchedProgram = new RefugeeSkillsModel(null, null, null, refugeePrograms.getMatchedPrograms(), refugeePrograms.getRequiredSkills());
                possibleWorkTableView.getItems().add(matchedProgram);
            }
        }
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