package cse213.refugeecampfinalproject.Refugee;

import cse213.refugeecampfinalproject.Admin.RefugeeAllocationsAdminController;
import cse213.refugeecampfinalproject.Admin.RefugeeAllocationsAdminModel;
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
import java.util.ArrayList;
import java.util.Objects;

public class RefugeeRegisterController
{

    @javafx.fxml.FXML
    private TextField refNameTextField;
    @javafx.fxml.FXML
    private TextField refAgeTextField;
    @javafx.fxml.FXML
    private TextField refFamSizeTextField;
    @javafx.fxml.FXML
    private TextField refNationalityTextField;
    @javafx.fxml.FXML
    private ComboBox<String> refGenderComboBox;
    @javafx.fxml.FXML
    private Label refRegMsgLabel;
    @javafx.fxml.FXML
    private PasswordField refPasscodeField;

    @javafx.fxml.FXML
    public void initialize() {
        //ComboBox
        refGenderComboBox.getItems().addAll( "Male", "Female", "Prefer Not to say");
    }
public static ObservableList<Refugee> RefugeeList = FXCollections.observableArrayList();
public static ObservableList<RefugeeAllocationsAdminModel> allocationList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void registerAsRefOnClick(ActionEvent actionEvent) throws IOException{
        if(refNameTextField.getText().trim().isEmpty() ||refAgeTextField.getText().trim().isEmpty()|| refFamSizeTextField.getText().trim().isEmpty()|| refNationalityTextField.getText().trim().isEmpty()||refGenderComboBox.getValue()==null||refPasscodeField.getText().isEmpty()) {
            refRegMsgLabel.setText( "Please fill in all the details");
            return;
        }
        String refName = refNameTextField.getText().trim();
        int refAge = Integer.parseInt(refAgeTextField.getText().trim());
        String refGender = refGenderComboBox.getValue();
        String refFamSize = refFamSizeTextField.getText().trim();
        String refNationality = refNationalityTextField.getText().trim();
        String passcode = refPasscodeField.getText().trim();

        //Generation of unique ID and passcode for refugees at registration
        String id = "REF" + (RefugeeList.size()+1);


        Refugee r = new Refugee(id, refName, passcode, refAge, refGender, refFamSize, refNationality);

        RefugeeList.add(r);
        RefugeeAllocationsAdminModel newallocation = new RefugeeAllocationsAdminModel(id, "", "", "", "");
        RefugeeRegisterController.allocationList.clear();
        RefugeeRegisterController.allocationList.add(newallocation);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration Successful");
        alert.setHeaderText("Refugee Registered");
        alert.setContentText("Your ID is " + id);
        alert.showAndWait();


            Parent root = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/Refugee/RefugeeDashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Refugee Dashboard");
            stage.show();

    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/homepage.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Home");
        stage.show();
    }
}