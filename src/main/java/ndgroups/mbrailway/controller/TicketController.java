package ndgroups.mbrailway.controller;

import ndgroups.mbrailway.model.Reservation;
import ndgroups.mbrailway.model.Ticket;
import ndgroups.mbrailway.model.User;
import ndgroups.mbrailway.service.ReservationService;
import ndgroups.mbrailway.service.TicketService;
import ndgroups.mbrailway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationService reservationService;

//    @GetMapping("/user/{userId}")
//    public List<Ticket> getUserTickets(@PathVariable Integer userId) {
//        // Retrieve user by ID (authentication required)
//        User user = userService.getOneUser(userId);
//        return ticketService.getUserTickets(user);
//    }

    @PostMapping("/book")
    public Ticket bookTicket(@ModelAttribute Ticket ticket) {
        // Retrieve user by ID (authentication required)
        User user = userService.getOneUser(ticket.getId());
        // Retrieve train journey by ID
        Reservation reservation = reservationService.getReservationById(ticket.getId());
        return ticketService.bookTicket(user, reservation);
    }

    @DeleteMapping("/{ticketId}")
    public void cancelTicket(@PathVariable Integer ticketId) {
        ticketService.cancelTicket(ticketId);
    }
}
