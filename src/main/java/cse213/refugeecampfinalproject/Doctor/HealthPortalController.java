package cse213.refugeecampfinalproject.Doctor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HealthPortalController {
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/homepage.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Home");
        stage.show();
    }

    @javafx.fxml.FXML
    public void reviewongoingOnAction(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    public void creatpreacriptionOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void testresultOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updatevaccinrecordOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewAppointmentOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/ReviewAppointment.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Review Appointments");
        stage.show();
    }

    @javafx.fxml.FXML
    public void referhospitalOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void schedulefollowupOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addmedicalnotesOnAction(ActionEvent actionEvent) {
    }
}