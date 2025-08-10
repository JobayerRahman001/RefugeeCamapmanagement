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
import java.time.LocalDate;
import java.util.Objects;

public class EmergencyFundRequestModelController
{
    @javafx.fxml.FXML
    private TextArea emergenctreasonTextArea;
    @javafx.fxml.FXML
    private TextField requestedammountTextField;
    @javafx.fxml.FXML
    private TableColumn<EmergencyFundRequestModel,Double> requestedammountColum;
    @javafx.fxml.FXML
    private Label selectedrequestedinfoLabel;
    @javafx.fxml.FXML
    private TableColumn<EmergencyFundRequestModel, LocalDate> requesteddateColum;
    @javafx.fxml.FXML
    private TableView<EmergencyFundRequestModel> emergencyfundrequestTabelView;
    @javafx.fxml.FXML
    private CheckBox emergencyvalidcheckbox;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private Label verificationnotesLabel;
    @javafx.fxml.FXML
    private TableColumn<EmergencyFundRequestModel,String> requesternameColum;

    private final ObservableList<EmergencyFundRequestModel> requestsList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {requesternameColum.setCellValueFactory(new PropertyValueFactory<>("requesterName"));
        requesteddateColum.setCellValueFactory(new PropertyValueFactory<>("requestDate"));
        requestedammountColum.setCellValueFactory(new PropertyValueFactory<>("requestedAmount"));

        emergencyfundrequestTabelView.setItems(requestsList);

        // Load sample data for testing
        requestsList.addAll(
                new EmergencyFundRequestModel("John Doe", LocalDate.of(2025, 7, 1), 5000, "Flood damage repair",true,null,null),
                new EmergencyFundRequestModel("Jane Smith", LocalDate.of(2025, 7, 5), 3000, "Medical emergency",true,null,null),
                new EmergencyFundRequestModel("Ali Khan", LocalDate.of(2025, 7, 7), 7000, "Shelter repair",true,null,null)
        );

        // When a request is selected, display details
        emergencyfundrequestTabelView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                showRequestDetails(newSelection);
            }
        });
    }
    private void showRequestDetails(EmergencyFundRequestModel request) {
        emergenctreasonTextArea.setText(request.getEmergencyReason());
        requestedammountTextField.setText(String.valueOf(request.getRequestedAmount()));
        emergencyvalidcheckbox.setSelected(request.isVerifiedEmergency());
        remarksTextArea.setText(request.getRemarks());
        selectedrequestedinfoLabel.setText("Selected Request: " + request.getRequesterName() + " (" + request.getRequestDate() + ")");
        verificationnotesLabel.setText("Status: " + request.getStatus());
    }

    @javafx.fxml.FXML
    public void approverequestOnAction(ActionEvent actionEvent) {
        EmergencyFundRequestModel selectedRequest = emergencyfundrequestTabelView.getSelectionModel().getSelectedItem();
        if (selectedRequest == null) {
            verificationnotesLabel.setText("No request selected.");
            return;
        }

        if (!emergencyvalidcheckbox.isSelected()) {
            verificationnotesLabel.setText("Verify emergency before approval.");
            return;
        }

        selectedRequest.setVerifiedEmergency(true);
        selectedRequest.setRemarks(remarksTextArea.getText());
        selectedRequest.setStatus("Approved");
        emergencyfundrequestTabelView.refresh();

        verificationnotesLabel.setText("Request approved successfully.");
    }

    @javafx.fxml.FXML
    public void rejectrequestOnAction(ActionEvent actionEvent) {
        EmergencyFundRequestModel selectedRequest = emergencyfundrequestTabelView.getSelectionModel().getSelectedItem();
        if (selectedRequest == null) {
            verificationnotesLabel.setText("No request selected.");
            return;
        }

        selectedRequest.setVerifiedEmergency(false);
        selectedRequest.setRemarks(remarksTextArea.getText());
        selectedRequest.setStatus("Rejected");
        emergencyfundrequestTabelView.refresh();

        verificationnotesLabel.setText("Request rejected.");
    }

    @javafx.fxml.FXML
    public void viewemergencyrequestOnAction(ActionEvent actionEvent) {
        EmergencyFundRequestModel selectedRequest = emergencyfundrequestTabelView.getSelectionModel().getSelectedItem();
        if (selectedRequest != null) {
            showRequestDetails(selectedRequest);
            verificationnotesLabel.setText("Review the request details.");
        } else {
            verificationnotesLabel.setText("Please select a request to view.");
        }
    }

    @javafx.fxml.FXML
    public void gobacktoundashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/AccountantLogisticsCoordinator.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Accountant Logistics Coordinator Controller");
        stage.show();
    }
}