package ndgroups.mbrailway.service;

import ndgroups.mbrailway.model.User;
import ndgroups.mbrailway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if(user.isPresent()){
            var userObj = user.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();

        } else {
            throw new UsernameNotFoundException("No user found for the given username");
        }
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            User user = userRepository.findByUsername(username);
//            if (user == null) {
//                throw new UsernameNotFoundException("User not found");
//            }
//            return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
//                    .password(user.getPassword())
//                    .roles(user.getRole())
//                    .build();
//        };
//    }

    public String[] getRoles(User user){
        if (user.getRole() == null) {
            return new String[]{"USER"};
        }
        return user.getRole().split(",");
    }



//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(username);
//        if(user == null) {
//            throw new UsernameNotFoundException("No user found for the given Email");
//        }
//        return new CustomUserDetails(user);
//    }
}
