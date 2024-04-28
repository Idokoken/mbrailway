package ndgroups.mbrailway.controller;

import ndgroups.mbrailway.model.User;
import ndgroups.mbrailway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//    @GetMapping("/profile")
//    public String getUserProfile(Model model, Principal principal) {
//        UserDetails userDetails = customUserDetailsService.loadUserByUsername(principal.getName());
//        model.addAttribute("user", userDetails);
//        return "user/userProfile";
//    }
//
//    @GetMapping("/{id}")
//    public String getOneUser(@PathVariable Integer id, Model model, Principal principal) {
//        User user = userService.getOneUser(id);
//        UserDetails userDetails = customUserDetailsService.loadUserByUsername(principal.getName());
//        model.addAttribute("user", user);
//        return "user/userProfile";
//    }

    @GetMapping("/profile")
    public String getUserProfile() {
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
