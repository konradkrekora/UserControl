package pl.kk.UserControl.quote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.kk.UserControl.user.User;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {

}
