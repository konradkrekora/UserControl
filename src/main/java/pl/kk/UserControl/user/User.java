package pl.kk.UserControl.user;

import lombok.*;
import pl.kk.UserControl.skill.UserSkill;

import javax.persistence.*;

@Entity
@Table(name = "users")
@SecondaryTable(name = "user_skills")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(nullable = false, length = 45)
    private String firstName;

    @Column(nullable = false, length = 45)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(table = "user_skills", name = "user_id")
    private UserSkill userId;

}
