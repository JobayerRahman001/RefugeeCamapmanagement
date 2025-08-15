package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.Objects;

public class AproveEducationApplicationController
{
    @javafx.fxml.FXML
    private TableColumn<EducationApplicationModel,String> statusColum;
    @javafx.fxml.FXML
    private TableView<EducationApplicationModel> educationalapplicationTableView;
    @javafx.fxml.FXML
    private TableColumn<EducationApplicationModel,String> requestedtimeColum;
    @javafx.fxml.FXML
    private TableColumn<EducationApplicationModel,String> selecedprogramColum;
    @javafx.fxml.FXML
    private TableColumn<EducationApplicationModel,String> refugeeageColum;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TableColumn<EducationApplicationModel,String> refugeenameColum;

    private ArrayList<EducationApplicationModel> applicationList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        refugeenameColum.setCellValueFactory(new PropertyValueFactory<>("refugeeName"));
        refugeeageColum.setCellValueFactory(new PropertyValueFactory<>("age"));
        selecedprogramColum.setCellValueFactory(new PropertyValueFactory<>("selectedProgram"));
        requestedtimeColum.setCellValueFactory(new PropertyValueFactory<>("requestedTime"));
        statusColum.setCellValueFactory(new PropertyValueFactory<>("status"));
        loadApplications();
    }
    private void loadApplications() {
        applicationList.add(new EducationApplicationModel("John Doe", 25, "Literacy Program", "Monday 10 AM - 12 PM","pending"));
        applicationList.add(new EducationApplicationModel("Jane Smith", 17, "Language Program", "Tuesday 1 PM - 3 PM","pending"));

        ObservableList<EducationApplicationModel> observableList = FXCollections.observableArrayList(applicationList);
        educationalapplicationTableView.setItems(observableList);
    }
    @javafx.fxml.FXML
    public void gobacktoeducationOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject//DoctorAndEducationCoordinator/EducationPanel.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();
    }

    @javafx.fxml.FXML
    public void rejectOnAction(ActionEvent actionEvent) {
        EducationApplicationModel selectedApplication = educationalapplicationTableView.getSelectionModel().getSelectedItem();
        if (selectedApplication != null) {
            selectedApplication.setStatus("Rejected");
            confirmationLabel.setText("Application for " + selectedApplication.getRefugeeName() + " has been rejected.");
            refreshApplications();
        } else {
            confirmationLabel.setText("Please select an application to reject.");
        }
    }

    @javafx.fxml.FXML
    public void refreshOnAction(ActionEvent actionEvent) {
        refreshApplications();
    }

    @javafx.fxml.FXML
    public void approveOnAction(ActionEvent actionEvent) {
        EducationApplicationModel selectedApplication = educationalapplicationTableView.getSelectionModel().getSelectedItem();
        if (selectedApplication != null) {
            if (isAgeGroupMatch(selectedApplication) && !isScheduleConflict(selectedApplication)) {
                selectedApplication.setStatus("Approved");
                confirmationLabel.setText("Application for " + selectedApplication.getRefugeeName() + " has been approved.");
                updateRefugeeProfile(selectedApplication);
            } else {
                confirmationLabel.setText("Application cannot be approved due to age group mismatch or schedule conflict.");
            }
            refreshApplications();
        } else {
            confirmationLabel.setText("Please select an application to approve.");
        }
    }
    private boolean isAgeGroupMatch(EducationApplicationModel application) {
        return application.getAge() >= 15; // Example condition
    }
    private boolean isScheduleConflict(EducationApplicationModel application) {
        return false;
    }
    private void updateRefugeeProfile(EducationApplicationModel application) {
        System.out.println("Updating profile for " + application.getRefugeeName());
    }
    private void refreshApplications() {
        ObservableList<EducationApplicationModel> observableList = FXCollections.observableArrayList(applicationList);
        educationalapplicationTableView.setItems(observableList);
    }
}