package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import cse213.refugeecampfinalproject.Refugee.HealthServicesModel;
import cse213.refugeecampfinalproject.Refugee.HealthcareServicesController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class UpdateVaccineRecordController
{

    @javafx.fxml.FXML
    private ComboBox<String> selectPatientComboBox;
    @javafx.fxml.FXML
    private TextField vaccinnameTextField;
    @javafx.fxml.FXML
    private TextArea vaccinoutputTextArea;
    @javafx.fxml.FXML
    private TextField doseTextField;
    @javafx.fxml.FXML
    private DatePicker datepicker;
    @javafx.fxml.FXML
    private TextField batchNoTextField;
    @javafx.fxml.FXML
    private Label confirmationLabel;

    public static ArrayList<HealthServicesModel> HealthcareServicesList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        HealthcareServicesList.clear();
        HealthcareServicesList.addAll(HealthcareServicesController.HealthcareServicesList);

        HealthcareServicesList.add(new HealthServicesModel("R01", null, "fever", "Sun 2pm", null, null, null, null, null, "Pending"));
        HealthcareServicesList.add(new HealthServicesModel("R05", null, "sore throat", "Wed 5pm", null, null, null, null, null, "Pending"));
for (HealthServicesModel healthservice : HealthcareServicesList){
    selectPatientComboBox.setValue(healthservice.getRefugeeID());
}

    }

    @javafx.fxml.FXML
    public void updateVaccinOnAction(ActionEvent actionEvent) {
        String selectedPatient = selectPatientComboBox.getValue();
        String vaccineName = vaccinnameTextField.getText();
        String dose = doseTextField.getText();
        LocalDate date = datepicker.getValue();
        String batchNo = batchNoTextField.getText();

        if (selectedPatient == null || vaccineName.isEmpty() || dose.isEmpty() || date == null || batchNo.isEmpty()) {
            confirmationLabel.setText("Error: Please fill in all fields.");
            return;
        }
        if (date.isAfter(LocalDate.now())) {
            confirmationLabel.setText("Error: Date cannot be in the future.");
            return;
        }
       VaccineRecordModel vaccineRecord = new VaccineRecordModel(selectedPatient, vaccineName, dose, date, batchNo);

        confirmationLabel.setText("Vaccine record updated successfully for " + selectedPatient + "!");
        vaccinoutputTextArea.setText("Vaccine Name: " + vaccineName + "\nDose: " + dose + "\nDate: " + date + "\nBatch No: " + batchNo);

    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/DoctorAndEducationCoordinator/HealthPortal.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Health Portal");
        stage.show();
    }
}