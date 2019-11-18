package moviedatabase.movies.Controllers;

import moviedatabase.movies.Models.User;
import moviedatabase.movies.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Controller
public class LoginController {

    private final Logger log = Logger.getLogger(Logger.class.getName());

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String login(Model model) {
        log.info("Kører Controller-metoden 'login'. ("+getClass()+")");
        User user = new User();
        model.addAttribute(user);
        log.info("'login' metoden korrekt udført. ("+getClass()+")");
        return "loginPage";
    }

    @PostMapping("/")
    public String checkLogin(@ModelAttribute User user, Model model) {
        log.info("Kører Controller-metoden 'checkLogin'. ("+getClass()+")");
        User current = userService.checkLogin(user.getUserName(),user.getPassWord());
        if (current != null) {
            model.addAttribute(current);
            log.info("'checkLogin' metoden korrekt udført. Log-ind GODKENDT. ("+getClass()+")");
            return "redirect:/home/"+current.getId();
        } else {
            log.info("'checkLogin' metoden korrekt udført. Log-ind AFVIST.("+getClass()+")");
            return "redirect:/";
        }
    }

    @GetMapping("/forgot")
    public String forgot() {
        return "forgot";
    }
}
