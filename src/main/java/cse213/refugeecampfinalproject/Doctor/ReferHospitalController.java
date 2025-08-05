<<<<<<<< HEAD:src/main/java/cse213/refugeecampfinalproject/DoctorAndEducationCoordinator/ReferHospitalController.java
package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
========
package cse213.refugeecampfinalproject.Doctor;
>>>>>>>> 3766be206684680eb274de4e03789a2b43595b2f:src/main/java/cse213/refugeecampfinalproject/Doctor/ReferHospitalController.java

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReferHospitalController
{
    @javafx.fxml.FXML
    private ComboBox selectpatientComboBox;
    @javafx.fxml.FXML
    private TextField hospitalNameTextField;
    @javafx.fxml.FXML
    private TextArea referaloutputTextArea;
    @javafx.fxml.FXML
    private TextArea reasonTextArea;
    @javafx.fxml.FXML
    private ComboBox urgencyComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void refertoHospitalOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) {
    }
}