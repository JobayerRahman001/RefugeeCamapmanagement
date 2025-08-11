module cse213.refugeecampfinalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens cse213.refugeecampfinalproject to javafx.fxml;
    exports cse213.refugeecampfinalproject;

    exports cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
    opens cse213.refugeecampfinalproject.DoctorAndEducationCoordinator to javafx.fxml,javafx.base;

    exports cse213.refugeecampfinalproject.Refugee;
    opens cse213.refugeecampfinalproject.Refugee to javafx.fxml,javafx.base;

    exports cse213.refugeecampfinalproject.Admin;
    opens cse213.refugeecampfinalproject.Admin to javafx.fxml,javafx.base;


    exports cse213.refugeecampfinalproject.Volunteer;
    opens cse213.refugeecampfinalproject.Volunteer to javafx.fxml,javafx.base;


    exports cse213.refugeecampfinalproject.ResourceManager;
    opens cse213.refugeecampfinalproject.ResourceManager to javafx.fxml,javafx.base;

    exports cse213.refugeecampfinalproject.AccountantAndLogistics;
    opens cse213.refugeecampfinalproject.AccountantAndLogistics to javafx.fxml,javafx.base;

    exports cse213.refugeecampfinalproject.UNHCR;
    opens cse213.refugeecampfinalproject.UNHCR to javafx.fxml,javafx.base;
}
