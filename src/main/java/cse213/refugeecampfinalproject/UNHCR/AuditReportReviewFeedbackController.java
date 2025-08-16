package cse213.refugeecampfinalproject.UNHCR;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AuditReportReviewFeedbackController {

    @FXML
    private Label complianceStatusLabel;
    @FXML
    private TextArea auditfindingTextArea;
    @FXML
    private TextArea auditremarksTextarea;

    private AuditReportModel auditReportModel;

    @FXML
    public void initialize() {

        auditReportModel = new AuditReportModel(
                "Compliant",
                "All records match the requirements."
        );


        complianceStatusLabel.setText(auditReportModel.getComplianceStatus());
        auditfindingTextArea.setText(auditReportModel.getFindings());
    }

    @FXML
    public void submitfeedbackOnAction(ActionEvent actionEvent) {

        String remarks = auditremarksTextarea.getText();
        auditReportModel.setRemarks(remarks);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Feedback Submitted");
        alert.setHeaderText(null);
        alert.setContentText("Your feedback has been recorded successfully!");
        alert.showAndWait();
    }

    @FXML
    public void openauditrecordOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Audit Record");
        alert.setHeaderText("Audit Details");
        alert.setContentText("Compliance: " + auditReportModel.getComplianceStatus()
                + "\nFindings: " + auditReportModel.getFindings()
                + "\nRemarks: " + auditReportModel.getRemarks());
        alert.showAndWait();
    }

    @FXML
    public void gobacktoundashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/UNHCR/UNRepDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("UNHCR");
        stage.show();

    }
}
