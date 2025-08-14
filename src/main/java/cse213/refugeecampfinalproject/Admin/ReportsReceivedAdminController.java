package cse213.refugeecampfinalproject.Admin;

import cse213.refugeecampfinalproject.Refugee.ReportIssuesController;
import cse213.refugeecampfinalproject.Refugee.ResourcesInventoryController;
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

import static cse213.refugeecampfinalproject.Refugee.ReportIssuesController.IssueReportsList;

public class ReportsReceivedAdminController {
    @javafx.fxml.FXML
    private TableColumn<IssueReportsModel, String> detailsTableCol;
    @javafx.fxml.FXML
    private TableColumn<IssueReportsModel, String> urgencyLVLTableCol;
    @javafx.fxml.FXML
    private TableColumn<IssueReportsModel, String> categoryTableCol;
    @javafx.fxml.FXML
    private TableColumn<IssueReportsModel, String> locationTableCol;
    @javafx.fxml.FXML
    private TableColumn<IssueReportsModel, String> refugeeIDTableCol;
    @javafx.fxml.FXML
    private TableColumn<IssueReportsModel, String> statusTableCol;
    @javafx.fxml.FXML
    private TableView<IssueReportsModel> reportsReceivedTableView;


    @javafx.fxml.FXML
    public void initialize() {
        //dummy data
        IssueReportsList.add(new IssueReportsModel("R01", "Water", "Unclean", "Medium", "Block C", "Pending"));
        IssueReportsList.add(new IssueReportsModel("R05", "Other", "bullying", "Immediate", "Block A", "Pending"));

        refugeeIDTableCol.setCellValueFactory(new PropertyValueFactory<>("refugeeID"));
        categoryTableCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        detailsTableCol.setCellValueFactory(new PropertyValueFactory<>("details"));
        urgencyLVLTableCol.setCellValueFactory(new PropertyValueFactory<>("urgency"));
        locationTableCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        reportsReceivedTableView.setItems(IssueReportsList);
    }

    @javafx.fxml.FXML
    public void goBackToDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Admin/AdminDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Admin Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void addressReportsOnClick(ActionEvent actionEvent) {
        IssueReportsModel selected = reportsReceivedTableView.getSelectionModel().getSelectedItem();
        if (selected != null && !selected.getStatus().equals("Addressed")) {
            selected.setStatus("Addressed");
            reportsReceivedTableView.refresh();
        }
    }
}