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
//    User customer;
    @CreationTimestamp
    private LocalDateTime CreatedAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
