package ndgroups.mbrailway.service;

import jakarta.persistence.EntityNotFoundException;
import ndgroups.mbrailway.model.Reservation;
import ndgroups.mbrailway.repository.ReservationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    public  List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getOneReservation(Integer id) {
        return reservationRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("no reservation with the given id: " + id));
    }

    public List<Reservation> searchReservations(String origin, String destination, LocalDate filterDate,
                                            Integer passengers) {
        List<Reservation> listReservations = reservationRepository
                .findByOriginAndDestinationAndFilterDateAndAvailableSeats(origin, destination, filterDate,
                        passengers);
        return listReservations;
    }

    public Reservation updateReservation(Integer id, Reservation reservation){
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no reservation with the id of" + id));
        BeanUtils.copyProperties(reservation,existingReservation, "id");

        return reservationRepository.save(existingReservation);
    }
    public void deleteReservation(Integer id) {
        if(!reservationRepository.existsById(id)) {
            throw new EntityNotFoundException("no reservation with the id of" + id);
        }
        reservationRepository.deleteById(id);
    }
}
