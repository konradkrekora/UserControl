package pl.kk.UserControl.skill;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_skills")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "skill_id")
    private long skillId;

}
