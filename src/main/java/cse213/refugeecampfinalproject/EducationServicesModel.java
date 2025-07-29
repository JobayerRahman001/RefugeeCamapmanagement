package cse213.refugeecampfinalproject;

public class EducationServicesModel {
    private String age;
    private String programName;
    private String timing;

    public EducationServicesModel(String age, String programName, String timing) {
        this.age = age;
        this.programName = programName;
        this.timing = timing;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    @Override
    public String toString() {
        return "EducationServicesModel{" +
                "age='" + age + '\'' +
                ", programName='" + programName + '\'' +
                ", timing='" + timing + '\'' +
                '}';
    }
}
