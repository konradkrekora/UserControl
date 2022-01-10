package pl.kk.UserControl.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    @Query("SELECT u from User u where u.email = ?1")
    User findByEmail(String email);
}
