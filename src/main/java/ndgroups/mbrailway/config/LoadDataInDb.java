package ndgroups.mbrailway.config;


import ndgroups.mbrailway.model.Role;
import ndgroups.mbrailway.model.User;
import ndgroups.mbrailway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadDataInDb{
    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            User user1 = new User( "name1", "name1@gmail.com","password",
                    Role.USER );
            User user2 = new User("name2", "name2@gmail.com","password",
                    Role.USER );
            User user3 = new User("name3", "name3@gmail.com","password",
                    Role.ADMIN );
            User user4 = new User("name4", "name4@gmail.com","password",
                    Role.ADMIN );
            userRepository.saveAll(List.of(user1, user2, user3, user4));
            System.out.println("data loaded in database");
        };
    }

}
