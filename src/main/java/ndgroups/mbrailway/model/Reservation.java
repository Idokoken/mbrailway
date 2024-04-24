package ndgroups.mbrailway.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;
    private String filterDate;
    private String fromDestination;
    private String toDestination;
    private Double price;
    private String time;
//    User customer;
    @CreationTimestamp
    private LocalDateTime bookingTime;

}
