package cse213.refugeecampfinalproject.Refugee;

public class LoggedInRefModel {
    public static String loggedInRefugeeId;

    public static void setLoggedInRefugeeId(String id) {
        loggedInRefugeeId = id;
    }

    public static String getLoggedInRefugeeId() {
        return loggedInRefugeeId;
    }

    public static void clear() {
        loggedInRefugeeId = null;
    }
}
