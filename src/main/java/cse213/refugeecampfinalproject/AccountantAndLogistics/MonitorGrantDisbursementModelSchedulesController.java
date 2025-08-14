package cse213.refugeecampfinalproject.AccountantAndLogistics;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class MonitorGrantDisbursementModelSchedulesController{
    @javafx.fxml.FXML
    private TableColumn<GrantDisbursementModel,String> statusColum;
    @javafx.fxml.FXML
    private TextField grantremarksTextField;
    @javafx.fxml.FXML
    private Label grantupdatestatuslabel;
    @javafx.fxml.FXML
    private TableView<GrantDisbursementModel> monitorgrantdisbursementTabelView;
    @javafx.fxml.FXML
    private TableColumn<GrantDisbursementModel,LocalDate> milestonedateColum;
    @javafx.fxml.FXML
    private TableColumn<GrantDisbursementModel,String> grantnameColum;
    @javafx.fxml.FXML
    private TableColumn<GrantDisbursementModel,String> remarksColum;
    @javafx.fxml.FXML
    private ComboBox<String> grantstatusComboBox;

    private ObservableList<GrantDisbursementModel> grantList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {   grantnameColum.setCellValueFactory(new PropertyValueFactory<>("grantName"));
        milestonedateColum.setCellValueFactory(new PropertyValueFactory<>("milestoneDate"));
        statusColum.setCellValueFactory(new PropertyValueFactory<>("status"));
        remarksColum.setCellValueFactory(new PropertyValueFactory<>("remarks"));

        // Sample data
        grantList.add(new GrantDisbursementModel("Health Support Fund", LocalDate.of(2025, 8, 20), "Pending", ""));
        grantList.add(new GrantDisbursementModel("Education Grant", LocalDate.of(2025, 9, 5), "Disbursed", "On time"));

        monitorgrantdisbursementTabelView.setItems(grantList);

        // Status dropdown
        grantstatusComboBox.setItems(FXCollections.observableArrayList("Pending", "Disbursed", "Delayed"));

    }

    @javafx.fxml.FXML
    public void updategrantstatusOnAction(ActionEvent actionEvent) {
        GrantDisbursementModel selectedGrant = monitorgrantdisbursementTabelView.getSelectionModel().getSelectedItem();
        if (selectedGrant != null) {
            String newStatus = grantstatusComboBox.getValue().toString();
            String remarks = grantremarksTextField.getText();

            if (newStatus != null && !newStatus.isEmpty()) {
                selectedGrant.setStatus(newStatus);
                selectedGrant.setRemarks(remarks);
                monitorgrantdisbursementTabelView.refresh();
                grantupdatestatuslabel.setText("Grant status updated successfully!");
            } else {
                grantupdatestatuslabel.setText("Please select a status.");
            }
        } else {
            grantupdatestatuslabel.setText("Please select a grant from the table.");
        }
    }

    @javafx.fxml.FXML
    public void opengrantscheduleOnAction(ActionEvent actionEvent) {
        grantupdatestatuslabel.setText("Opening grant schedule... (feature not implemented yet)");

    }

    @javafx.fxml.FXML
    public void gobacktoaccountlogisticdashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/FinanceDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Accountant Logistics Coordinator Controller");
        stage.show();
    }
}