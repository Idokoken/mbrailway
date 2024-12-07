package ndgroups.mbrailway.repository;

import ndgroups.mbrailway.model.Reservation;
import ndgroups.mbrailway.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation findBySeatNumber(Integer seatNumber);
    List<Reservation> findByTrain(Train train);
    Optional<Reservation> findByBookingConfirmationCode(String confirmationCode);
    List<Reservation>findByUserId(Integer userId);

}
