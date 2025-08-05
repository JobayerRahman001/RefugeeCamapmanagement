package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

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

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void updateVaccinOnAction(ActionEvent actionEvent) {
        String selectedPatient = selectPatientComboBox.getValue();
        String vaccineName = vaccinnameTextField.getText();
        String dose = doseTextField.getText();
        LocalDate date = datepicker.getValue();
        String batchNo = batchNoTextField.getText();
        // Validate fields
        if (selectedPatient == null || vaccineName.isEmpty() || dose.isEmpty() || date == null || batchNo.isEmpty()) {
            confirmationLabel.setText("Error: Please fill in all fields.");
            return;
        }
        // Validate date format (this is handled by the DatePicker, but you can add additional checks if needed)
        if (date.isAfter(LocalDate.now())) {
            confirmationLabel.setText("Error: Date cannot be in the future.");
            return;
        }
        // Create a new VaccineRecord instance (you may need to create this model class)
        VaccineRecordModel vaccineRecord = new VaccineRecordModel(selectedPatient, vaccineName, dose, date, batchNo);
        // Here you would typically save the vaccine record to your database
        // For example: saveVaccineRecordToDatabase(vaccineRecord);
        // Show success message
        confirmationLabel.setText("Vaccine record updated successfully for " + selectedPatient + "!");
        vaccinoutputTextArea.setText("Vaccine Name: " + vaccineName + "\nDose: " + dose + "\nDate: " + date + "\nBatch No: " + batchNo);

    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/HealthPortal.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Health Portal");
        stage.show();
    }
}