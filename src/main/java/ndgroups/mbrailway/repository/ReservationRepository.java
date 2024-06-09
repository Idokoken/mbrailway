package ndgroups.mbrailway.repository;

import ndgroups.mbrailway.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByOriginAndDestinationAndFilterDateAndAvailableSeats(
            String origin, String destination, LocalDate filterDate, Integer availableSeats );

}
