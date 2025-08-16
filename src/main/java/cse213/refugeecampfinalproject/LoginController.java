package cse213.refugeecampfinalproject;

import cse213.refugeecampfinalproject.Refugee.LoggedInRefModel;
import cse213.refugeecampfinalproject.Refugee.Refugee;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static cse213.refugeecampfinalproject.Refugee.RefugeeRegisterController.RefugeeList;

public class LoginController {
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML
    private PasswordField passcode;
    @javafx.fxml.FXML
    private Label loginMsgLabel;

    //dummy refugee list


    @javafx.fxml.FXML
    public void initialize() {
        //ComboBox
        userTypeComboBox.getItems().addAll("Refugee", "Camp Admin", "Doctor", "Educator", "Resources Manager", "Accountant and Logistics Coordinator", "UN Representative");
        if (RefugeeList.isEmpty()) {
            RefugeeList.add(new Refugee("R01", "Ali Khan", "1234", 35, "Male", "5", "Bangladeshi"));
            RefugeeList.add(new Refugee("R02", "Sara Noor", "5678", 28, "Female", "4", "Rohingya"));
        }
    }

    @javafx.fxml.FXML
    public void loginOnClick(ActionEvent actionEvent) throws IOException {
        String selectedUser = userTypeComboBox.getValue();
        String enteredPasscode = passcode.getText().trim();

        if (selectedUser == null || enteredPasscode.isEmpty()) {
            loginMsgLabel.setText("Please select user type and enter your passcode");
            return;
        }

        if (selectedUser.equals("Refugee")) {
            boolean found = false;
            for (Refugee r : RefugeeList) {
                if (r.getPasscode().equals(enteredPasscode)) {
                    LoggedInRefModel.setLoggedInRefugeeId(r.getId());
                    Parent dashboard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Refugee/RefugeeDashboard.fxml")));
                    Stage stage = (Stage) userTypeComboBox.getScene().getWindow();
                    stage.setScene(new Scene(dashboard));
                    stage.setTitle("Refugee Dashboard");
                    stage.show();
                    found = true;
                    break;
                }
            }
            if (!found) {
                loginMsgLabel.setText("Invalid refugee passcode.");
            }
        }
        else if (selectedUser.equals("Camp Admin")) {
            if (enteredPasscode.equals("User2")) {
                Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Admin/AdminDashboard.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("Admin Dashboard");
                stage.show();
            } else {
                loginMsgLabel.setText("Invalid passcode for Camp Admin.");
            }
        }
        else if (selectedUser.equals("Doctor")) {
            if (enteredPasscode.equals("User3")) {
                Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Doctor/HealthPortal.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("Doctor Dashboard");
                stage.show();
            } else {
                loginMsgLabel.setText("Invalid passcode for Doctor.");
            }
        }
        else if (selectedUser.equals("Educator")) {
            if (enteredPasscode.equals("User4")) {
                Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Educator/EducationPanel.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("Education Panel");
                stage.show();
            } else {
                loginMsgLabel.setText("Invalid passcode for Educator.");
            }
        }
        else if (selectedUser.equals("Resources Manager")) {
            if (enteredPasscode.equals("User6")) {
                Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/ResourceManager/ResourcesDashboard.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("Resources Dashboard");
                stage.show();
            } else {
                loginMsgLabel.setText("Invalid passcode for Resources Manager.");
            }
        }
        else if (selectedUser.equals("Accountant and Logistics Coordinator")) {
            if (enteredPasscode.equals("User7")) {
                Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/AccountantAndLogistics/AccountantAndLogisticsDashboard.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("Accountant and Logistics Coordinator Dashboard");
                stage.show();
            } else {
                loginMsgLabel.setText("Invalid passcode for Accountant and Logistics Coordinator.");
            }
        }
        else if (selectedUser.equals("UN Representative")) {
            if (enteredPasscode.equals("User8")) {
                Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/UNHCR/UNRepDashboard.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("UN Rep Dashboard");
                stage.show();
            } else {
                loginMsgLabel.setText("Invalid passcode for UN Representative.");
            }
        }
        else {
            loginMsgLabel.setText("Invalid user type.");
        }
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homepage.fxml")));
        Stage stage = (Stage) userTypeComboBox.getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Home");
        stage.show();
    }
}