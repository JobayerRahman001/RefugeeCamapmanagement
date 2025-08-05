module cse213.refugeecampfinalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens cse213.refugeecampfinalproject to javafx.fxml;
    exports cse213.refugeecampfinalproject;
    exports cse213.refugeecampfinalproject.RefugeeandAdmin;
    opens cse213.refugeecampfinalproject.RefugeeandAdmin to javafx.fxml;
    exports cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
    opens cse213.refugeecampfinalproject.DoctorAndEducationCoordinator to javafx.fxml;
}