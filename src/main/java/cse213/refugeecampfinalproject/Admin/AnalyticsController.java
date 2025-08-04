package cse213.refugeecampfinalproject.Admin;

import cse213.refugeecampfinalproject.Refugee.EducationServicesController;
import cse213.refugeecampfinalproject.Refugee.EducationServicesModel;
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

public class AnalyticsController
{
    @javafx.fxml.FXML
    private TableColumn<AnalyticsModel, String> distributionTableColF;
    @javafx.fxml.FXML
    private TableColumn<AnalyticsModel, String> programTableCol;
    @javafx.fxml.FXML
    private TableColumn<AnalyticsModel, String> classTimeTableCol;
    @javafx.fxml.FXML
    private TableColumn<AnalyticsModel, String> itemNameTableColF;
    @javafx.fxml.FXML
    private TableView<AnalyticsModel> healthcareTableView;
    @javafx.fxml.FXML
    private TableColumn<AnalyticsModel, String> remainingTableColF;
    @javafx.fxml.FXML
    private TableColumn<AnalyticsModel, String> refugeeIDTableColE;
    @javafx.fxml.FXML
    private TableColumn<AnalyticsModel, String> refugeeIDTableColH;
    @javafx.fxml.FXML
    private TableView<AnalyticsModel> FoodTableView;
    @javafx.fxml.FXML
    private TableColumn<AnalyticsModel, String> distributedTableColR;
    @javafx.fxml.FXML
    private TableColumn<AnalyticsModel, String> statusTableColE;
    @javafx.fxml.FXML
    private TableColumn<AnalyticsModel, String> remainingTableColR;
    @javafx.fxml.FXML
    private TableView<AnalyticsModel> educationTableView;
    @javafx.fxml.FXML
    private TableView<AnalyticsModel> resourcesTableView;
    @javafx.fxml.FXML
    private TableColumn<AnalyticsModel, String> typeTableCol;
    @javafx.fxml.FXML
    private TableColumn<AnalyticsModel, String> statusTableColH;
    @javafx.fxml.FXML
    private TableColumn<AnalyticsModel, String> itemNameTableColR;

public static ArrayList<HealthServicesModel> appointments = HealthcareServicesController.HealthcareServicesList;
public static ArrayList<EducationServicesModel> education = EducationServicesController.EducacationServicesList;
public static ArrayList<AnalyticsModel> resources = new ArrayList<>();
public static ArrayList<AnalyticsModel> food = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        healthcareTableView.getItems().addAll(new AnalyticsModel("R01", "Medical", "Completed", null, null, null, null, null));
        healthcareTableView.getItems().addAll(new AnalyticsModel("R08", "Medical", "Completed", null, null, null, null, null));
        healthcareTableView.getItems().addAll(new AnalyticsModel("R12", "Counselling", "Continuing", null, null, null, null, null));

        educationTableView.getItems().addAll(new AnalyticsModel("R04", null, "Enrolled", "Literacy", "Tue-Thu 9:00 AM", null, null, null));
        educationTableView.getItems().addAll(new AnalyticsModel("R10", null, "Enrolled", "Vocational Training", "Sun-Tue 10:00 AM", null, null, null));
        educationTableView.getItems().addAll(new AnalyticsModel("R14", null, "Enrolled", "Vocational Training", "Sun-Tue 10:00 AM", null, null, null));
        educationTableView.getItems().addAll(new AnalyticsModel("R15", null, "Enrolled", "Basic Schooling", "Daily 8:00 AM", null, null, null));

        FoodTableView.getItems().addAll(new AnalyticsModel(null, null, null, null, null, "Rice", "100kg", "20kg"));
        FoodTableView.getItems().addAll(new AnalyticsModel(null, null, null, null, null, "Lentil", "70kg", "5kg"));
        FoodTableView.getItems().addAll(new AnalyticsModel(null, null, null, null, null, "Eggs", "15 dozens", "2 dozens"));
        FoodTableView.getItems().addAll(new AnalyticsModel(null, null, null, null, null, "Fish", "80kg", "20kg"));
        FoodTableView.getItems().addAll(new AnalyticsModel(null, null, null, null, null, "Water", "1000 litres", "150 litres"));

        resourcesTableView.getItems().addAll(new AnalyticsModel(null, null, null, null, null, "Clothes", "20", "4"));
        resourcesTableView.getItems().addAll(new AnalyticsModel(null, null, null, null, null, "Blankets", "30", "2"));
        resourcesTableView.getItems().addAll(new AnalyticsModel(null, null, null, null, null, "Soap", "25", "5"));

        refugeeIDTableColH.setCellValueFactory(new PropertyValueFactory<>("refugeeID"));
        typeTableCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        statusTableColH.setCellValueFactory(new PropertyValueFactory<>("status"));
        for (HealthServicesModel hsm : appointments) {
            healthcareTableView.getItems().add(new AnalyticsModel(hsm.getRefugeeID(), hsm.getHealthcareServiceType(), hsm.getStatus(), null, null, null, null, null));
        }

        refugeeIDTableColE.setCellValueFactory(new PropertyValueFactory<>("refugeeID"));
        programTableCol.setCellValueFactory(new PropertyValueFactory<>("program"));
        classTimeTableCol.setCellValueFactory(new PropertyValueFactory<>("classTimes"));
        statusTableColE.setCellValueFactory(new PropertyValueFactory<>("status"));
        for (EducationServicesModel esm : education) {
            educationTableView.getItems().add(new AnalyticsModel(esm.getRefugeeID(), null, "Enrolled", esm.getProgramName(), null, null, null, null));
        }

        itemNameTableColF.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        distributionTableColF.setCellValueFactory(new PropertyValueFactory<>("distributed"));
        remainingTableColF.setCellValueFactory(new PropertyValueFactory<>("remaining"));
        FoodTableView.getItems().addAll(food);

        itemNameTableColR.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        distributedTableColR.setCellValueFactory(new PropertyValueFactory<>("distributed"));
        remainingTableColR.setCellValueFactory(new PropertyValueFactory<>("remaining"));
        resourcesTableView.getItems().addAll(resources);
    }

    @javafx.fxml.FXML
    public void goBackToDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/AdminDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Admin Dashboard");
        stage.show();
    }
}