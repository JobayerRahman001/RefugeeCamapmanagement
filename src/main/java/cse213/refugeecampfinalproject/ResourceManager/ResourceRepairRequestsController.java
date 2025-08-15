package cse213.refugeecampfinalproject.ResourceManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class ResourceRepairRequestsController {

    public Label confirmationLabel;
    public TextField etaField;
    public ComboBox<String> staffComboBox;
    public Button updateRequestButton;
    public TableView<RepairTicketModel> repairTicketsTable;
    public TableColumn<RepairTicketModel, String> issueColumn, priorityColumn, statusColumn;

    private ObservableList<RepairTicketModel> repairTicketsList = FXCollections.observableArrayList();

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


        updateRequestButton.setDisable(true);
        repairTicketsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            updateRequestButton.setDisable(newSel == null);
            confirmationLabel.setText("");
        });
    }

    public void updateRequestButtonOnAction(ActionEvent actionEvent) {
        RepairTicketModel ticket = repairTicketsTable.getSelectionModel().getSelectedItem();
        String staff = staffComboBox.getValue();
        String eta = etaField.getText().trim();

        if (ticket == null) {
            confirmationLabel.setText("Select a ticket.");
            return;
        }
        if (staff == null || eta.isEmpty()) {
            confirmationLabel.setText("Select staff and enter ETA.");
            return;
        }


        for (RepairTicketModel t : repairTicketsList) {
            if (t.getAssignedStaff() != null && t.getAssignedStaff().equalsIgnoreCase(staff) && t != ticket) {
                confirmationLabel.setText(staff + " is already assigned.");
                return;
            }
        }


        try {
            LocalDate date = LocalDate.parse(eta);
            if (date.isBefore(LocalDate.now())) {
                confirmationLabel.setText("ETA cannot be in the past.");
                return;
            }
        } catch (DateTimeParseException e) {
            confirmationLabel.setText("Invalid date. Use yyyy-MM-dd.");
            return;
        }


        ticket.setAssignedStaff(staff);
        ticket.setEta(eta);
        ticket.setStatus("Assigned");
        repairTicketsTable.refresh();
        confirmationLabel.setText("Ticket updated successfully.");
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                "/cse213/refugeecampfinalproject/ResourcesManager/ResourcesDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Resources Dashboard");
        stage.show();
    }

}
