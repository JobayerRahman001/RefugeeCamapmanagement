package cse213.refugeecampfinalproject.Volunteer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class VolunteerWorkLogsController
{

    @javafx.fxml.FXML
    private TextField VolNameTextField;
    @javafx.fxml.FXML
    private Label VolWorkMsgLabel;
    @javafx.fxml.FXML
    private TextField TaskCompleteTextField;
    @javafx.fxml.FXML
    private ComboBox<String> ServiceAreaComboBox;
    @javafx.fxml.FXML
    private TextField VolIDTextField;
    @javafx.fxml.FXML
    private TextField VolSkillsTextField;

    public static ArrayList<VolunteerWorkLogsModel> VolunteerWorkLogsList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        ServiceAreaComboBox.getItems().addAll( "Food", "Healthcare", "Education", "Inventory Management");
    }

    @javafx.fxml.FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Volunteer/VolunteerDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Volunteer Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void submitWorkLogOnClick(ActionEvent actionEvent) {
        if(VolIDTextField.getText()==null || VolNameTextField.getText()==null || VolSkillsTextField.getText()==null || ServiceAreaComboBox.getValue()==null || TaskCompleteTextField.getText()==null) {
            VolWorkMsgLabel.setText("PLease enter all details");
            return;
        }

        String volID = VolIDTextField.getText().trim();
        String ServiceArea = ServiceAreaComboBox.getValue();
        String tasks = TaskCompleteTextField.getText().trim();
        String skills = VolSkillsTextField.getText().trim();

        VolunteerWorkLogsModel vwlm = new VolunteerWorkLogsModel(volID,ServiceArea, tasks, skills);

        VolunteerWorkLogsList.add(vwlm);
        VolWorkMsgLabel.setText("Success");
    }
}
