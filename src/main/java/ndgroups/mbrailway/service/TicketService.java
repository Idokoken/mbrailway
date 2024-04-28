package ndgroups.mbrailway.service;

import jakarta.persistence.EntityNotFoundException;
import ndgroups.mbrailway.model.Reservation;
import ndgroups.mbrailway.model.Ticket;
import ndgroups.mbrailway.model.User;
import ndgroups.mbrailway.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket getTicketById(Integer id) {
        return ticketRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

//    public List<Ticket> getUserTickets(User user) {
//        return ticketRepository.findByUser(user);
//    }

    public Ticket bookTicket(User user, Reservation reservation) {
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setReservation(reservation);
//        ticket.setBookingTime(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public void cancelTicket(Integer id) {
        if (!ticketRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        ticketRepository.deleteById(id);
    }
}
