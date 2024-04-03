package ndgroups.mbrailway.repository;

import ndgroups.mbrailway.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
