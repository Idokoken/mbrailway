package ndgroups.mbrailway.controller;

import ndgroups.mbrailway.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
//@CrossOrigin("*")
public class AdminController {
    @Autowired
//    private UserService userService;

    @GetMapping("/home")
    public String getAdminDashboard() {
        return "admin/adminDashboard";
    }
    @GetMapping("/login")
    public String getAdminLogin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/adminlogin";
    }
    @PostMapping("/login")
    public String saveAdmin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/adminlogin";
    }

    @RequestMapping("/delete/{id}")
    public String delUser(@PathVariable Integer id, Model model) {
        model.addAttribute("message", "student successfully deleted");
        return "redirect:/admin";
    }
}
