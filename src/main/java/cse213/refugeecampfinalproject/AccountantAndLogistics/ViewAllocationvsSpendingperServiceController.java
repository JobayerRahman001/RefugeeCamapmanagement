package cse213.refugeecampfinalproject.AccountantAndLogistics;

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
import java.util.Objects;

public class ViewAllocationvsSpendingperServiceController
{
    @javafx.fxml.FXML
    private TableColumn spentColum;
    @javafx.fxml.FXML
    private Label budgetStatusLabel;
    @javafx.fxml.FXML
    private TableColumn alocatedColum;
    @javafx.fxml.FXML
    private TableView viewallocationTabelView;
    @javafx.fxml.FXML
    private TableColumn servicenameColum;

    @javafx.fxml.FXML
    public void initialize() {
        servicenameColum.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        alocatedColum.setCellValueFactory(new PropertyValueFactory<>("allocatedAmount"));
        spentColum.setCellValueFactory(new PropertyValueFactory<>("spentAmount"));

        // Sample data
        ObservableList<ServiceBudgetModel> data = FXCollections.observableArrayList(
                new ServiceBudgetModel("Health", 5000, 3200),
                new ServiceBudgetModel("Education", 4000, 3900),
                new ServiceBudgetModel("Food", 8000, 7500));
        viewallocationTabelView.setItems(data);

        // Calculate budget status
        double totalAllocated = data.stream().mapToDouble(ServiceBudgetModel::getAllocatedAmount).sum();
        double totalSpent = data.stream().mapToDouble(ServiceBudgetModel::getSpentAmount).sum();
        budgetStatusLabel.setText("Total Allocated: " + totalAllocated + " | Total Spent: " + totalSpent);
    }

    @javafx.fxml.FXML
    public void gobacktoaccountlogisticsdashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/AccountantAndLogisticsDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Accountant Logistics Coordinator Controller");
        stage.show();
    }

    @javafx.fxml.FXML
    public void viewbudgetOnAction(ActionEvent actionEvent) {
        System.out.println("Budget utilization viewed");
    }
}