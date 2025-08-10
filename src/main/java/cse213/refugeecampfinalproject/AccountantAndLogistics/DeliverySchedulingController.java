package cse213.refugeecampfinalproject.AccountantAndLogistics;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class DeliverySchedulingController
{
    @javafx.fxml.FXML
    private TextField vehicleidTextField;
    @javafx.fxml.FXML
    private Label statusmassegelabel;
    @javafx.fxml.FXML
    private TextField routeTextField;
    @javafx.fxml.FXML
    private TextArea suppliesTextArea;
    @javafx.fxml.FXML
    private Label conflictcheckLabel;
    @javafx.fxml.FXML
    private DatePicker datepicker;

    private static final ArrayList<String> scheduledDeliveries = new ArrayList<>();

    private String newScheduleKey = null;
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void adddeliveryOnAction(ActionEvent actionEvent) {
        String vehicle = vehicleidTextField.getText().trim();
        String route = routeTextField.getText().trim();
        String supplies = suppliesTextArea.getText().trim();
        LocalDate date = datepicker.getValue();


        if (vehicle.isEmpty() || route.isEmpty() || supplies.isEmpty() || date == null) {
            statusmassegelabel.setText("Please fill in all fields.");
            return;
        }


        String scheduleKey = vehicle + "_" + date.toString();


        if (scheduledDeliveries.contains(scheduleKey)) {
            conflictcheckLabel.setText("Conflict ❌ This vehicle already has a delivery on that date.");
            statusmassegelabel.setText("Please choose a different date or vehicle.");
            newScheduleKey = null; // nothing to confirm
        } else {
            conflictcheckLabel.setText("No conflict ✅");
            statusmassegelabel.setText("Ready to confirm delivery.");
            newScheduleKey = scheduleKey; // save for confirmation
        }
    }

    @javafx.fxml.FXML
    public void confirmOnAction(ActionEvent actionEvent) {
        if (newScheduleKey == null) {
            statusmassegelabel.setText("Cannot confirm. Please resolve conflicts first.");
            return;
        }


        scheduledDeliveries.add(newScheduleKey);


        statusmassegelabel.setText("Delivery scheduled & driver notified ✅");
        conflictcheckLabel.setText("Confirmed on: " + datepicker.getValue());


        vehicleidTextField.clear();
        routeTextField.clear();
        suppliesTextArea.clear();
        datepicker.setValue(null);
        newScheduleKey = null;
    }



    @javafx.fxml.FXML
    public void gobacktoaccountlogisticdashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/AccountantLogisticsCoordinator.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Accountant Logistics Coordinator Controller");
        stage.show();
    }
}