package moviedatabase.movies.Controllers;

import moviedatabase.movies.Models.User;
import moviedatabase.movies.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public String users(Model model, @PathVariable int id) {
        User current = userService.findById(id);
        model.addAttribute("currentUser",current);
        model.addAttribute(userService.getUserList());
        return "userList";
    }

    @GetMapping("/users/newUser")
    public String newUser(Model model) {
        User newUser = new User();
        model.addAttribute(newUser);
        return "newUser";
    }

    @PostMapping("/users/newUser")
    public String createUser(@ModelAttribute User newUser) {
        userService.addNewUser(newUser.getFirstName(), newUser.getLastName(), newUser.getUserName(), newUser.getPassWord(),false);
        return "redirect:/";
    }

    @GetMapping("/users/editUser/{editId}/{currentId}")
    public String editUser(@PathVariable int editId, @PathVariable int currentId, Model model) {
        User editingUser = userService.findById(editId);
        User current = userService.findById(currentId);
        model.addAttribute("editingUser", editingUser);
        model.addAttribute("currentUser", current);
        return "editUser";
    }

    @PostMapping("/users/editUser/{currentId}")
    public String updateUser(@ModelAttribute User editingUser,@PathVariable int currentId, Model model) {
        User current = userService.findById(currentId);
        model.addAttribute("currentUser",current);
        userService.editUser(userService.findById(editingUser.getId()), editingUser.getFirstName(), editingUser.getLastName(), editingUser.getUserName(), editingUser.getPassWord(), editingUser.isAdmin());
        return "redirect:/users/{currentId}";
    }

    @GetMapping("/users/deleteUser/{editId}/{currentId}")
    public String deleteRequest(@PathVariable int editId, @PathVariable int currentId, Model model) {
        User editingUser= userService.findById(editId);
        model.addAttribute("editingUser",editingUser);
        User currentUser = userService.findById(currentId);
        model.addAttribute("currentUser", currentUser);
        return "deleteUser";
    }

    @PostMapping("/users/deleteUser/{currentId}")
    public String deleteUser(@ModelAttribute User editingUser, @PathVariable int currentId, Model model) {
        User current = userService.findById(currentId);
        model.addAttribute("currentUser", current);
        userService.deleteUser(userService.findById(editingUser.getId()));
        return "redirect:/users/{currentId}";

    }
}
