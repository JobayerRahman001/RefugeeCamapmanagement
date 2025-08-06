package cse213.refugeecampfinalproject.Admin;

import cse213.refugeecampfinalproject.Volunteer.VolunteerModel;
import cse213.refugeecampfinalproject.Volunteer.VolunteerWorkLogsController;
import cse213.refugeecampfinalproject.Volunteer.VolunteerWorkLogsModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class VolunteerPerformanceManagementAdminController
{
    @javafx.fxml.FXML
    private TableView<VolunteerWorkLogsModel> volunteerWorkTableView;
    @javafx.fxml.FXML
    private TableColumn<VolunteerWorkLogsModel, String> tasksTableCol;
    @javafx.fxml.FXML
    private TableColumn<VolunteerModel, String> skillsTableCol;
    @javafx.fxml.FXML
    private TableColumn<VolunteerWorkLogsModel, String> serviceAreaTableCol;
    @javafx.fxml.FXML
    private TableView<VolunteerModel> volunteerIdentifyTableView;
    @javafx.fxml.FXML
    private TableColumn<VolunteerModel, String> volNameTableCol;
    @javafx.fxml.FXML
    private TableColumn<VolunteerModel, String> volIDTableCol;

public static ArrayList<VolunteerModel>VolunteerList = new ArrayList<>();
public static ArrayList<VolunteerWorkLogsModel>VolunteerWorkLogsList = VolunteerWorkLogsController.VolunteerWorkLogsList;

    @javafx.fxml.FXML
    public void initialize() {
        volIDTableCol.setCellValueFactory(new PropertyValueFactory<>("volID"));
        volNameTableCol.setCellValueFactory(new PropertyValueFactory<>("volName"));
        serviceAreaTableCol.setCellValueFactory(new PropertyValueFactory<>("volServiceArea"));
        skillsTableCol.setCellValueFactory(new PropertyValueFactory<>("volSkills"));
        tasksTableCol.setCellValueFactory(new PropertyValueFactory<>("task"));

        volunteerIdentifyTableView.getItems().clear();
        if(VolunteerList.isEmpty()) {
            //dummy data
            volunteerIdentifyTableView.getItems().addAll(new VolunteerModel("V01", "Mahmud", null, null, true));
            volunteerIdentifyTableView.getItems().addAll(new VolunteerModel("V02", "Mita", null, null, true));
            volunteerIdentifyTableView.getItems().addAll(new VolunteerModel("V03", "Rahim", null, null, true));
        }
        volunteerIdentifyTableView.getItems().addAll(VolunteerList);

        volunteerWorkTableView.getItems().clear();

    }

    @javafx.fxml.FXML
    public void backtoDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Admin/AdminDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Admin Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void warnOnClick(ActionEvent actionEvent) {
        VolunteerModel selected = volunteerIdentifyTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Issued");
            alert.setHeaderText(null);
            alert.setContentText("Volunteer " + selected.getVolName() + " has been issued a warning.");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void showPerformanceOnClick(ActionEvent actionEvent) {
        VolunteerModel selected = volunteerIdentifyTableView.getSelectionModel().getSelectedItem();
        if(selected == null) return;

        volunteerWorkTableView.getItems().clear();

        //dummy data
        if(selected.getVolID().equals("V01")) {
            volunteerWorkTableView.getItems().add(new VolunteerWorkLogsModel("Education", "Completed 3 sessions", "Teaching"));
        }else if(selected.getVolID().equals("V02")) {
            volunteerWorkTableView.getItems().add(new VolunteerWorkLogsModel("Healthcare", "Completed health checkups", "First-aid, CPR"));
        }else if(selected.getVolID().equals("V03")) {
            volunteerWorkTableView.getItems().add(new VolunteerWorkLogsModel("Food", "Completed serving 5 meals", "Cooking"));
        }else {
            volunteerWorkTableView.getItems().add(new VolunteerWorkLogsModel(selected.getVolServiceArea(), "0 Tasks Completed", selected.getVolSkills()));
        }
        volunteerWorkTableView.getItems().addAll(VolunteerWorkLogsList);
    }

    @javafx.fxml.FXML
    public void removeOnClick(ActionEvent actionEvent) {
        VolunteerModel selected = volunteerIdentifyTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            volunteerIdentifyTableView.getItems().remove(selected);
            VolunteerList.remove(selected);
            volunteerWorkTableView.getItems().clear();
        }
    }
}