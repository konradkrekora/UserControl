package pl.kk.UserControl.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
//kk...model(users.name, skills.skill_level, skills.skill_name) from user skills join left user where user_skills.user_id = users.id  left join skills on skills.id = user_skills.skill_id

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public User getOneUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("Not fount"));
    }

    public String processRegistration(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "registration_success";
    }

    public String showUsers(Model model) {
        List<User> usersList = userRepository.findAll();
        model.addAttribute("usersList", usersList);
        return "users";
    }

    public String showUserPanel() {
        return "user_panel";
    }

    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "registration_form";
    }

    public String showHomePage() {
        return "index";
    }


}
