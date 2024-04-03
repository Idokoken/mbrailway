//package ndgroups.mbrailway.service;
//
//import ndgroups.mbrailway.model.Role;
//import ndgroups.mbrailway.model.User;
//import ndgroups.mbrailway.repository.RoleRepository;
//import ndgroups.mbrailway.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.token.TokenService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Transactional
//public class AuthenticationService {
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private TokenService tokenService;
//
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
//
////    public LoginResponseDTO loginUser(String email, String password) {
////        try {
////            Authentication auth  = authenticationManager.authenticate(
////                    new UsernamePasswordAuthenticationToken(email, password)
////            );
////            SecurityContextHolder.getContext().setAuthentication(auth);
////
////            String token  = tokenService.generateJwt(auth);
////            Authentication user = SecurityContextHolder.getContext().getAuthentication();
////            return new LoginResponseDTO((User) user, token);
////        }catch (AuthenticationException e){
////            return new LoginResponseDTO(null, "");
////        }
////
////    }
//}
