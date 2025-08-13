package cse213.refugeecampfinalproject.UNHCR;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
        if (currentProgram == null) {
            showAlert("Error", "No program to approve. Start a program first.");
            return;
        }

        currentProgram.approve();
        statusLabel.setText("Program approved: " + currentProgram.getProgramName());
    
    }

    @javafx.fxml.FXML
    public void startnewprogramOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void gobacktoundashboardOnAction(ActionEvent actionEvent) {
    }
}