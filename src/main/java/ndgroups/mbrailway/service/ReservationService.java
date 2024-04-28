package ndgroups.mbrailway.service;

import jakarta.persistence.EntityNotFoundException;
import ndgroups.mbrailway.model.Reservation;
import ndgroups.mbrailway.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation getReservationById(Integer id) {
        return reservationRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }
}
