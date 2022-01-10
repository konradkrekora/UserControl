package pl.kk.UserControl.quote;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.kk.UserControl.user.CustomUserDetails;
import pl.kk.UserControl.user.User;
import pl.kk.UserControl.user.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public String processAddQuote(Quote quote) {
        quoteRepository.save(quote);
        return "add_quote_success";
    }

    public String showQuotes(Model model) {
        List<Quote> quotesList = quoteRepository.findAll();
        model.addAttribute("quotesList", quotesList);
        return "quotes";
    }

        public String showAddQuoteForm(Model model) {
            model.addAttribute("quote", new Quote());
            return "add_quote_form";
    }
}
