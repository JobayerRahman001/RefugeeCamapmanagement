package cse213.refugeecampfinalproject;

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