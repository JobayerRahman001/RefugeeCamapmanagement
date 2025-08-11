package cse213.refugeecampfinalproject.Refugee;

import cse213.refugeecampfinalproject.LoggedInRefModel;
import javafx.beans.Observable;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class HealthcareServicesController {
    @javafx.fxml.FXML
    private TextField refugeeSymptomsTextField;
    @javafx.fxml.FXML
    private ComboBox<String> refAppointmentTimeComboBox;
    @javafx.fxml.FXML
    private TextField refugeeConcernsTextField;
    @javafx.fxml.FXML
    private Label healthcareMsgLabel;
    @javafx.fxml.FXML
    private ComboBox<String> refCounsellingTimeComboBox;
    @javafx.fxml.FXML
    private TextField refidTextField;
    @javafx.fxml.FXML
    private TextArea testNameTextArea;
    @javafx.fxml.FXML
    private TextArea testResultTextArea;
    @javafx.fxml.FXML
    private TextArea prescriptionTextArea;

    @javafx.fxml.FXML
    public void initialize() {
        refAppointmentTimeComboBox.getItems().addAll("Sun 2pm", "Mon 5pm", "Tue 4pm", "Wed 2pm", "Thu 11am");
        refCounsellingTimeComboBox.getItems().addAll("Sun 12pm", "Mon 3pm", "Tue 4pm", "Wed 10am", "Thu 1pm");
    }
public static ObservableList<HealthServicesModel> HealthcareServicesList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/homepage.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Home");
        stage.show();
    }

    @javafx.fxml.FXML
    public void scheduleCounsellingOnClick(ActionEvent actionEvent) {
        if (refidTextField.getText().isEmpty() || refugeeConcernsTextField.getText().isEmpty() || refCounsellingTimeComboBox.getValue() == null) {
            healthcareMsgLabel.setText("Please fill in all details for the medical appointment.");
            return;
        }

        String refugeeid = refidTextField.getText().trim();
        if(!refugeeid.equals(LoggedInRefModel.getLoggedInRefugeeId())){
            healthcareMsgLabel.setText("Please enter your own refugee ID!");
            return;
        }
        String symptoms = null;
        String appointmentTime = null;
        String concerns = refugeeConcernsTextField.getText().trim();
        String counsellingTime = refCounsellingTimeComboBox.getValue();
        String testName = null;
        String result = null;
        String prescription = null;
        String status = "Pending";

        for(HealthServicesModel hsm: HealthcareServicesList) {
            if (hsm.getRefugeeID().equals(refugeeid) && hsm.getHealthcareServiceType().equals("Counselling")) {
                healthcareMsgLabel.setText("You have already booked a session.");
                return;
            }
        }
        HealthServicesModel appointment = new HealthServicesModel(refugeeid, "Counselling", symptoms, appointmentTime, concerns, counsellingTime,testName, result, prescription, status);

        HealthcareServicesList.add(appointment);
        healthcareMsgLabel.setText("Counselling Session Booked");
    }

    @javafx.fxml.FXML
    public void makeAppointmentOnClick(ActionEvent actionEvent) {
        if (refidTextField.getText().isEmpty() || refugeeSymptomsTextField.getText().isEmpty() || refAppointmentTimeComboBox.getValue() == null) {
            healthcareMsgLabel.setText("Please fill in all details for the medical appointment.");
            return;
        }

        String refugeeid = refidTextField.getText().trim();
        if(!refugeeid.equals(LoggedInRefModel.getLoggedInRefugeeId())){
            healthcareMsgLabel.setText("Please enter your own refugee ID!");
            return;
        }
        String symptoms = refugeeSymptomsTextField.getText().trim();
        String appointmentTime = refAppointmentTimeComboBox.getValue();
        String concerns = null;
        String counsellingTime = null;
        String testName = null;
        String result = null;
        String prescription = null;
        String status = "Pending";

        for(HealthServicesModel hsm: HealthcareServicesList) {
            if(hsm.getRefugeeID().equals(refugeeid) && hsm.getHealthcareServiceType().equals("Appointment")) {
                healthcareMsgLabel.setText("You have already booked an appointment.");
                return;
            }
        }
        HealthServicesModel appointment = new HealthServicesModel(refugeeid, "Appointment", symptoms, appointmentTime, concerns, counsellingTime,testName, result, prescription, status);

        HealthcareServicesList.add(appointment);
        healthcareMsgLabel.setText("Medical Appointment booked.");
    }

    @javafx.fxml.FXML
    public void backtoDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Refugee/RefugeeDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Refugee Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void loadTestsPrescriptionsOnClick(ActionEvent actionEvent) {
        String enteredID = refidTextField.getText().trim();
        if(!enteredID.equals(LoggedInRefModel.getLoggedInRefugeeId())){
            healthcareMsgLabel.setText("Please enter your own refugee ID!");
            return;
        }

        if (enteredID.isEmpty()) {
            healthcareMsgLabel.setText("Please enter ID");
            return;
        }
        testNameTextArea.setText("COVID Test");
        testResultTextArea.setText("Negative");
        prescriptionTextArea.setText("Vitamin D capsules: 30 days course");
    }
}
