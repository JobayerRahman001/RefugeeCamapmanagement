package cse213.refugeecampfinalproject;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class LoginController {
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML
    private PasswordField passcode;
    @javafx.fxml.FXML
    private Label loginMsgLabel;

    //dummy refugee list
    private final ArrayList<Refugee> registeredRefugees = new ArrayList<>();

    private static final HashMap<String, String> userPasscodes = new HashMap<>();

    static {
        // Static passcodes for fixed users
        userPasscodes.put("Camp Admin", "User2");
        userPasscodes.put("Doctor", "User3");
        userPasscodes.put("Educator", "User4");
        userPasscodes.put("Volunteer", "User5");
        userPasscodes.put("Resources Manager", "User6");
        userPasscodes.put("Accountant", "User7");
        userPasscodes.put("UN Representative", "User8");
    }


    @javafx.fxml.FXML
    public void initialize() {
        //ComboBox

        userTypeComboBox.getItems().addAll("Refugee", "Camp Admin", "Doctor", "Educator", "Volunteer", "Resources Manager", "Accountant and Logistics Coordinator", "UN Representative");
        registeredRefugees.add(new Refugee("R01", "Ali Khan", "1234", 35, "Male", "5", "Bangladeshi"));
        registeredRefugees.add(new Refugee("R02", "Sara Noor", "5678", 28, "Female", "4", "Rohingya"));
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
            for (Refugee r : registeredRefugees) {
                if (r.getPasscode().equals(enteredPasscode)) {
                    LoggedInRefModel.setLoggedInRefugeeId(r.getId());
                    Parent dashboard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Refugee/RefugeeDashboard.fxml")));
                    Stage stage = (Stage) userTypeComboBox.getScene().getWindow();
                    stage.setScene(new Scene(dashboard));
                    stage.setTitle("Refugee Dashboard");
                    stage.show();
                    return;
                }
            }
            loginMsgLabel.setText("Invalid refugee passcode.");
            return;
        }

        if (userPasscodes.containsKey(selectedUser) && userPasscodes.get(selectedUser).equals(enteredPasscode)) {
            if (selectedUser.equals("Camp Admin")) {
                Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Admin/AdminDashboard.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("Admin Dashboard");
                stage.show();
                return;
            }

            if (selectedUser.equals("Doctor")) {
                Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HealthPortal.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("Health Portal");
                stage.show();
                return;
            }

            if (selectedUser.equals("Educator")) {
                Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EducationPanel.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("Education Panel");
                stage.show();
                return;
            }

            if (selectedUser.equals("Volunteer")) {
                Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("VolunteerDashboard.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("Volunteer Dashboard");
                stage.show();
                return;
            }

            if (selectedUser.equals("Resources Manager")) {
                Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ResourcesDashboard.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("Resources Dashboard");
                stage.show();
                return;
            }

            if (selectedUser.equals("Accountant and Logistics Coordinator")) {
                Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FinanceDashboard.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("Finance Dashboard");
                stage.show();
                return;
            }

            if (selectedUser.equals("UN Representative")) {
                Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UNRepDashboard.fxml")));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(home));
                stage.setTitle("UN Rep Dashboard");
                stage.show();
            }
        } else {
            loginMsgLabel.setText("Invalid passcode or user type.");
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