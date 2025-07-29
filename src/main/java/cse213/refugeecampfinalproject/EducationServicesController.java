package cse213.refugeecampfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class EducationServicesController {
    @javafx.fxml.FXML
    private Label edServiceMsgLabel;
    @javafx.fxml.FXML
    private ComboBox<String> programNameComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> ageGroupComboBox;
    @javafx.fxml.FXML
    private TextField refugeeIDTextField;

    @javafx.fxml.FXML
    public void initialize() {
        programNameComboBox.getItems().addAll("Vocational Training", "English Language", "Basic Literacy", "Basic Schooling", "Bangla Language");
        ageGroupComboBox.getItems().addAll("5 to 10 years", "11 to 17 years", "18+");
    }

    public static ArrayList<EducationServicesModel> EducacationServicesList = new ArrayList<>();

    @javafx.fxml.FXML
    public void enrollEducationOnClick(ActionEvent actionEvent) {
        if (refugeeIDTextField.getText().isEmpty()||ageGroupComboBox.getValue() == null || programNameComboBox.getValue() == null) {
            edServiceMsgLabel.setText("Please select Age Group and Program Name and enter your ID to enroll");
            return;
        }
        String selectedAgeGroup = ageGroupComboBox.getValue();
        String selectedProgram = programNameComboBox.getValue();
        String selectedRefugeeID = refugeeIDTextField.getText().trim();

        String timing = switch (selectedProgram) {
            case "Vocational Training" -> "Sun-Tue 10:00 AM";
            case "English Language" -> "Mon-Wed 2:00 PM";
            case "Basic Literacy" -> "Tue-Thu 9:00 AM";
            case "Basic Schooling" -> "Daily 8:00 AM";
            case "Bangla Language" -> "Wed-Fri 11:00 AM";
            default -> null;
        };
        for (EducationServicesModel ESM : EducacationServicesList) {
            if (ESM.getTiming().equals(timing)) {
                edServiceMsgLabel.setText("Class time conflict");
                return;
            }
        }
        EducationServicesModel newEnrollment = new EducationServicesModel(selectedRefugeeID, selectedAgeGroup, selectedProgram, timing);
        EducacationServicesList.add(newEnrollment);

        edServiceMsgLabel.setText("Enrolled in" + selectedProgram + timing);
    }

    @javafx.fxml.FXML
    public void backtoDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/RefugeeDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Refugee Dashboard");
        stage.show();
    }
}