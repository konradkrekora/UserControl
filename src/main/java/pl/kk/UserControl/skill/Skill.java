package pl.kk.UserControl.skill;

import javax.persistence.*;

@Entity
@Table(name = "skills")
@SecondaryTable(name="user_skills", pkJoinColumns = @PrimaryKeyJoinColumn(name = "skillId", referencedColumnName = "id"))
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String skillName;

    @Column(table = "user_skills", nullable = false, length = 45)
    private String skillLevel;

    public Skill() {

    }

    public Skill(Integer id, String skillName, String skillLevel) {
        this.id = id;
        this.skillName = skillName;
        this.skillLevel = skillLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillName='" + skillName + '\'' +
                ", skillLevel='" + skillLevel + '\'' +
                '}';
    }
}
