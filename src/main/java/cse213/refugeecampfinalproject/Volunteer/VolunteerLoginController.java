package cse213.refugeecampfinalproject.Volunteer;

import cse213.refugeecampfinalproject.Refugee.LoggedInRefModel;
import cse213.refugeecampfinalproject.Refugee.Refugee;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static cse213.refugeecampfinalproject.Volunteer.VolunteerSignupController.VolunteerList;

public class VolunteerLoginController
{
    @javafx.fxml.FXML
    private PasswordField volPasscodeField;
    @javafx.fxml.FXML
    private TextField volIDTextField;

    @javafx.fxml.FXML
    public void initialize() {
        if (VolunteerList.isEmpty()) {
            VolunteerList.add(new VolunteerModel("V01", "Mahmud", "nursing, fluency in Arabic", "Healthcare", true));
            VolunteerList.add(new VolunteerModel("V02", "Mita", "first-aid, teaching", "Education", true));
        }
    }

    @javafx.fxml.FXML
    public void loginVolunteerOnClick(ActionEvent actionEvent) throws IOException {
        for (VolunteerModel volunteer : VolunteerList) {
            if (volunteer.getVolID().equals(volIDTextField.getText().trim()) & volPasscodeField.getText().equals("User5")) {
                LoggedInVolModel.setLoggedInVolID(volunteer.getVolID());
                Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/Volunteer/VolunteerDashboard.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("Volunteer Dashboard");
                stage.show();
                return;
            }
        }
    }
}