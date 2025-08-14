package cse213.refugeecampfinalproject.Refugee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    public static ObservableList<EducationServicesModel> EducationServicesList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void enrollEducationOnClick(ActionEvent actionEvent) {
        if (refugeeIDTextField.getText().isEmpty() || ageGroupComboBox.getValue() == null || programNameComboBox.getValue() == null) {
            edServiceMsgLabel.setText("Please select Age Group and Program Name and enter your ID to enroll");
            return;
        }
        String selectedAgeGroup = ageGroupComboBox.getValue();
        String selectedProgram = programNameComboBox.getValue();
        String selectedRefugeeID = refugeeIDTextField.getText().trim();
        if (!selectedRefugeeID.equals(LoggedInRefModel.getLoggedInRefugeeId())) {
            edServiceMsgLabel.setText("Please enter your own refugee ID!");
            return;
        }

        String timing = "";

        if (selectedProgram.equals("Vocational Training") && selectedAgeGroup.equals("5 to 10 years")) {
            timing = "Sun-Tue 10:00 AM";
        } else if (selectedProgram.equals("Vocational Training") && selectedAgeGroup.equals("11 to 17 years")) {
            timing = "Sun-Tue 12:00 PM";
        } else if (selectedProgram.equals("Vocational Training") && selectedAgeGroup.equals("18+")) {
            timing = "Sun-Tue 4:00 PM";
        } else if (selectedProgram.equals("English Language") && selectedAgeGroup.equals("5 to 10 years")) {
            timing = "Mon-Wed 9:00 AM";
        } else if (selectedProgram.equals("English Language") && selectedAgeGroup.equals("11 to 17 years")) {
            timing = "Mon-Wed 2:00 PM";
        } else if (selectedProgram.equals("English Language") && selectedAgeGroup.equals("18+")) {
            timing = "Mon-Wed 4:00 PM";
        } else if (selectedProgram.equals("Basic Literacy") && selectedAgeGroup.equals("5 to 10 years")) {
            timing = "Tue-Thu 8:00 AM";
        } else if (selectedProgram.equals("Basic Literacy") && selectedAgeGroup.equals("11 to 17 years")) {
            timing = "Tue-Thu 9:00 AM";
        } else if (selectedProgram.equals("Basic Literacy") && selectedAgeGroup.equals("18+")) {
            timing = "Tue-Thu 3:00 PM";
        } else if (selectedProgram.equals("Basic Schooling") && selectedAgeGroup.equals("5 to 10 years")) {
            timing = "Daily 8:00 AM";
        } else if (selectedProgram.equals("Basic Schooling") && selectedAgeGroup.equals("11 to 17 years")) {
            timing = "Daily 10:00 AM";
        } else if (selectedProgram.equals("Basic Schooling") && selectedAgeGroup.equals("18+")) {
            timing = "Daily 2:00 PM";
        } else if (selectedProgram.equals("Bangla Language") && selectedAgeGroup.equals("5 to 10 years")) {
            timing = "Wed-Fri 8:00 AM";
        } else if (selectedProgram.equals("Bangla Language") && selectedAgeGroup.equals("11 to 17 years")) {
            timing = "Wed-Fri 11:00 AM";
        } else if (selectedProgram.equals("Bangla Language") && selectedAgeGroup.equals("18+")) {
            timing = "Wed-Fri 3:00 PM";
        }

        for (EducationServicesModel ESM : EducationServicesList) {
            if (ESM.getTiming().equals(timing)) {
                edServiceMsgLabel.setText("Class time conflict");
                return;
            }
        }
        EducationServicesModel newEnrollment = new EducationServicesModel(selectedRefugeeID, selectedAgeGroup, selectedProgram, timing);
        EducationServicesList.add(newEnrollment);

        edServiceMsgLabel.setText("Enrolled in " + selectedProgram + " at " + timing);
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