package cse213.refugeecampfinalproject.Refugee;

public class RefugeeSkillsModel {
    private String skills;
    private String previousJob;
    private String certificates;
    //
    private String matchedPrograms;
    private String requiredSkills;

    public RefugeeSkillsModel(String skills, String previousJob, String certificates, String matchedPrograms, String requiredSkills) {
        this.skills = skills;
        this.previousJob = previousJob;
        this.certificates = certificates;
        this.matchedPrograms = matchedPrograms;
        this.requiredSkills = requiredSkills;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getPreviousJob() {
        return previousJob;
    }

    public void setPreviousJob(String previousJob) {
        this.previousJob = previousJob;
    }

    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates;
    }

    public String getMatchedPrograms() {
        return matchedPrograms;
    }

    public void setMatchedPrograms(String matchedPrograms) {
        this.matchedPrograms = matchedPrograms;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    @Override
    public String toString() {
        return "RefugeeSkillsModel{" +
                "skills='" + skills + '\'' +
                ", previousJob='" + previousJob + '\'' +
                ", certificates='" + certificates + '\'' +
                ", matchedPrograms='" + matchedPrograms + '\'' +
                ", requiredSkills='" + requiredSkills + '\'' +
                '}';
    }
}
