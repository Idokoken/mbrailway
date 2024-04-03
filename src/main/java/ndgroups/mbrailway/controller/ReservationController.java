package ndgroups.mbrailway.controller;

import ndgroups.mbrailway.model.Reservation;
//import ndgroups.mbrailway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
//    private UserService userService;


    @GetMapping("/profile")
    public String getUserDashboard() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if(authentication.isAuthenticated()) {
//            String name  = authentication.getName();
//            model.addAttribute("name", name);
//            return "admin/user/userDashboard";
//        }
//        if(authentication.getPrincipal() instanceof UserDetails) {
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//            model.addAttribute("user", userDetails);
//            return "admin/userDashboard";
//        }
        return "pages/login";
    }
    @PostMapping("/reserved")
    public String filterReservedSeats(@ModelAttribute("reservation") Reservation reservation, Model model){
        return "";
    }

    @GetMapping("/train")
    public String ReservationPage(@PathVariable Integer id, Model model){
        return "";
    }
}

