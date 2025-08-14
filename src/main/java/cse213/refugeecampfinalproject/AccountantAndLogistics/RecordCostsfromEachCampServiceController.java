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

public class RecordCostsfromEachCampServiceController
{
    @javafx.fxml.FXML
    private TextField ammountTextField;
    @javafx.fxml.FXML
    private TableColumn<recordCostModel,String> descriptionColum;
    @javafx.fxml.FXML
    private Label expencestatusLabel;
    @javafx.fxml.FXML
    private TableColumn<recordCostModel,Double> ammountColum;
    @javafx.fxml.FXML
    private ComboBox<String> servicenameComboBox;
    @javafx.fxml.FXML
    private TableColumn<recordCostModel, LocalDate> dateColum;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;
    @javafx.fxml.FXML
    private DatePicker expencedatepicker;
    @javafx.fxml.FXML
    private TableColumn<recordCostModel,String> serviceColum;
    @javafx.fxml.FXML
    private TableView<recordCostModel> recordTabelView;

    private ObservableList<recordCostModel> expenses = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {
        serviceColum.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        dateColum.setCellValueFactory(new PropertyValueFactory<>("date"));
        descriptionColum.setCellValueFactory(new PropertyValueFactory<>("description"));
        ammountColum.setCellValueFactory(new PropertyValueFactory<>("amount"));

        servicenameComboBox.getItems().addAll( "Health", "Education", "Logistics", "Food Distribution", "Water Supply");

    }

    @javafx.fxml.FXML
    public void saveexpenceOnAction(ActionEvent actionEvent) {
        try {
            String service = servicenameComboBox.getValue();
            double amount = Double.parseDouble(ammountTextField.getText());
            LocalDate date = expencedatepicker.getValue();
            String description = descriptionTextArea.getText();

            // Event-3 → Validate
            if (service == null || service.isEmpty() || date == null || amount <= 0) {
                expencestatusLabel.setText("Please fill all fields with valid data.");
                return;
            }

            // Create expense record
            recordCostModel expense = new recordCostModel(service, amount, date, description);

            // Save to model
            if (recordCostModel.addExpense(expense)) {
                expenses.setAll(recordCostModel.getAllExpenses());
                expencestatusLabel.setText("Expense saved ✅");
            } else {
                expencestatusLabel.setText("Error saving expense.");
            }

        } catch (NumberFormatException e) {
            expencestatusLabel.setText("Invalid amount format.");
        }
    }

    @javafx.fxml.FXML
    public void gobacktoaccountlogistictdashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/AccountantAndLogisticsDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Accountant Logistics Coordinator Controller");
        stage.show();
    }
}