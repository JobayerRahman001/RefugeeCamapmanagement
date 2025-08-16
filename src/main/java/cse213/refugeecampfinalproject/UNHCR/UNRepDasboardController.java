package cse213.refugeecampfinalproject.UNHCR;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class UNRepDasboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @java.lang.Deprecated
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/homepage.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Home");
        stage.show();
    }

    @javafx.fxml.FXML
    public void fundnewinitiativeOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/UNHCR/FundNewInitiatives.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Fund New Initiatives");
        stage.show();
    }

    @javafx.fxml.FXML
    public void annualfundingplanOnAction(ActionEvent actionEvent) throws IOException {

        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/UNHCR/AnnualFudingPlan.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Annual Fuding Plan");
        stage.show();
    }

    @javafx.fxml.FXML
    public void auditreportfeedbackOnAction(ActionEvent actionEvent) throws IOException {

        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/UNHCR/AuditReportReviewFeedback.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Audit Report Review Feedback");
        stage.show();
    }

    @javafx.fxml.FXML
    public void impactanalysisreportOnAction(ActionEvent actionEvent) throws IOException {

        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/UNHCR/QuarterlyImpactAnalysis.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Quarterly Impact Analysis");
        stage.show();
    }

    @javafx.fxml.FXML
    public void monthlysummaryreportOnAction(ActionEvent actionEvent) throws IOException {

        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/UNHCR/MonthlySummaryReport.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Monthly Summary Report");
        stage.show();
    }

    @javafx.fxml.FXML
    public void checkfundbalanceOnAction(ActionEvent actionEvent) throws IOException {

        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/UNHCR/DailyFundBalance.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Daily Fund Balance");
        stage.show();
    }

    @javafx.fxml.FXML
    public void approveemergencyfundOnAction(ActionEvent actionEvent) throws IOException {

        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/UNHCR/EmergencyFundRequest.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Emergency Fund Request");
        stage.show();
    }

//    @javafx.fxml.FXML
//    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
//
//        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/homepage.fxml")));
//        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        stage.setScene(new Scene(home));
//        stage.setTitle("Home");
//        stage.show();
//    }

    @javafx.fxml.FXML
    public void viewcountrydonationOnAction(ActionEvent actionEvent) throws IOException {

        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/UNHCR/CountryDonation.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Country Donation");
        stage.show();
    }

    @javafx.fxml.FXML
    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/homepage.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Home");
        stage.show();
    }
}