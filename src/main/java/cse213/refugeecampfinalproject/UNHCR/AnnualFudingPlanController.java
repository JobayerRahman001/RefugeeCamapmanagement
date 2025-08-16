package cse213.refugeecampfinalproject.UNHCR;

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

public class AnnualFudingPlanController
{
    @javafx.fxml.FXML
    private TextField educationsectorallocationTextField;
    @javafx.fxml.FXML
    private TextField totalexpectedfundTextField;
    @javafx.fxml.FXML
    private TableView annualfundplanningTabelView;
    @javafx.fxml.FXML
    private TextArea fundingpriopitiesTextArea;
    @javafx.fxml.FXML
    private Label statesLabel;
    @javafx.fxml.FXML
    private TextField healthsectorallocatonTextField;
    @javafx.fxml.FXML
    private TextField othersectorallocationTextField;
    @javafx.fxml.FXML
    private TableColumn sectornameColum;
    @javafx.fxml.FXML
    private TableColumn allocatedammountColum;

    private ObservableList<annualFundingModel> sectorData = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() { sectornameColum.setCellValueFactory(new PropertyValueFactory<>("sectorName"));
        allocatedammountColum.setCellValueFactory(new PropertyValueFactory<>("allocatedAmount"));

        annualfundplanningTabelView.setItems(sectorData);
    }

    @javafx.fxml.FXML
    public void submitplanOnAction(ActionEvent actionEvent) {
        if (totalexpectedfundTextField.getText().isEmpty() ||
                educationsectorallocationTextField.getText().isEmpty() ||
                healthsectorallocatonTextField.getText().isEmpty() ||
                othersectorallocationTextField.getText().isEmpty() ||
                fundingpriopitiesTextArea.getText().isEmpty()) {
            statesLabel.setText("Error: All fields must be filled.");
            return;
        }

        try {
            double totalFund = Double.parseDouble(totalexpectedfundTextField.getText());
            double educationAllocation = Double.parseDouble(educationsectorallocationTextField.getText());
            double healthAllocation = Double.parseDouble(healthsectorallocatonTextField.getText());
            double otherAllocation = Double.parseDouble(othersectorallocationTextField.getText());

            // Step 2: Add data to TableView
            sectorData.clear();
            sectorData.add(new annualFundingModel("Education", educationAllocation));
            sectorData.add(new annualFundingModel("Health", healthAllocation));
            sectorData.add(new annualFundingModel("Other", otherAllocation));

            // Step 3: Check total allocations match total fund
            double sumAllocations = educationAllocation + healthAllocation + otherAllocation;
            if (sumAllocations != totalFund) {
                statesLabel.setText("Warning: Total allocation does not match total expected fund!");
            } else {
                statesLabel.setText("Plan submitted. Please confirm submission.");
            }

        } catch (NumberFormatException e) {
            statesLabel.setText("Error: Please enter valid numeric values.");
        }
    }

    @javafx.fxml.FXML
    public void confirmsubmissionOnAction(ActionEvent actionEvent) {
        statesLabel.setText("Annual funding plan confirmed and submitted.");

    }

    @javafx.fxml.FXML
    public void viewlastyearspendingOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Last Year's Spending");
        alert.setHeaderText("Report");
        alert.setContentText("Last year's spending report is not yet implemented.");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void gobacktoundashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/UNHCR/UNRepDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("UNHCR");
        stage.show();
    }
}