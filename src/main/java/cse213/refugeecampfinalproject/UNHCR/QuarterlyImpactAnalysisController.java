package cse213.refugeecampfinalproject.UNHCR;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class QuarterlyImpactAnalysisController
{
    @javafx.fxml.FXML
    private TextField healthparcentTextField;
    @javafx.fxml.FXML
    private TextField enrollmentcountTextField;
    @javafx.fxml.FXML
    private Label impactheadingLabel;
    @javafx.fxml.FXML
    private TextField patientcountTextField;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TextField infrastructuredateTextField;
    @javafx.fxml.FXML
    private TextField educationparcentTextField;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    public void submitreportOnAction(ActionEvent actionEvent) {
        try {
            double eduPercent = Double.parseDouble(educationparcentTextField.getText());
            double healthPercent = Double.parseDouble(healthparcentTextField.getText());
            String infraDate = infrastructuredateTextField.getText();
            int enrollment = Integer.parseInt(enrollmentcountTextField.getText());
            int patients = Integer.parseInt(patientcountTextField.getText());
            String remarks = remarksTextArea.getText();
            QuaterlyImpactModel QuaterlyImpactModel = new QuaterlyImpactModel(eduPercent, healthPercent, infraDate, enrollment, patients, remarks);

            statusLabel.setText("Report for " + infraDate + " submitted successfully.");
        } catch (NumberFormatException e) {
            statusLabel.setText("Error: Please enter valid numbers in percentage and counts.");
        }
}

    @javafx.fxml.FXML
    public void newquarterreportOnAction(ActionEvent actionEvent) {
        educationparcentTextField.setText("78.5");
        healthparcentTextField.setText("85.2");
        infrastructuredateTextField.setText("2025-Q2");
        enrollmentcountTextField.setText("1200");
        patientcountTextField.setText("450");
        statusLabel.setText("Fetched data for new quarter. Enter remarks to complete report.");
    }

    @javafx.fxml.FXML
    public void gobacktoundashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/homepage.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Home");
        stage.show();
    }
}