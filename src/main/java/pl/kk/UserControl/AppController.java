package pl.kk.UserControl;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kk.UserControl.quote.Quote;
import pl.kk.UserControl.quote.QuoteService;
import pl.kk.UserControl.skill.UserSkillService;
import pl.kk.UserControl.user.UserService;
import pl.kk.UserControl.user.User;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@RestController
@RequestMapping(value = "/api")
@CrossOrigin
@RequiredArgsConstructor
public class AppController {

    private final UserService userService;
    private final QuoteService quoteService;
    private final UserSkillService userSkillService;


    @ApiOperation(value = "Show Home Page", notes = "Shows home page")
    @GetMapping("/")
    public String showHomePage() {
        return userService.showHomePage();
    }

    @ApiOperation(value = "Show Register Form", notes = "Shows register form")
    @GetMapping(value = "/register")
    public String showRegisterForm(Model model) {
        return userService.showRegisterForm(model);
    }

    @ApiOperation(value = "Process Registration", notes = "Saves User in DB and shows successfull registration page")
    @PostMapping(value = "/process_register")
    public String processRegistration(User user) {
        return userService.signUpUser(user);
    }

    @ApiOperation(value = "Show User Panel", notes = "Shows user panel")
    @GetMapping(value = "/panel")
    public String showUserPanel() {
        return userService.showUserPanel();
    }

    @ApiOperation(value = "Show Users", notes = "Shows user list")
    @GetMapping(value = "/list_users")
    public String showUsers(Model model) {
        return userService.showUsers(model);
    }

    @ApiOperation(value = "Show Add Quote Form", notes = "Shows form to add quote")
    @GetMapping(value = "/add_quote")
    public String showAddQuoteForm(Model model) {
        return quoteService.showAddQuoteForm(model);
    }

    @ApiOperation(value = "Process Add Quote", notes = "Saves Quote in DB and shows successfull add quote page")
    @PostMapping(value = "/process_add_quote")
    public String processAddQuote(Quote quote) {
        return quoteService.processAddQuote(quote);
    }

    @ApiOperation(value = "Show Quotes", notes = "Shows Quotes list")
    @GetMapping(value = "/list_quotes")
    public String showQuotes(Model model) {
        return quoteService.showQuotes(model);
    }

    @ApiOperation(value = "Show Skills", notes = "Shows all users skills")
    @GetMapping(value = "/list_user_skills")
    public String showSkills(Model model) {
        return userSkillService.showSkills(model);
    }

    @ApiOperation(value = "Get one user")
    @GetMapping(value = "/get_one_user")
    public User getUser(Long id) {
        return userService.getOneUserById(id);
    }


}
