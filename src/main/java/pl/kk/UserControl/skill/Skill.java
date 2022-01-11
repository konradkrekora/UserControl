package pl.kk.UserControl.skill;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "skills")
@SecondaryTable(name = "user_skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "skill_name", nullable = false, length = 45)
    private String skillName;

    @Column(name = "skill_level", nullable = false, length = 45)
    private String skillLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(table = "user_skills", name = "skill_id")
    private UserSkill skillId;

}
