package pl.kk.UserControl.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kk.UserControl.user.User;
import pl.kk.UserControl.user.UserRole;
import pl.kk.UserControl.user.UserService;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
            if (!emailValidator.test(request.getEmail())) {
                throw new IllegalStateException("email not valid");
            }
        return userService.signUpUser(User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .userRole(UserRole.USER)
                .enabled(Boolean.FALSE)
                .locked(Boolean.FALSE)
                .build());
    }
}
