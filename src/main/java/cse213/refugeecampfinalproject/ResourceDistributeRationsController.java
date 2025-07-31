package cse213.refugeecampfinalproject;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ResourceDistributeRationsController
{
    @javafx.fxml.FXML
    private TableColumn FamilyNameColumn;
    @javafx.fxml.FXML
    private TableView familyTableView;
    @javafx.fxml.FXML
    private TableColumn FamilyIDColumn;
    @javafx.fxml.FXML
    private Button distributeButton;
    @javafx.fxml.FXML
    private TableColumn MembersColumn;
    @javafx.fxml.FXML
    private Label messageLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void distributeButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) {
    }
}