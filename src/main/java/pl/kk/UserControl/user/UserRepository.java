package pl.kk.UserControl.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kk.UserControl.models.UserSkillDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> findByEmail(String email);

    //kk...model(users.name, skills.skill_level, skills.skill_name) from user skills join left user where user_skills.user_id = users.id  left join skills on skills.id = user_skills.skill_id
    @Query(value = """
        Select new pl.kk.UserControl.models.UserSkillDTO(u.email, s.skillName, s.skillLevel) from User u 
        left join UserSkill us on u.id = us.userId
        left join Skill s on us.skillId = s.id
        """)
    List<UserSkillDTO>  getUsersSkills();
}
