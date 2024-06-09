package ndgroups.mbrailway.controller;

import ndgroups.mbrailway.model.Reservation;
//import ndgroups.mbrailway.service.UserService;
import ndgroups.mbrailway.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
//@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @PostMapping("/reserved")
    public String filterReservedSeats(@ModelAttribute("reservation") Reservation reservation, Model model){
        return "";
    }

    @GetMapping("/search-result")
    public String ReservationPage(@RequestParam("origin") String origin,
                                  @RequestParam("destination") String destination,
                                  @RequestParam("filterDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                      LocalDate filterDate,
                                  @RequestParam("passengers") Integer passengers, Model model) {
        List<Reservation> reservations = reservationService.searchReservations(origin, destination, filterDate,
                passengers);
        model.addAttribute("reservations", reservations);
        return "pages/search-result";
//        return "";
    }

//    @GetMapping("/search")
//    public String filterReserved(){
//        return "pages/search-result";
//    }
}

