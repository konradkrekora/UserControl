package pl.kk.UserControl.skill;

import javax.persistence.*;

@Entity
@Table(name = "user_skills")
public class UserSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public UserSkill() {

    }

    public UserSkill(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserSkill{" +
                "id=" + id +
                '}';
    }
}
