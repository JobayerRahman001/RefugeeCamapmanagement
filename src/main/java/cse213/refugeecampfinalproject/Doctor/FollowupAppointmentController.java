<<<<<<<< HEAD:src/main/java/cse213/refugeecampfinalproject/DoctorAndEducationCoordinator/FollowupAppointmentController.java
package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
========
package cse213.refugeecampfinalproject.Doctor;
>>>>>>>> 3766be206684680eb274de4e03789a2b43595b2f:src/main/java/cse213/refugeecampfinalproject/Doctor/FollowupAppointmentController.java

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class FollowupAppointmentController
{
    @javafx.fxml.FXML
    private ComboBox selectPatientComboBox;
    @javafx.fxml.FXML
    private ComboBox choosetimeslotComboBox;
    @javafx.fxml.FXML
    private Label confirmationlabel;
    @javafx.fxml.FXML
    private DatePicker datepicker;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void triggerschedullingOnAction(ActionEvent actionEvent) {
    }
}