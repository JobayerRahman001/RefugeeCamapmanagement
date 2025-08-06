package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import cse213.refugeecampfinalproject.RefugeeandAdmin.HealthcareServicesController;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;


public class ReviewOngoingTreatmentController
{
    @javafx.fxml.FXML
    private TableColumn nameColum;
    @javafx.fxml.FXML
    private TableColumn issueColum;
    @javafx.fxml.FXML
    private TextArea treatmentdetailsTextArea;
    @javafx.fxml.FXML
    private TableColumn currentmedicationColum;
    @javafx.fxml.FXML
    private TableView ongointTableview;

    @javafx.fxml.FXML
    public void initialize() {
        HealthcareServicesList.clear();
        HealthcareServicesList.addAll(HealthcareServicesController.HealthcareServicesList);


        patientTableView.getItems().clear();
        patientTableView.getItems().addAll(HealthcareServicesList);
    }

    @javafx.fxml.FXML
    public void gobacktoHealthPortalOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewselectedpatientOnAction(ActionEvent actionEvent) {
    }
}