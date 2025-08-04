package cse213.refugeecampfinalproject.Educator;

import cse213.refugeecampfinalproject.ApplicationDataModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AproveEducationApplicationController
{
    @javafx.fxml.FXML
    private TableColumn<ApplicationDataModel,String> statusColum;
    @javafx.fxml.FXML
    private TableView<ApplicationDataModel> educationalapplicationTableView;
    @javafx.fxml.FXML
    private TableColumn<ApplicationDataModel,String> requestedtimeColum;
    @javafx.fxml.FXML
    private TableColumn<ApplicationDataModel,String> selecedprogramColum;
    @javafx.fxml.FXML
    private TableColumn<ApplicationDataModel,Integer> refugeeageColum;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TableColumn<ApplicationDataModel,String> refugeenameColum;

    public static ArrayList<ApplicationDataModel> pendingApplications = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        // Set up table columns
        refugeenameColum.setCellValueFactory(new PropertyValueFactory<>("refugee.refName")); // Access refugee name
       refugeeageColum.setCellValueFactory(new PropertyValueFactory<>("refugee.refAge")); // Access refugee age
        selecedprogramColum.setCellValueFactory(new PropertyValueFactory<>("selectedProgram"));
        requestedtimeColum.setCellValueFactory(new PropertyValueFactory<>("requestedTime"));
        statusColum.setCellValueFactory(new PropertyValueFactory<>("status"));
        // Load pending applications
        loadPendingApplications();
    }
    private void loadPendingApplications() {
        // Simulated data fetching (in a real application, this would come from a database)
        Refugee refugee1 = new Refugee("1", "John Doe", "pass123", 25, "Male", "3", "Country A");
        Refugee refugee2 = new Refugee("2", "Jane Smith", "pass456", 22, "Female", "2", "Country B");
        Refugee refugee3 = new Refugee("3", "Alice Johnson", "pass789", 30, "Female", "4", "Country C");
        pendingApplications.add(new ApplicationDataModel(refugee1, "Literacy Program", "Monday 10 AM", "Pending"));
        pendingApplications.add(new ApplicationDataModel(refugee2, "Language Program", "Tuesday 2 PM", "Pending"));
        pendingApplications.add(new ApplicationDataModel(refugee3, "Vocational Training", "Wednesday 1 PM", "Pending"));
        // Populate the table with pending applications
        educationalapplicationTableView.getItems().clear();
        educationalapplicationTableView.getItems().addAll(pendingApplications);
    }

    @javafx.fxml.FXML
    public void gobacktoeducationOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/EducationPanel.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();
    }

    @javafx.fxml.FXML
    public void rejectOnAction(ActionEvent actionEvent) {
        ApplicationDataModel selectedApplication = educationalapplicationTableView.getSelectionModel().getSelectedItem();
        if (selectedApplication != null) {
            // Update the application status to "Rejected"
            selectedApplication.setStatus("Rejected");
            confirmationLabel.setText("Application for " + selectedApplication.getRefugee().getRefName() + " has been rejected.");
            // Notify the refugee (simulated here)
            notifyRefugee(selectedApplication, "rejected");
        } else {
            confirmationLabel.setText("Error: Please select an application to reject.");
        }
    }

    @javafx.fxml.FXML
    public void refreshOnAction(ActionEvent actionEvent) {
        // Reload pending applications if needed
        loadPendingApplications();
    }

    @javafx.fxml.FXML
    public void approveOnAction(ActionEvent actionEvent) {
        ApplicationDataModel selectedApplication = educationalapplicationTableView.getSelectionModel().getSelectedItem();
        if (selectedApplication != null) {
            // Check for age group match and schedule conflicts
            if (isAgeGroupMatch(selectedApplication) && isScheduleAvailable(selectedApplication)) {
                // Update the application status to "Approved"
                selectedApplication.setStatus("Approved");
                confirmationLabel.setText("Application for " + selectedApplication.getRefugee().getRefName() + " has been approved.");
                // Notify the refugee (simulated here)
                notifyRefugee(selectedApplication, "approved");
            } else {
                confirmationLabel.setText("Error: Age group mismatch or schedule conflict.");
            }
        } else {
            confirmationLabel.setText("Error: Please select an application to approve.");
        }
    }
    private boolean isAgeGroupMatch(ApplicationDataModel application) {
        // Placeholder logic for checking age group match
        // In a real application, you would check the program's age requirements
        return true; // Assume age group matches for demonstration
    }
    private boolean isScheduleAvailable(ApplicationDataModel application) {
        // Placeholder logic for checking schedule availability
        // In a real application, you would check the database for existing schedules
        return true; // Assume schedule is available for demonstration
    }
    private void notifyRefugee(ApplicationDataModel application, String decision) {
        // Placeholder logic for notifying the refugee
        // In a real application, you would send notifications through your system
        System.out.println("Notified " + application.getRefugee().getRefName() + " about their application being " + decision + ".");
    }
}