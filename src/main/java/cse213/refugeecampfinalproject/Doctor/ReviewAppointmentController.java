package cse213.refugeecampfinalproject.Doctor;

import cse213.refugeecampfinalproject.Refugee.HealthServicesModel;
import cse213.refugeecampfinalproject.Refugee.HealthcareServicesController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ReviewAppointmentController
{

    @javafx.fxml.FXML
    private TableColumn<HealthServicesModel, String> symptomsTableCol;
    @javafx.fxml.FXML
    private TableView<HealthServicesModel> patientTableView;
    @javafx.fxml.FXML
    private TableColumn<HealthServicesModel, String> appointmentTimeTableCol;
    @javafx.fxml.FXML
    private TableColumn<HealthServicesModel, String> refugeeIDTableCol;
    @javafx.fxml.FXML
    private TableColumn<HealthServicesModel, String> statusTableCol;

    ArrayList<HealthServicesModel> patientsList = new ArrayList<>();
public static ArrayList<HealthServicesModel> HealthcareServicesList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        HealthcareServicesList.clear();
        HealthcareServicesList.addAll(HealthcareServicesController.HealthcareServicesList);
        //dummy data
        HealthcareServicesList.add(new HealthServicesModel("R01", null, "fever", "Sun 2pm", null, null, null, null, null, "Pending"));
        HealthcareServicesList.add(new HealthServicesModel("R05", null, "sore throat", "Wed 5pm", null, null, null, null, null, "Pending"));

        refugeeIDTableCol.setCellValueFactory(new PropertyValueFactory<>("refugeeID"));
        appointmentTimeTableCol.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        symptomsTableCol.setCellValueFactory(new PropertyValueFactory<>("symptoms"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        patientTableView.getItems().clear();
        patientTableView.getItems().addAll(HealthcareServicesList);
    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/HealthPortal.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Health Portal");
        stage.show();
    }

    @javafx.fxml.FXML
    public void markSeenOnClick(ActionEvent actionEvent) {
        HealthServicesModel selected = patientTableView.getSelectionModel().getSelectedItem();
        if (selected != null && !selected.getStatus().equalsIgnoreCase("Seen")) {
            selected.setStatus("Seen");
            patientTableView.refresh();
        }
    }

    @javafx.fxml.FXML
    public void markCancelledOnClick(ActionEvent actionEvent) {
        HealthServicesModel selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
        if(selectedPatient != null&& !selectedPatient.getStatus().equalsIgnoreCase("Cancelled")) {
            selectedPatient.setStatus("Cancelled");
            patientTableView.refresh();
        }
    }

    @javafx.fxml.FXML
    public void createPrescriptionOnClick(ActionEvent actionEvent) throws IOException {
        HealthServicesModel selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
        selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
        if (selectedPatient == null) return;

        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Prescription.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Create Prescription");
        stage.show();
    }

    @javafx.fxml.FXML
    public void scheduleFollowUpOnClick(ActionEvent actionEvent) {
        HealthServicesModel selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
        if(selectedPatient != null&& !selectedPatient.getStatus().equalsIgnoreCase("Follow-up")) {
            selectedPatient.setStatus("Follow-up");
            patientTableView.refresh();
        }
    }

    @javafx.fxml.FXML
    public void referHospitalOnClcik(ActionEvent actionEvent) {
        HealthServicesModel selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
        if(selectedPatient != null&& !selectedPatient.getStatus().equalsIgnoreCase("Referred to a Hospital")) {
            selectedPatient.setStatus("Referred to a Hospital");
            patientTableView.refresh();
        }
    }

    @javafx.fxml.FXML
    public void addNotesOnClick(ActionEvent actionEvent) throws IOException {
        HealthServicesModel selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
        selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
        if (selectedPatient == null) return;

        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/MedicalNotes.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Medical Notes");
        stage.show();
    }
}