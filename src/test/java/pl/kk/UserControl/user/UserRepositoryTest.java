package pl.kk.UserControl.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    @DisplayName("Should return same user as given when user creation was successfull")
    public void testCreateUser() {
        //given
        User user = new User();
        user.setEmail("test2@test2.pl");
        user.setPassword("123123");
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        //when
        User savedUser = userRepository.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());
        //then
        assertEquals(savedUser.getEmail(), existUser.getEmail());
    }

    @Test
    @DisplayName("Should return same email as given when it's in database")
    public void testFindUserByEmail() {
        //given
        String email = "test@test.pl";
        //when
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        //then
        assertNotNull(user);
    }

    @Test
    @DisplayName("Should return null when it's not in database")
    public void testFindUserByEmail2() {
        //given
        String email = "different@email.pl";
        //when
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        //then
        assertNull(user);
    }

}