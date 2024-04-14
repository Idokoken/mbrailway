package ndgroups.mbrailway.controller;

import ndgroups.mbrailway.model.User;
import ndgroups.mbrailway.repository.UserRepository;
import ndgroups.mbrailway.service.AuthenticationService;
import ndgroups.mbrailway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
//@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private AuthenticationService authenticationService;
    @GetMapping("/register")
    public String getRegisterUser(@ModelAttribute("user") User user) {
        return "pages/register";
    }
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, Model model) {
//        User newUser = authenticationService.registerUser(user);
//        model.addAttribute("message", "registration successful");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login?success";
    }
//    @PostMapping("/register")
//    public String registerUser(@Valid @ModelAttribute("user") RegistrationDTO userDTO, Model model, Errors errors) {
//        User existingUser = userService.findUserByEmail(userDTO.getEmail());
//
//        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
//            errors.rejectValue("email", null,
//                    "Email already in use");
//        }
//        if(errors.hasErrors()){
//            return "pages/register";
//        }
//        authenticationService.registerUser(userDTO.getName(),userDTO.getEmail(), userDTO.getPassword());
////      userService.addUser(userDto);
//        return "redirect:/auth/login?success";
//    }

    @GetMapping("/login")
    public String getLogin() {
        return "pages/login";
    }

    //logout route
    @PostMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }
}

