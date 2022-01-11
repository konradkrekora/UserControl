package pl.kk.UserControl.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import pl.kk.UserControl.models.UserSkillDTO;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    @Query("SELECT u from User u where u.email = ?1")
    User findByEmail(String email);

    @Query(value = """
        Select new pl.kk.UserControl.models.UserSkillDTO(u.email, s.skillName, s.skillLevel) from User u 
        left join UserSkill us on u.id = us.userId
        left join Skill s on us.skillId = s.id
        """)
    List<UserSkillDTO>  getUsersSkills();
}
