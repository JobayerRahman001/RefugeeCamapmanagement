package cse213.refugeecampfinalproject.RefugeeandAdmin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class RefugeeDashboardController
{
    @javafx.fxml.FXML
    private TableColumn<RefugeeDashboardTableViewEntriesModel, String> refTableTypeCol;
    @javafx.fxml.FXML
    private TableView<RefugeeDashboardTableViewEntriesModel> dashboardRefTableView;
    @javafx.fxml.FXML
    private TableColumn<RefugeeDashboardTableViewEntriesModel, String> refTableDetailsCol;
    @javafx.fxml.FXML
    private TableColumn<RefugeeDashboardTableViewEntriesModel, String> refTableDateCol;

    ObservableList<RefugeeDashboardTableViewEntriesModel> dashboardentries = FXCollections.observableArrayList();

    ArrayList<HealthServicesModel> appointments = HealthcareServicesController.HealthcareServicesList;
    ArrayList<EducationServicesModel> education = EducationServicesController.EducacationServicesList;
    ArrayList<ResourceRequestsModel> resources = ResourcesInventoryController.ResourceRequestsList;
    ArrayList<IssueReportsModel> reports = ReportIssuesController.IssueReportsList;

    @javafx.fxml.FXML
    public void initialize() {
        for (HealthServicesModel hsm : HealthcareServicesController.HealthcareServicesList) {
            String date = hsm.getAppointmentTime() != null ? hsm.getAppointmentTime() : hsm.getCounsellingTime();
            String details = hsm.getSymptoms() != null ? hsm.getSymptoms() : hsm.getConcerns();
            dashboardentries.add(new RefugeeDashboardTableViewEntriesModel(
                    hsm.getHealthcareServiceType(), date, details
            ));
        }
        for (EducationServicesModel esm : education) {
            dashboardentries.add(new RefugeeDashboardTableViewEntriesModel(esm.getProgramName(), esm.getTiming(), esm.getAge()));
        }
        for (ResourceRequestsModel rsm: resources) {
            dashboardentries.add(new RefugeeDashboardTableViewEntriesModel(rsm.getRequestType(), LocalDate.now().toString(), String.valueOf(rsm.getQuantity())));
        }
        for (IssueReportsModel rim : reports) {
            dashboardentries.add(new RefugeeDashboardTableViewEntriesModel(rim.getCategory(),LocalDate.now().toString(), rim.getLocation()));
        }

        refTableTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        refTableDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        refTableDetailsCol.setCellValueFactory(new PropertyValueFactory<>("details"));

        dashboardRefTableView.getItems().clear();
        dashboardRefTableView.getItems().addAll(dashboardentries);
    }

    @javafx.fxml.FXML
    public void assignedResourcesforRefOnClick(ActionEvent actionEvent) throws IOException {
        Parent healthPortal = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/AssignedResources.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(healthPortal));
        stage.setTitle("Assigned Resources");
        stage.show();
    }

    @javafx.fxml.FXML
    public void reportIssuesforRefOnClick(ActionEvent actionEvent) throws IOException {
        Parent healthPortal = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/ReportIssues.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(healthPortal));
        stage.setTitle("Report Issues");
        stage.show();
    }

    @javafx.fxml.FXML
    public void healcareServiceforRefOnClick(ActionEvent actionEvent) throws IOException {
        Parent healthPortal = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/HealthcareServices.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(healthPortal));
        stage.setTitle("Healthcare Services");
        stage.show();
    }

    @javafx.fxml.FXML
    public void inventoryReqforRefOnClick(ActionEvent actionEvent) throws IOException {
        Parent healthPortal = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/ResourcesInventory.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(healthPortal));
        stage.setTitle("Resources Inventory");
        stage.show();
    }

    @javafx.fxml.FXML
    public void eductionServiceforRefOnClick(ActionEvent actionEvent) throws IOException {
        Parent healthPortal = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/EducationServices.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(healthPortal));
        stage.setTitle("Education Services");
        stage.show();
    }

    @javafx.fxml.FXML
    public void addSkillsforRefOnClick(ActionEvent actionEvent) throws IOException {
        Parent healthPortal = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/RefugeeSkillsProfile.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(healthPortal));
        stage.setTitle("Refugee Skills Profile");
        stage.show();
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/homepage.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Home");
        stage.show();
    }
}