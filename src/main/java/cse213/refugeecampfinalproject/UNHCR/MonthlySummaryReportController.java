package cse213.refugeecampfinalproject.UNHCR;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class MonthlySummaryReportController
{
    @javafx.fxml.FXML
    private ComboBox<String> monthComboBox;
    @javafx.fxml.FXML
    private Label statusLabel;
private FileWriter writer;
    @javafx.fxml.FXML
    public void initialize() {
        monthComboBox.getItems().addAll(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
    }

    @javafx.fxml.FXML
    public void openmonthlysummaryOnAction(ActionEvent actionEvent) {
        String month = monthComboBox.getValue();
        if (month == null) {
            statusLabel.setText("Please select a month.");
            return;
        }
        monthlySummaryModel report = new monthlySummaryModel(month, true);

        if (report.isDataComplete()) {
            statusLabel.setText("Data loaded for " + report.getMonth());
        } else {
            statusLabel.setText("Data is incomplete for " + report.getMonth());
        }

    }

    @javafx.fxml.FXML
    public void downlodeOnAction(ActionEvent actionEvent) {
        String month = monthComboBox.getValue();
        if (month == null) {
            statusLabel.setText("Select month before downloading.");
            return;
        }

        // Simulate saving PDF (here we just create a .txt file for simplicity)
        try (FileWriter writer = new FileWriter(month + "_summary.txt")) {
            writer.write("Monthly Summary Report for " + month + "\n");
            writer.write("Fund Allocation: $5000\n");
            writer.write("Expenses: $3200\n");
            writer.write("Remaining Balance: $1800\n");
            statusLabel.setText("Report saved for " + month);
        } catch (IOException e) {
            statusLabel.setText("Error saving file.");
        }

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