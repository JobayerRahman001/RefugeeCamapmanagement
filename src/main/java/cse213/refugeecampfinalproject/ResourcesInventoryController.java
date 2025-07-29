package cse213.refugeecampfinalproject;

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
    private ComboBox<String> clothingTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        clothingTypeComboBox.getItems().addAll("Shirt", "Jacket", "Blanket", "Shawl", "Female Attire", "Male Attire", "Childrens Attire");
    }

public static ArrayList<ResourcesInventoryModel>ResourcesInventoryList = new ArrayList<>();

    @javafx.fxml.FXML
    public void sendInventoryReqOnClick(ActionEvent actionEvent) {
        if(quantityTextField.getText().isEmpty()||reasonTextField.getText().isEmpty()||clothingTypeComboBox.getValue()==null) {
            ResourcesInventoryMsgLabel.setText("Please fill in all details to send a request");
            return;
        }
        for(ResourcesInventoryModel rsm : ResourcesInventoryList) {
            if (rsm.getClothingType().equals(clothingTypeComboBox.getValue())) {
                ResourcesInventoryMsgLabel.setText("You have already requested for this item.");
                return;
            }
        }
        String clothingType = clothingTypeComboBox.getValue();
        int quantity = Integer.parseInt(quantityTextField.getText().trim());
        String reason = reasonTextField.getText().trim();

        ResourcesInventoryModel rsm = new ResourcesInventoryModel(clothingType, quantity, reason);

        ResourcesInventoryList.add(rsm);
        ResourcesInventoryMsgLabel.setText("Request successfully sent to authorities!");
    }

    @javafx.fxml.FXML
    public void backtoDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/RefugeeDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Refugee Dashboard");
        stage.show();
    }
}