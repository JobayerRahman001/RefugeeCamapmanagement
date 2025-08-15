package cse213.refugeecampfinalproject.ResourceManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ResourceWaterLogsController {

    @javafx.fxml.FXML
    private TextField clarityLabel;

    @javafx.fxml.FXML
    private Button saveTestBrequestRefillButtonutton1;

    @javafx.fxml.FXML
    private Label phLabel;

    @javafx.fxml.FXML
    private TableColumn<WaterTankModel, String> tankNameColumn;

    @javafx.fxml.FXML
    private Label ETALabel;

    @javafx.fxml.FXML
    private TableColumn<WaterTankModel, Double> tankLevelColumn;

    @javafx.fxml.FXML
    private TableColumn<WaterTankModel, String> tankStatusColumn;

    @javafx.fxml.FXML
    private TableView<WaterTankModel> repairTicketsTable;

    @javafx.fxml.FXML
    private Button saveTestButton;

    @javafx.fxml.FXML
    private Label testResultLabel;

    @javafx.fxml.FXML
    private Label assignStaffLabel;

    @javafx.fxml.FXML
    private TextField phField;

    private final ObservableList<WaterTankModel> waterTanks = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        tankNameColumn.setCellValueFactory(new PropertyValueFactory<>("tankName"));
        tankLevelColumn.setCellValueFactory(new PropertyValueFactory<>("level"));
        tankStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        waterTanks.addAll(
                new WaterTankModel("Tank A", 80),
                new WaterTankModel("Tank B", 50),
                new WaterTankModel("Tank C", 20)
        );

        repairTicketsTable.setItems(waterTanks);
    }

    @javafx.fxml.FXML
    public void saveTestButtonOnAction(ActionEvent actionEvent) {
        try {
            double phValue = Double.parseDouble(phField.getText());
            double clarityValue = Double.parseDouble(clarityLabel.getText());

            String quality = "Safe";
            if (phValue < 6.5 || phValue > 8.5 || clarityValue < 80) {
                quality = "Unsafe";
            }

            testResultLabel.setText("Result: " + quality);
        } catch (NumberFormatException e) {
            testResultLabel.setText("Invalid input");
        }
    }

    @javafx.fxml.FXML
    public void requestRefillButtonOnAction(ActionEvent actionEvent) {
        WaterTankModel selectedTank = repairTicketsTable.getSelectionModel().getSelectedItem();
        if (selectedTank != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Refill Request");
            alert.setHeaderText(null);
            alert.setContentText("Refill request sent for: " + selectedTank.getTankName());
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Tank Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a tank to request refill.");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                "/cse213/refugeecampfinalproject/ResourceManager/ResourcesDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Resources Dashboard");
        stage.show();
    }
}
