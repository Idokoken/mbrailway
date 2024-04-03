package ndgroups.mbrailway.config;


import ndgroups.mbrailway.model.Reservation;
import ndgroups.mbrailway.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class LoadReservationInDb implements CommandLineRunner {
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public void run(String... args) throws Exception {
//        Reservation post1 = new Reservation("Reservation title 1", "Politics","Lorem ipsum dolor sit amet",
//                "Ken Idoko", "img cover", false);
//        Reservation post2 = new Reservation("Reservation title 2", "Politics","Lorem ipsum dolor sit amet",
//                "Ken Idoko", "img cover", false);


//        List<Reservation> postList = Arrays.asList(post1, post2, post3, post4, post5);
//        postList = postList.stream().collect(Collectors.toList());
//
//        reservationRepository.saveAll(postList);

    }
}
