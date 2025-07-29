package cse213.refugeecampfinalproject;

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

public class VolunteerSignupController
{
    @javafx.fxml.FXML
    private TextField volNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> volServiceAreaComboBox;
    @javafx.fxml.FXML
    private TextField volSkillsTextField;
    @javafx.fxml.FXML
    private Label volMsglabel;
    @javafx.fxml.FXML
    private CheckBox volAvailabilityCheckBox;

    @javafx.fxml.FXML
    public void initialize() {

        volServiceAreaComboBox.getItems().addAll( "Food", "Health", "Education", "Inventory Management");
    }
    ArrayList<VolunteerModel> VolunteerList = new ArrayList<>();

    @javafx.fxml.FXML
    public void volSignupOnClick(ActionEvent actionEvent) throws IOException {
        if(volNameTextField.getText().trim().isEmpty()||volSkillsTextField.getText().trim().isEmpty()||volServiceAreaComboBox.getValue()==null) {
            volMsglabel.setText( "Please fill in all the details");
            return;
        }

        String volName = volNameTextField.getText().trim();
        String volSkills = volSkillsTextField.getText().trim();
        String volselectedServiceAreaComboBox = volServiceAreaComboBox.getValue();
        boolean volisAvailable = volAvailabilityCheckBox.isSelected();

        VolunteerModel vl = new VolunteerModel(volName, volSkills, volselectedServiceAreaComboBox, volisAvailable);

        VolunteerList.add(vl);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thank you for signing in as Volunteer");
        alert.setHeaderText("New Volunteer");
        alert.setContentText("Your passcode is 'User5'");
        alert.showAndWait();


        Parent root = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/VolunteerDashboard.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Volunteer Dashboard");
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