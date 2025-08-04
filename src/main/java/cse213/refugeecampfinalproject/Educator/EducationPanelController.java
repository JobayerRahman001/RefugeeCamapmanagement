package cse213.refugeecampfinalproject.Educator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EducationPanelController
{
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
    public void updateprogramscheduleOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void enrollmentstatusOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void educatonapplicationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void archiveprogramOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void evulateteacherperformanceOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void uplodestudymaterialOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addprogramOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void asignteacherOnAction(ActionEvent actionEvent) {
    }
}