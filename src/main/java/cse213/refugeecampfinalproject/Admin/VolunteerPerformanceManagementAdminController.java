package cse213.refugeecampfinalproject.Admin;

import cse213.refugeecampfinalproject.Volunteer.VolunteerDashboardController;
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
    private TableColumn<VolunteerWorkLogsModel, String> skillsTableCol;
    @javafx.fxml.FXML
    private TableColumn<VolunteerWorkLogsModel, String> serviceAreaTableCol;
    @javafx.fxml.FXML
    private TableView<VolunteerModel> volunteerIdentifyTableView;
    @javafx.fxml.FXML
    private TableColumn<VolunteerModel, String> volNameTableCol;
    @javafx.fxml.FXML
    private TableColumn<VolunteerModel, String> volIDTableCol;

    @javafx.fxml.FXML
    public void initialize() {
        volIDTableCol.setCellValueFactory(new PropertyValueFactory<>("volID"));
        volNameTableCol.setCellValueFactory(new PropertyValueFactory<>("volName"));
        serviceAreaTableCol.setCellValueFactory(new PropertyValueFactory<>("volServiceArea"));
        skillsTableCol.setCellValueFactory(new PropertyValueFactory<>("VolSkills"));
        tasksTableCol.setCellValueFactory(new PropertyValueFactory<>("task"));

        if(VolunteerDashboardController.VolunteerList.isEmpty()) {
            VolunteerDashboardController.VolunteerList.addAll(
                    new VolunteerModel("V01", "Mahmud", "Teaching", "Education", true),
                    new VolunteerModel("V02", "Mita", "First-aid, CPR", "Healthcare", true),
                    new VolunteerModel("V03", "Rahim", "Cooking", "Food", true)
            );
        }
        volunteerIdentifyTableView.getItems().clear();
        volunteerIdentifyTableView.getItems().addAll(VolunteerDashboardController.VolunteerList);
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
        if (selected == null)
            return;

        volunteerWorkTableView.getItems().clear();

        for (VolunteerWorkLogsModel log : VolunteerWorkLogsController.VolunteerWorkLogsList) {
            if (log.getVolID().equals(selected.getVolID())) {
                volunteerWorkTableView.getItems().add(log);
            }
        }

        //dummy data
        if (volunteerWorkTableView.getItems().isEmpty()) {
            String dummyTask;
            if (selected.getVolID().equals("V01")) {
                dummyTask = "Completed 3 sessions";
            } else if (selected.getVolID().equals("V02")) {
                dummyTask = "Completed health checkups";
            } else if (selected.getVolID().equals("V03")) {
                dummyTask = "Completed serving 5 meals";
            } else {
                dummyTask = "0 Tasks Completed";
            }

            volunteerWorkTableView.getItems().add(
                    new VolunteerWorkLogsModel(
                            selected.getVolID(),
                            selected.getVolServiceArea(),
                            dummyTask,
                            selected.getVolSkills()
                    )
            );
        }
    }

    @javafx.fxml.FXML
    public void removeOnClick(ActionEvent actionEvent) {
        VolunteerModel selected = volunteerIdentifyTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            volunteerIdentifyTableView.getItems().remove(selected);
            VolunteerDashboardController.VolunteerList.remove(selected);
            volunteerWorkTableView.getItems().clear();
        }
    }
}