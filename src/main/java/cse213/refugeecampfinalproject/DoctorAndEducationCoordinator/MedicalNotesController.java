package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MedicalNotesController {
    @javafx.fxml.FXML
    private TextArea diagnosisTextArea;
    @javafx.fxml.FXML
    private TextArea prescribmedicinTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> patientCombobox;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private Label confirmationLabel;

    @javafx.fxml.FXML
    public void initialize() {
        patientCombobox.getItems().addAll("");
    }

    @javafx.fxml.FXML
    public void saveInfoOnAtion(ActionEvent actionEvent) {
        String selectedPatient = patientCombobox.getValue();
        String diagnosis = diagnosisTextArea.getText();
        String prescribedMedicine = prescribmedicinTextArea.getText();
        String remarks = remarksTextArea.getText();
        if (selectedPatient == null || diagnosis.isEmpty() || prescribedMedicine.isEmpty() || remarks.isEmpty()) {
            confirmationLabel.setText("Please fill in all fields.");
            return;
        }
        MedicalNoteModel medicalNote = new MedicalNoteModel(selectedPatient, diagnosis, prescribedMedicine, remarks);
        confirmationLabel.setText("Medical notes saved successfully!");
    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Doctor/HealthPortal.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Health Portal");
        stage.show();
    }
}