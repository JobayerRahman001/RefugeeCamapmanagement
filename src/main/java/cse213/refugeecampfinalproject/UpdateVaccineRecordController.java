package cse213.refugeecampfinalproject;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdateVaccineRecordController
{

    @javafx.fxml.FXML
    private ComboBox<String> selectPatientComboBox;
    @javafx.fxml.FXML
    private TextField vaccinnameTextField;
    @javafx.fxml.FXML
    private TextArea vaccinoutputTextArea;
    @javafx.fxml.FXML
    private TextField doseTextField;
    @javafx.fxml.FXML
    private DatePicker datepicker;
    @javafx.fxml.FXML
    private TextField batchNoTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateVaccinOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) {
    }
}