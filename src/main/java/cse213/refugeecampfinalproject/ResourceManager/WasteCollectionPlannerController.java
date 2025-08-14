package cse213.refugeecampfinalproject.ResourceManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class WasteCollectionPlannerController {

    public Label statusLabel;
    public ComboBox<String> zoneSelector;
    public ComboBox<String> truckSelector;
    public ComboBox<String> prioritySelector;

    private ObservableList<WasteCollectionModel> assignments = FXCollections.observableArrayList();

    public void initialize() {
        zoneSelector.setItems(FXCollections.observableArrayList("Zone A", "Zone B", "Zone C"));
        truckSelector.setItems(FXCollections.observableArrayList("Truck 1", "Truck 2", "Truck 3"));
        prioritySelector.setItems(FXCollections.observableArrayList("High", "Medium", "Low"));
        statusLabel.setText("Select zone, truck, and priority.");
    }

    public void planCollectionBtnOnAction(ActionEvent event) {
        WasteCollectionModel assignment = new WasteCollectionModel(
                zoneSelector.getValue(),
                truckSelector.getValue(),
                prioritySelector.getValue()
        );
        assignments.add(assignment);
        statusLabel.setText("Planned: " + assignment.toString());
        zoneSelector.setValue(null);
        truckSelector.setValue(null);
        prioritySelector.setValue(null);
    }

    public void confirmRoutesBtnOnAction(ActionEvent event) {
        StringBuilder sb = new StringBuilder("Routes confirmed:\n");
        for (WasteCollectionModel a : assignments) sb.append(a).append("\n");
        statusLabel.setText(sb.toString());
        assignments.clear();
    }

    public void backToDashboardOnClick(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                "/cse213/refugeecampfinalproject/ResourceManager/ResourcesDashboard.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Resources Dashboard");
        stage.show();
    }
}
