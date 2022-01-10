package pl.kk.UserControl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kk.UserControl.quote.Quote;
import pl.kk.UserControl.quote.QuoteRepository;
import pl.kk.UserControl.user.User;
import pl.kk.UserControl.user.UserRepository;

import java.util.List;

@Controller
public class AppController {

    private final UserRepository userRepository;
    private final QuoteRepository quoteRepository;

    public AppController(UserRepository userRepository, QuoteRepository quoteRepository) {

        this.userRepository = userRepository;
        this.quoteRepository = quoteRepository;
    }

    @GetMapping("")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "registration_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        return "registration_success";
    }

    @GetMapping("/panel")
    public String showUserPanel() {;
        return "user_panel";
    }

    @GetMapping("/list_users")
    public String showUsers(Model model) {
        List<User> usersList = userRepository.findAll();
        model.addAttribute("usersList", usersList);
        return "users";
    }

    @GetMapping("/add_quote")
    public String showAddQuoteForm(Model model) {
        model.addAttribute("quote", new Quote());
        return "add_quote_form";
    }

    @PostMapping("/process_add_quote")
    public String processAddQuote(Quote quote) {
        quoteRepository.save(quote);
        return "add_quote_success";
    }

    @GetMapping("/list_quotes")
    public String showQuotes(Model model) {
        List<Quote> quotesList = quoteRepository.findAll();
        model.addAttribute("quotesList", quotesList);
        return "quotes";
    }



}
