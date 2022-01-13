package pl.kk.UserControl.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kk.UserControl.quote.Quote;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {


}
