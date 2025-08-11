package cse213.refugeecampfinalproject.Volunteer;

public class VolunteerSkillsModel {
    private String skill;

    public VolunteerSkillsModel(String skill) {
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "VolunteerSkillsModel{" +
                "skill='" + skill + '\'' +
                '}';
    }
}
