package cse213.refugeecampfinalproject.UNHCR;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CountryDonation
{
    @javafx.fxml.FXML
    private TableView countrydonationTabelView;
    @javafx.fxml.FXML
    private TableView donationTabelView;
    @javafx.fxml.FXML
    private TableColumn donationdateColum;
    @javafx.fxml.FXML
    private TableColumn countrynameColum;
    @javafx.fxml.FXML
    private Label labelState;
    @javafx.fxml.FXML
    private TableColumn donationammountColum;
    @javafx.fxml.FXML
    private TableColumn totalammountColum;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void downlodesummaryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewcountrysummaryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void gobacktoundashboardOnAction(ActionEvent actionEvent) {
    }
}