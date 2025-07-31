package cse213.refugeecampfinalproject;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class MedicalNotesController
{
    @javafx.fxml.FXML
    private TextArea diagnosisTextArea;
    @javafx.fxml.FXML
    private TextArea prescribmedicinTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> patientCombobox;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveInfoOnAtion(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) {
    }
}