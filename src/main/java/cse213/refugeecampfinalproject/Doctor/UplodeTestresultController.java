<<<<<<<< HEAD:src/main/java/cse213/refugeecampfinalproject/DoctorAndEducationCoordinator/UplodeTestresultController.java
package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
========
package cse213.refugeecampfinalproject.Doctor;
>>>>>>>> 3766be206684680eb274de4e03789a2b43595b2f:src/main/java/cse213/refugeecampfinalproject/Doctor/UplodeTestresultController.java

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class UplodeTestresultController
{
    @javafx.fxml.FXML
    private ComboBox<String> selectpatientComboBox;
    @javafx.fxml.FXML
    private Label confirmationlabel;
    @javafx.fxml.FXML
    private TextField reportTypeTextField;
    @javafx.fxml.FXML
    private DatePicker datepicker;
    @javafx.fxml.FXML
    private TextField filepathTextField;



    @javafx.fxml.FXML
    public void initialize() {
        selectpatientComboBox.getItems().addAll("");
    }

    @javafx.fxml.FXML
    public void uplodereportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void openfilechooserOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Doctor/HealthPortal.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Health Portal");
        stage.show();
    }
}