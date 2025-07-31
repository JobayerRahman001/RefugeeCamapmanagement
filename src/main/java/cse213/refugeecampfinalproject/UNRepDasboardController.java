package cse213.refugeecampfinalproject;

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
    public void fundnewinitiativeOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void annualfundingplanOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void auditreportfeedbackOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void impactanalysisreportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void monthlysummaryreportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void checkfundbalanceOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveemergencyfundOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToHomeOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewcountrydonationOnAction(ActionEvent actionEvent) {
    }
}