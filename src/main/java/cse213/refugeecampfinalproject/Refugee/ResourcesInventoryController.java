package cse213.refugeecampfinalproject.Refugee;

import cse213.refugeecampfinalproject.LoggedInRefModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ResourcesInventoryController
{
    @javafx.fxml.FXML
    private Label ResourcesInventoryMsgLabel;
    @javafx.fxml.FXML
    private TextField reasonTextField;
    @javafx.fxml.FXML
    private TextField quantityTextField;
    @javafx.fxml.FXML
    private TextField refugeeIDTextField;
    @javafx.fxml.FXML
    private ComboBox<String> requestTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        requestTypeComboBox.getItems().addAll("Shirt", "Jacket", "Blanket", "Shawl", "Female Attire", "Male Attire", "Children Attire", "Extra Food", "Medicine");
    }

    public static ObservableList<ResourceRequestsModel> ResourceRequestsList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void sendInventoryReqOnClick(ActionEvent actionEvent) {
        if(refugeeIDTextField.getText().isEmpty()||quantityTextField.getText().isEmpty()||reasonTextField.getText().isEmpty()||requestTypeComboBox.getValue()==null) {
            ResourcesInventoryMsgLabel.setText("Please fill in all details to send a request");
            return;
        }
        for(ResourceRequestsModel rsm : ResourceRequestsList) {
            if (rsm.getRequestType().equals(requestTypeComboBox.getValue())) {
                ResourcesInventoryMsgLabel.setText("You have already requested for this item.");
                return;
            }
        }
        String refugeeID = refugeeIDTextField.getText().trim();
        if(!refugeeID.equals(LoggedInRefModel.getLoggedInRefugeeId())){
            ResourcesInventoryMsgLabel.setText("Please enter your own refugee ID!");
            return;
        }
        String requestType = requestTypeComboBox.getValue();
        String quantity = quantityTextField.getText().trim();
        String reason = reasonTextField.getText().trim();
        String status = "Pending";

        ResourceRequestsModel resourceRequestsModel = new ResourceRequestsModel(refugeeID, requestType,quantity, reason, status);
        for(ResourceRequestsModel RSM : ResourceRequestsList) {
            if(RSM.getRefugeeID().equals(refugeeID) && RSM.getRequestType().equals("Shirt")||RSM.getRequestType().equals( "Jacket")||RSM.getRequestType().equals("Blanket")||RSM.getRequestType().equals("Shawl")||RSM.getRequestType().equals("Female Attire")||RSM.getRequestType().equals("Male Attire")||RSM.getRequestType().equals("Children Attire")||RSM.getRequestType().equals("Extra Food")||RSM.getRequestType().equals("Medicine")) {
                ResourcesInventoryMsgLabel.setText("You have already made a request.");
                return;
            }
        }
        ResourceRequestsList.add(resourceRequestsModel);
        ResourcesInventoryMsgLabel.setText("Request successfully sent to authorities!");

    }

    @javafx.fxml.FXML
    public void backtoDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Refugee/RefugeeDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Refugee Dashboard");
        stage.show();
    }
}
