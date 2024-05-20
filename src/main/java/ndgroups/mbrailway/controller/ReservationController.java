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
//@RequestMapping("/reservations")
public class ReservationController {

    @PostMapping("/reserved")
    public String filterReservedSeats(@ModelAttribute("reservation") Reservation reservation, Model model){
        return "";
    }

    @GetMapping("/search-result")
    public String ReservationPage(){
        return "pages/search-result";
    }
}

