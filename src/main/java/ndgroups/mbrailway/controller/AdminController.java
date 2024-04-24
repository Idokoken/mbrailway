package ndgroups.mbrailway.controller;

import ndgroups.mbrailway.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/home")
    public String getAdminDashboard() {
        return "admin/adminDashboard";
    }
    @GetMapping("/profile")
    public String getAdminProfile(){
        return "admin/adminProfile";
    }
//    @GetMapping("/profile")
//    public String getAdminProfile(Model model, Principal principal){
//        UserDetails userDetails = customUserDetailsService.loadUserByUsername(principal.getName());
//        model.addAttribute("user", userDetails);
//        return "admin/adminProfile";
//    }

    @RequestMapping("/delete/{id}")
    public String delUser(@PathVariable Integer id, Model model) {
        model.addAttribute("message", "student successfully deleted");
        return "redirect:/admin";
    }
}
