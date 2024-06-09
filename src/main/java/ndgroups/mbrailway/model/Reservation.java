package ndgroups.mbrailway.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;
    private LocalDate filterDate;
    private String origin;
    private String destination;
    private Integer availableSeats;
    private LocalDateTime departureTime;
    private Double price;
    private String time;
//    User customer;
    @CreationTimestamp
    private LocalDateTime reservationTime;

}
