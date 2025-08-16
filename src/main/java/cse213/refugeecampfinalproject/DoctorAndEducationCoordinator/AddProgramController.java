package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

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

public class AddProgramController
{
    @javafx.fxml.FXML
    private ComboBox<String> programtypecomboBox;
    @javafx.fxml.FXML
    private TextField durationTextField;
    @javafx.fxml.FXML
    private TextField agegroupTextField;
    @javafx.fxml.FXML
    private TextField programNameTextField;
    @javafx.fxml.FXML
    private Label displayMassegeLabel;
    @javafx.fxml.FXML
    private TextField studentcapacityTextField;

    ArrayList<EducationProgramModel> programList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        programtypecomboBox.getItems().addAll("Litarecy","Language","Vocational");
    }

    @javafx.fxml.FXML
    public void submitFormOnAction(ActionEvent actionEvent) {
        boolean flag = true;
        String programName = programNameTextField.getText();
        String programType = programtypecomboBox.getValue();
        String agegroup = agegroupTextField.getText();
        String duration = durationTextField.getText();
        int capacity = Integer.parseInt(studentcapacityTextField.getText());
        String capacitystr = Integer.toString(capacity);

        if (programName.isEmpty() && programType==null && agegroup.isBlank() && duration.isEmpty() && capacitystr.isBlank()){
            flag=false;
            displayMassegeLabel.setText("Please fill in all fields.");
            return;

        }
        for (EducationProgramModel educationProgramModel : programList){
            if (educationProgramModel.getProgramName().equalsIgnoreCase(programName) && educationProgramModel.getProgramType().equals(programType)){
                displayMassegeLabel.setText("Program already exists.");
                return;
            }
        }
        EducationProgramModel e = new EducationProgramModel(programName,programType,agegroup,duration,capacity);
        programList.add(e);
    }

    @javafx.fxml.FXML
    public void gobacktoEducationPanelOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/Educator/EducationPanel.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();
    }
}
