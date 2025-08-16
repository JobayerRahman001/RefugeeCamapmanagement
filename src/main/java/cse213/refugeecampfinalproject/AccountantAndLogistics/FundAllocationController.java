package cse213.refugeecampfinalproject.AccountantAndLogistics;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class FundAllocationController
{
    @javafx.fxml.FXML
    private TextField healthallocationTextField;
    @javafx.fxml.FXML
    private Label budgetcheckLabel;
    @javafx.fxml.FXML
    private Label balanceupdatenoticeLabel;
    @javafx.fxml.FXML
    private Label statusmassegeLabel;
    @javafx.fxml.FXML
    private TextField educationallocationTextField;
    @javafx.fxml.FXML
    private TextField otherallocationTextField;
    @javafx.fxml.FXML
    private TextField logisticsallocationTextField;

    private static double availableBudget = 50000;

    @javafx.fxml.FXML
    public void initialize() {
        budgetcheckLabel.setText("Available Budget: " + availableBudget);
    }

    @javafx.fxml.FXML
    public void confirmdistributionOnAction(ActionEvent actionEvent) {
        if (!budgetcheckLabel.getText().contains("OK")) {
            statusmassegeLabel.setText("Cannot confirm. Budget exceeded!");
            return;
        }

        allocateToDepartment("Health", "Department Support", healthallocationTextField);
        allocateToDepartment("Education", "Department Support", educationallocationTextField);
        allocateToDepartment("Logistics", "Department Support", logisticsallocationTextField);
        allocateToDepartment("Other", "Department Support", otherallocationTextField);

        balanceupdatenoticeLabel.setText("Balances updated ");
        budgetcheckLabel.setText("Available Budget: " + getAvailableBudget());
        statusmassegeLabel.setText("Fund distribution completed.");
    }

    private void allocateToDepartment(String program, String purpose, TextField field) {
        try {
            double amount = Double.parseDouble(field.getText());
            FundAllocationModel allocation = new FundAllocationModel(
                    program,
                    purpose,
                    amount,
                    LocalDateTime.now()
            );
            //FundAllocationModel.allocateFunds(allocation);
        } catch (NumberFormatException ignored) {
        }
    }

    private double getAvailableBudget() {
        try {
            java.lang.reflect.Field field = FundAllocationModel.class.getDeclaredField("availableBudget");
            field.setAccessible(true);
            return field.getDouble(null);
        } catch (Exception e) {
            return 0;
        }
    }



    @javafx.fxml.FXML
    public void GoBacktoAccountantLogisticsCoordinatorOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/AccountantAndLogistics/AccountantAndLogisticsDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Accountant & Logistics Coordinator");
        stage.show();
    }

    @javafx.fxml.FXML
    public void allocatefundOnAction(ActionEvent actionEvent) {
        try {
            double health = Double.parseDouble(healthallocationTextField.getText());
            double education = Double.parseDouble(educationallocationTextField.getText());
            double logistics = Double.parseDouble(logisticsallocationTextField.getText());
            double other = Double.parseDouble(otherallocationTextField.getText());

            double totalRequested = health + education + logistics + other;

            if (totalRequested <= getAvailableBudget()) {
                budgetcheckLabel.setText("Budget OK ");
                statusmassegeLabel.setText("Ready to confirm allocation.");
            } else {
                budgetcheckLabel.setText("Budget Exceeded ");
                statusmassegeLabel.setText("Requested: " + totalRequested +
                        " | Available: " + getAvailableBudget());
            }
        } catch (NumberFormatException e) {
            statusmassegeLabel.setText("Please enter valid numbers.");
        }
    }
}