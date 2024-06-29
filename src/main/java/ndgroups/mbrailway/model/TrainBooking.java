package ndgroups.mbrailway.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "trainBooking")
public class TrainBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BookingId;
    private Integer noOfPersons;
    private Double totalAmount;
//    private User user;
//    private Reservation reservation;
}
