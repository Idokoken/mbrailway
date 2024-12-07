package ndgroups.mbrailway.repository;

import ndgroups.mbrailway.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {

//    @Query("")
//    List<Train> findAvailableTrainByOriginAndDestinationAndDepartureDate(String origin, String destination,
//                                                                         LocalDate departureDate);
//    @Query("SELECT r FROM Train r WHERE r.id NOT IN (SELECT b.train.id FROM Reservation b)")
//    List<Train>getAllAvailableTrains();
}
