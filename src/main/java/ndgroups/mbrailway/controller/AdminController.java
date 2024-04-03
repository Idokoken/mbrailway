package ndgroups.mbrailway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
//    private UserService userService;

    @GetMapping
    public String getAdminDashboard() {
        return "admin/adminDashboard";
    }

    @RequestMapping("/delete/{id}")
    public String delUser(@PathVariable Integer id, Model model) {
        model.addAttribute("message", "student successfully deleted");
        return "redirect:/admin";
    }
}
