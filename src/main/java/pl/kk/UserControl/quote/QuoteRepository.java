package pl.kk.UserControl.quote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kk.UserControl.user.User;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

}
