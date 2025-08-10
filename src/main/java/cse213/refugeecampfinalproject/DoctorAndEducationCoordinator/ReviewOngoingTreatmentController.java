package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import cse213.refugeecampfinalproject.Refugee.HealthServicesModel;
import cse213.refugeecampfinalproject.Refugee.HealthcareServicesController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class ReviewOngoingTreatmentController
{
    @javafx.fxml.FXML
    private TextArea treatmentdetailsTextArea;
    @javafx.fxml.FXML
    private TableView<HealthServicesModel> ongointTableview;
    @javafx.fxml.FXML
    private TableColumn<HealthServicesModel,String> idColum;
    @javafx.fxml.FXML
    private TableColumn<HealthServicesModel,String> statusColum;
    @javafx.fxml.FXML
    private TableColumn<HealthServicesModel,String> symptomColum;


    public static ArrayList<HealthServicesModel> HealthcareServicesList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        idColum.setCellValueFactory(new PropertyValueFactory<>("refugeeID"));
        statusColum.setCellValueFactory(new PropertyValueFactory<>("status"));
        symptomColum.setCellValueFactory(new PropertyValueFactory<>("symptoms"));

        loadPatient();


    }
    public void loadPatient(){
        HealthcareServicesList.clear();
        HealthcareServicesList.addAll(HealthcareServicesController.HealthcareServicesList);

        HealthcareServicesList.add(new HealthServicesModel("R01", null, "fever", "Sun 2pm", null, null, null, null, null, "Pending"));
        HealthcareServicesList.add(new HealthServicesModel("R05", null, "sore throat", "Wed 5pm", null, null, null, null, null, "Pending"));

        ongointTableview.getItems().clear();
        ongointTableview.getItems().addAll(HealthcareServicesList);

    }

    @javafx.fxml.FXML
    public void gobacktoHealthPortalOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Doctor/HealthPortal.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Health Portal");
        stage.show();
    }

    @javafx.fxml.FXML
    public void viewselectedpatientOnAction(ActionEvent actionEvent) {
        HealthServicesModel selectedPatient = ongointTableview.getSelectionModel().getSelectedItem();
        if (selectedPatient != null){
            String treatmentDetails = fetchTreatmentDetails(selectedPatient);
            treatmentdetailsTextArea.setText(treatmentDetails);

        }else {
            treatmentdetailsTextArea.setText("Please select a patient to view details");
        }
    }
    private String fetchTreatmentDetails(HealthServicesModel patient) {
        return "Patient ID: " + patient.getRefugeeID() + "\n" +
                "Symptom: " + patient.getSymptoms() + "\n" +
                "Status: " + patient.getStatus() + "\n" +
                "Response Notes: [Placeholder for notes]";
    }
}