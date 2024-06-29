package ndgroups.mbrailway.controller;

import ndgroups.mbrailway.model.Reservation;
import ndgroups.mbrailway.model.Ticket;
import ndgroups.mbrailway.model.User;
import ndgroups.mbrailway.service.ReservationService;
import ndgroups.mbrailway.service.TicketService;
import ndgroups.mbrailway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/test")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public String getAdminDashboard(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        List<User>users  =  userService.getAllUsers();
        List<Ticket>tickets  = ticketService.getUsersTickets();
        model.addAttribute("reservations", reservations);
        model.addAttribute("users", users);
        model.addAttribute("tickets", tickets);
        return "admin/adminDashboard";
    }
    @GetMapping("/reservations/add")
    public String addReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "admin/addReservation";
    }

    @PostMapping("/reservations/add")
    public String addReservation(@ModelAttribute Reservation reservation) {
        reservationService.createReservation(reservation);
        return "redirect:/test";
    }
    @GetMapping("/reservation/edit/{id}")
    public String editReservationForm(@PathVariable Integer id, Model model) {
        Reservation reservation  = reservationService.getOneReservation(id);
        model.addAttribute("reservation", reservation);
        return "admin/editReservation";
    }
    @PostMapping("/reservation/edit/{id}")
    public String editReservation(@PathVariable Integer id, @ModelAttribute Reservation reservation) {
        reservationService.updateReservation(id, reservation);
        return "redirect:/test";
    }
    @GetMapping("/reservation/delete/{id}")
    public String deleteJourney(@PathVariable Integer id, Model model) {
        reservationService.deleteReservation(id);
        return "redirect:/test";
    }
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/users";
    }
    @GetMapping("/tickets")
    public String viewTickets(Model model) {
        List<Ticket> tickets = ticketService.getUsersTickets();
        model.addAttribute("tickets", tickets);
        return "admin/tickets";
    }
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }


}
