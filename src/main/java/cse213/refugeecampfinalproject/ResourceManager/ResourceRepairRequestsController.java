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

public class ResourceRepairRequestsController {

    @javafx.fxml.FXML
    private Label InputLabel, assignStaffLabel, ETALabel, confirmationLabel;

    @javafx.fxml.FXML
    private TextField etaField;

    @javafx.fxml.FXML
    private Button updateRequestButton;

    @javafx.fxml.FXML
    private ComboBox<String> staffComboBox;

    @javafx.fxml.FXML
    private TableView<RepairTicketModel> repairTicketsTable;

    @javafx.fxml.FXML
    private TableColumn<RepairTicketModel, String> issueColumn, priorityColumn, statusColumn;

    private final ObservableList<RepairTicketModel> repairTicketsList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        staffComboBox.getItems().addAll("Staff A", "Staff B", "Staff C");


        repairTicketsList.addAll(
                new RepairTicketModel("Broken Window", "High", "Pending"),
                new RepairTicketModel("Leaking Pipe", "Medium", "Pending")
        );


        issueColumn.setCellValueFactory(new PropertyValueFactory<>("issue"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        repairTicketsTable.setItems(repairTicketsList);
    }

    @javafx.fxml.FXML
    public void updateRequestButtonOnAction(ActionEvent actionEvent) {
        RepairTicketModel selectedTicket = repairTicketsTable.getSelectionModel().getSelectedItem();
        String assignedStaff = staffComboBox.getValue();
        String eta = etaField.getText().trim();

        if (selectedTicket == null) {
            confirmationLabel.setText("Please select a repair ticket.");
            return;
        }
        if (assignedStaff == null || eta.isEmpty()) {
            confirmationLabel.setText("Please select staff and enter ETA.");
            return;
        }

        selectedTicket.setAssignedStaff(assignedStaff);
        selectedTicket.setEta(eta);
        selectedTicket.setStatus("Assigned");

        repairTicketsTable.refresh();
        confirmationLabel.setText("Ticket updated successfully.");
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(
                getClass().getResource("/cse213/refugeecampfinalproject/ResourceManager/ResourcesDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Resources Dashboard");
        stage.show();
    }
}
