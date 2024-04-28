package ndgroups.mbrailway.repository;

import ndgroups.mbrailway.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
//    List<Ticket> findByUser(User user);
}
