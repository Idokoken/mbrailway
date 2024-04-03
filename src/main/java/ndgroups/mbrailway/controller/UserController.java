package ndgroups.mbrailway.controller;

import ndgroups.mbrailway.model.User;
import ndgroups.mbrailway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String getOneUser(@PathVariable Integer id, Model model) {
        User user = userService.getOneUser(id);
        model.addAttribute("user", user);
        return "user/userProfile";
    }

    @GetMapping("/edit/{id}")
    public String getUpdateUserPage(@PathVariable Integer id, Model model) {
        User getUser  = userService.getOneUser(id);
        model.addAttribute("user", getUser);
        return "user/edit";
    }
    @PostMapping("/{id}")
    public String updateUser(Model model, @PathVariable Integer id, @ModelAttribute("user") User
            updateUser)  {
        userService.updateUser(id, updateUser);
        return "redirect:/users/" + id;
    }


}
