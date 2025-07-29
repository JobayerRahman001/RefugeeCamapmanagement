package cse213.refugeecampfinalproject;

public class LoginModel {
    private String userType;
    private String passcode;

    public LoginModel(String userType, String passcode) {
        this.userType = userType;
        this.passcode = passcode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "userType='" + userType + '\'' +
                ", passcode='" + passcode + '\'' +
                '}';
    }
}
