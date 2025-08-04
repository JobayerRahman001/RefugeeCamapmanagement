package cse213.refugeecampfinalproject.Refugee;

public class Refugee {

    private String id;
    private String refName;
    private String passcode;
    private int refAge;
    private String refGender;
    private String refFamSize;
    private String refNationality;

    public Refugee(String id, String refName, String passcode, int refAge, String refGender, String refFamSize, String refNationality) {
        this.id = id;
        this.refName = refName;
        this.passcode = passcode;
        this.refAge = refAge;
        this.refGender = refGender;
        this.refFamSize = refFamSize;
        this.refNationality = refNationality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public int getRefAge() {
        return refAge;
    }

    public void setRefAge(int refAge) {
        this.refAge = refAge;
    }

    public String getRefGender() {
        return refGender;
    }

    public void setRefGender(String refGender) {
        this.refGender = refGender;
    }

    public String getRefFamSize() {
        return refFamSize;
    }

    public void setRefFamSize(String refFamSize) {
        this.refFamSize = refFamSize;
    }

    public String getRefNationality() {
        return refNationality;
    }

    public void setRefNationality(String refNationality) {
        this.refNationality = refNationality;
    }

    @Override
    public String toString() {
        return "Refugee{" +
                "id='" + id + '\'' +
                ", refName='" + refName + '\'' +
                ", passcode='" + passcode + '\'' +
                ", refAge=" + refAge +
                ", refGender='" + refGender + '\'' +
                ", refFamSize='" + refFamSize + '\'' +
                ", refNationality='" + refNationality + '\'' +
                '}';
    }
}