package cse213.refugeecampfinalproject;

import cse213.refugeecampfinalproject.AccountantAndLogistics.SalaryDisbursementModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class SalaryDisbursementController
{
    @javafx.fxml.FXML
    private TableView<SalaryDisbursementModel> salarydisbursementTableView;
    @javafx.fxml.FXML
    private TableColumn<SalaryDisbursementModel,Double> netsalaryColum;
    @javafx.fxml.FXML
    private TableColumn<SalaryDisbursementModel,String> nameColum;
    @javafx.fxml.FXML
    private TableColumn<SalaryDisbursementModel,Integer> attendenceColum;
    @javafx.fxml.FXML
    private TableColumn<SalaryDisbursementModel,String> roleColum;
    @javafx.fxml.FXML
    private TableColumn<SalaryDisbursementModel,Double> salaryColum;
    @javafx.fxml.FXML
    private TableColumn<SalaryDisbursementModel,Double> deductionsColum;
    @javafx.fxml.FXML
    private Label statusLabel;

    public static ObservableList<SalaryDisbursementModel> staffList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {
        salaryColum.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
        roleColum.setCellValueFactory(new PropertyValueFactory<>("role"));
        nameColum.setCellValueFactory(new PropertyValueFactory<>("name"));
        deductionsColum.setCellValueFactory(new PropertyValueFactory<>("deducations"));
        attendenceColum.setCellValueFactory(new PropertyValueFactory<>("attendanceDays"));
        netsalaryColum.setCellValueFactory(new PropertyValueFactory<>("netSalary"));
        salarydisbursementTableView.setItems(staffList);
    }

    @javafx.fxml.FXML
    public void sendconfirmationOnAction(ActionEvent actionEvent) {
        if (staffList.isEmpty()) {
            statusLabel.setText("No payments to confirm.");
            return;
        }
        statusLabel.setText("Salary confirmation sent to staff accounts ✅");

    }

    @javafx.fxml.FXML
    public void gobacktoaccountlogistictdashboardOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitpaymentbatchOnAction(ActionEvent actionEvent) {
        if (staffList.isEmpty()) {
            statusLabel.setText("No salary sheet to submit.");
            return;
        }
        statusLabel.setText("Payment batch submitted ✅");

    }

    @javafx.fxml.FXML
    public void generalsalarysheetOnAction(ActionEvent actionEvent) {
        staffList.clear();
        staffList.addAll(
                new SalaryDisbursementModel("Alice", "Teacher", 50000, 26, 2000,20000),
                new SalaryDisbursementModel("Bob", "Driver", 30000, 25, 1000,10000),
                new SalaryDisbursementModel("Charlie", "Nurse", 40000, 27, 1500,12000)
        );
        statusLabel.setText("Salary sheet generated ✅");
    }
}