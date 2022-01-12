package pl.kk.UserControl.skill;

import lombok.*;
import pl.kk.UserControl.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(name = "skill_name", nullable = false, length = 45)
    private String skillName;

    @Column(name = "skill_level", nullable = false, length = 45)
    private String skillLevel;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_skills", joinColumns = @JoinColumn(name = "skill_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

}
