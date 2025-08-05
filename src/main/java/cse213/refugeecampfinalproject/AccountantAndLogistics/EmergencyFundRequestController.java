package cse213.refugeecampfinalproject.AccountantAndLogistics;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class EmergencyFundRequestController
{
    @javafx.fxml.FXML
    private TextArea emergenctreasonTextArea;
    @javafx.fxml.FXML
    private TextField requestedammountTextField;
    @javafx.fxml.FXML
    private TableColumn requestedammountColum;
    @javafx.fxml.FXML
    private Label selectedrequestedinfoLabel;
    @javafx.fxml.FXML
    private TableColumn requesteddateColum;
    @javafx.fxml.FXML
    private TableView emergencyfundrequestTabelView;
    @javafx.fxml.FXML
    private CheckBox emergencyvalidcheckbox;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private Label verificationnotesLabel;
    @javafx.fxml.FXML
    private TableColumn requesternameColum;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void approverequestOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void rejectrequestOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewemergencyrequestOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void gobacktoundashboardOnAction(ActionEvent actionEvent) {
    }
}