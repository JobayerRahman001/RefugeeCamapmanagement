package cse213.refugeecampfinalproject.UNHCR;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FundNewInitiativesController
{
    @javafx.fxml.FXML
    private TextField programNameTextField;
    @javafx.fxml.FXML
    private TextArea purposeTextArea;
    @javafx.fxml.FXML
    private TextField fundAmmountTextField;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void approveprogramOnAction(ActionEvent actionEvent) {
        String name = programNameTextField.getText().trim();
        String purpose = purposeTextArea.getText().trim();
        String fundAmount = fundAmmountTextField.getText().trim();

        if (name.isEmpty() || purpose.isEmpty() || fundAmount.isEmpty()) {
            statusLabel.setText("Cannot approve. Fill all fields first.");
            return;
        }

        // Simple validation: fund must be positive
        try {
            double fund = Double.parseDouble(fundAmount);
            if (fund <= 0) {
                statusLabel.setText("Fund amount must be greater than 0.");
                return;
            }
            // Simulate logging approval
            statusLabel.setText("Program approved: " + name);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Program Approved");
            alert.setHeaderText(null);
            alert.setContentText("Program '" + name + "' has been approved with fund $" + fund);
            alert.showAndWait();

            // Clear fields after approval
            programNameTextField.clear();
            purposeTextArea.clear();
            fundAmmountTextField.clear();

        } catch (NumberFormatException e) {
            statusLabel.setText("Fund amount must be a valid number.");
        }

    }

    @javafx.fxml.FXML
    public void startnewprogramOnAction(ActionEvent actionEvent) {
        String name = programNameTextField.getText().trim();
        String purpose = purposeTextArea.getText().trim();
        String fundAmount = fundAmmountTextField.getText().trim();

        if (name.isEmpty() || purpose.isEmpty() || fundAmount.isEmpty()) {
            statusLabel.setText("Please fill in all fields.");
            return;
        }

        try {
            double fund = Double.parseDouble(fundAmount);
            statusLabel.setText("Program details entered. Ready to approve.");
        } catch (NumberFormatException e) {
            statusLabel.setText("Fund amount must be a number.");
        }
    }

    @javafx.fxml.FXML
    public void gobacktoundashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/UNHCR/UNRepDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("UNHCR");
        stage.show();
    }
}