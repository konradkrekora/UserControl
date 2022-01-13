package pl.kk.UserControl.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public String signUpUser(User user) {
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if (userExists) {
            throw new IllegalStateException("User already exist");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "it works";
    }






    public User getOneUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("Not fount"));
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
