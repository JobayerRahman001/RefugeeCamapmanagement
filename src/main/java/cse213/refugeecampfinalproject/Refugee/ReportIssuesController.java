package cse213.refugeecampfinalproject.Refugee;

import cse213.refugeecampfinalproject.Admin.IssueReportsModel;
import cse213.refugeecampfinalproject.LoggedInRefModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ReportIssuesController
{
    @javafx.fxml.FXML
    private ComboBox<String> issueUrgencyLvlComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> issueCategoryComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> issueLocationComboBox;
    @javafx.fxml.FXML
    private Label reportIssueMsgLabel;
    @javafx.fxml.FXML
    private TextField issueDetailsTextField;
    @javafx.fxml.FXML
    private TextField refIDTextField;

    public static ObservableList<IssueReportsModel> IssueReportsList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        issueUrgencyLvlComboBox.getItems().addAll("Low", "Medium", "High", "Immediate");
        issueLocationComboBox.getItems().addAll("Block A", "Block B", "Block C", "Block D");
        issueCategoryComboBox.getItems().addAll("safety", "Clean Water", "Hygiene & Sanitation", "Toiletaries", "Food", "Shelter", "Other");
    }

    @javafx.fxml.FXML
    public void backtoDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Refugee/RefugeeDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Refugee Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void sendReportOnClick(ActionEvent actionEvent) {
        if(refIDTextField.getText().isEmpty()||issueCategoryComboBox.getValue()==null||issueLocationComboBox.getValue()==null||issueUrgencyLvlComboBox.getValue()==null||issueDetailsTextField.getText().isEmpty()) {
            reportIssueMsgLabel.setText("Please fill in everything");
            return;
        }

        String refugeeID = refIDTextField.getText().trim();
        if(!refugeeID.equals(LoggedInRefModel.getLoggedInRefugeeId())){
            reportIssueMsgLabel.setText("Please enter your own refugee ID!");
            return;
        }
        String category = issueCategoryComboBox.getValue();
        String details = issueDetailsTextField.getText().trim();
        String urgency = issueUrgencyLvlComboBox.getValue();
        String location = issueLocationComboBox.getValue();
        String status = "Pending";
        IssueReportsModel issuereportsModel = new IssueReportsModel(refugeeID, category, details, urgency, location, status);
        for(IssueReportsModel IRM : IssueReportsList) {
            if(IRM.getRefugeeID().equals(refugeeID) && IRM.getCategory().equals("safety")||IRM.getCategory().equals("Clean Water")||IRM.getCategory().equals("Hygiene & Sanitation")||IRM.getCategory().equals("Food")||IRM.getCategory().equals("Shelter")) {
                reportIssueMsgLabel.setText("You have already made a report.");
                return;
            }
        }
        reportIssueMsgLabel.setText("Thank you for reporting, the authorities will get to it.");

        IssueReportsList.add(issuereportsModel);
    }
}