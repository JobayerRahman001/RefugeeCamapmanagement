package cse213.refugeecampfinalproject;

public class ApplicationDataModel {
    private Refugee refugee; // Reference to the associated Refugee object
    private String selectedProgram;
    private String requestedTime;
    private String status;

    public ApplicationDataModel(Refugee refugee, String selectedProgram, String requestedTime, String status) {
        this.refugee = refugee;
        this.selectedProgram = selectedProgram;
        this.requestedTime = requestedTime;
        this.status = status;
    }

    public Refugee getRefugee() {
        return refugee;
    }

    public void setRefugee(Refugee refugee) {
        this.refugee = refugee;
    }

    public String getSelectedProgram() {
        return selectedProgram;
    }

    public void setSelectedProgram(String selectedProgram) {
        this.selectedProgram = selectedProgram;
    }

    public String getRequestedTime() {
        return requestedTime;
    }

    public void setRequestedTime(String requestedTime) {
        this.requestedTime = requestedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ApplicationDataModel{" +
                "refugee=" + refugee +
                ", selectedProgram='" + selectedProgram + '\'' +
                ", requestedTime='" + requestedTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
