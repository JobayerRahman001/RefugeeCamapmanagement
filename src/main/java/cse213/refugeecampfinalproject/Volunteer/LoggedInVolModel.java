package cse213.refugeecampfinalproject.Volunteer;

public class LoggedInVolModel {
    public static String LoggedInVolID;

    public static void setLoggedInVolID(String id) {
        LoggedInVolID = id;
    }

    public static String getLoggedInVolID() {
        return LoggedInVolID;
    }

    public static void clear() {
        LoggedInVolID = null;
    }

}
