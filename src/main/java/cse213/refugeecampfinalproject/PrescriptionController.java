package cse213.refugeecampfinalproject;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PrescriptionController
{
    @javafx.fxml.FXML
    private TableColumn medicinenameColum;
    @javafx.fxml.FXML
    private ComboBox selectpatientComboBox;
    @javafx.fxml.FXML
    private TableColumn stockColum;
    @javafx.fxml.FXML
    private TextField durationTextField;
    @javafx.fxml.FXML
    private TableColumn medicinetypeColum;
    @javafx.fxml.FXML
    private TableView medicintableview;
    @javafx.fxml.FXML
    private TextField doseTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void creatprecriptionOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) {
    }
}