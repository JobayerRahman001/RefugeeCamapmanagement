package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import cse213.refugeecampfinalproject.Refugee.HealthServicesModel;
import cse213.refugeecampfinalproject.Refugee.HealthcareServicesController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.ArrayList;
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
    public static ArrayList<HealthServicesModel> HealthcareServicesList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {

        HealthcareServicesList.clear();
        HealthcareServicesList.addAll(HealthcareServicesController.HealthcareServicesList);

        HealthcareServicesList.add(new HealthServicesModel("R01", null, "fever", "Sun 2pm", null, null, null, null, null, "Pending"));
        HealthcareServicesList.add(new HealthServicesModel("R05", null, "sore throat", "Wed 5pm", null, null, null, null, null, "Pending"));

        for (HealthServicesModel healthModel : HealthcareServicesList){
            patientCombobox.getItems().add(healthModel.getRefugeeID());
        }

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
        saveMedicalNotes(selectedPatient, diagnosis, prescribedMedicine, remarks);
        //ObservableList<HealthServicesModel> observableList = FXCollections.observableArrayList(HealthcareServicesList);

        //MedicalNoteModel medicalNote = new MedicalNoteModel(selectedPatient, diagnosis, prescribedMedicine, remarks);
        confirmationLabel.setText("Medical notes saved successfully!");
        patientCombobox.setValue(null);
        diagnosisTextArea.clear();
        prescribmedicinTextArea.clear();
        remarksTextArea.clear();
    }
    private void saveMedicalNotes(String patient, String diagnosis, String prescribedMedicine, String remarks) {
        System.out.println("Saving medical notes for " + patient);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Prescribed Medicine: " + prescribedMedicine);
        System.out.println("Remarks: " + remarks);
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