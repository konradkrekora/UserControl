package pl.kk.UserControl.skill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.InsufficientResourcesException;
import javax.persistence.*;

@Entity
@Table(name = "skills")
@SecondaryTable(name = "user_skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "skill_name", nullable = false, length = 45)
    private String skillName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(table = "user_skills", name = "skill_id")
    private UserSkill skill;

}
