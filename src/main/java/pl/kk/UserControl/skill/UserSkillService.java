package pl.kk.UserControl.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.kk.UserControl.quote.Quote;
import pl.kk.UserControl.quote.QuoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSkillService {

    private final UserSkillRepository userSkillRepository;

    public String showSkills(Model model) {
        List<UserSkill> userSkillsList = userSkillRepository.findAll();
        model.addAttribute("userSkillsList", userSkillsList);
        return "user_skills";
    }
}
