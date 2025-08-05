module cse213.refugeecampfinalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens cse213.refugeecampfinalproject to javafx.fxml;
    exports cse213.refugeecampfinalproject;
<<<<<<< HEAD
    exports cse213.refugeecampfinalproject.RefugeeandAdmin;
    opens cse213.refugeecampfinalproject.RefugeeandAdmin to javafx.fxml;
    exports cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
    opens cse213.refugeecampfinalproject.DoctorAndEducationCoordinator to javafx.fxml;
=======
    exports cse213.refugeecampfinalproject.Refugee;
    opens cse213.refugeecampfinalproject.Refugee to javafx.fxml;
    exports cse213.refugeecampfinalproject.Admin;
    opens cse213.refugeecampfinalproject.Admin to javafx.fxml;
    exports cse213.refugeecampfinalproject.Educator;
    opens cse213.refugeecampfinalproject.Educator to javafx.fxml;
    exports cse213.refugeecampfinalproject.Volunteer;
    opens cse213.refugeecampfinalproject.Volunteer to javafx.fxml;
    exports cse213.refugeecampfinalproject.Doctor;
    opens cse213.refugeecampfinalproject.Doctor to javafx.fxml;
    exports cse213.refugeecampfinalproject.ResourceManager;
    opens cse213.refugeecampfinalproject.ResourceManager to javafx.fxml;
    exports cse213.refugeecampfinalproject.AccountantAndLogistics;
    opens cse213.refugeecampfinalproject.AccountantAndLogistics to javafx.fxml;
    exports cse213.refugeecampfinalproject.UNHCR;
    opens cse213.refugeecampfinalproject.UNHCR to javafx.fxml;
>>>>>>> 3766be206684680eb274de4e03789a2b43595b2f
}