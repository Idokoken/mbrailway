package ndgroups.mbrailway.service;

import ndgroups.mbrailway.model.User;
import ndgroups.mbrailway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;

@Transactional
public class AuthenticationService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

//    public User registerUser(String name, String email, String password) {
//        String encodedPassword = passwordEncoder.encode(password);
//        Role userRole = roleRepository.findByAuthority("USER").get();
//
//        Set<Role> authorities = new HashSet<>();
//        authorities.add(userRole);
//
//        return userRepository.save(new User(name, email, encodedPassword));
//
//    }

    public User registerUser(User user) {
//        user.setRoles(Arrays.asList("USER"));
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        Optional<User>optUser = userRepository.findByUsername(username);
        return optUser.get();
    }

}
