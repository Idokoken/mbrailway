package ndgroups.mbrailway.controller;

import ndgroups.mbrailway.model.User;
//import ndgroups.mbrailway.service.AuthenticationService;
import ndgroups.mbrailway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
//@CrossOrigin("*")
public class AuthController {
    @Autowired
    private UserService userService;
//    @Autowired
//    AuthenticationService authenticationService;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private TokenService tokenService;


    @GetMapping("/register")
    public String getRegisterUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "pages/register";
    }
    //    @PostMapping("/register")
//    public User registerUser(@RequestBody RegistrationDTO userDTO) {
//        return authenticationService.registerUser(userDTO.getName(),userDTO.getEmail(), userDTO.getPassword());
//    }
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
    public String getLogin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "pages/login";
    }

    //    @PostMapping("/login")
//    public String loginUser(@ModelAttribute("user") RegistrationDTO userDTO) {
//        authenticationService.loginUser(userDTO.getEmail(), userDTO.getPassword());
//        return "redirect:/";
//    }
//    @PostMapping("/login")
//    public String loginUser2(@ModelAttribute RegistrationDTO userDTO) {
//        Authentication auth  = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(userDTO.getName(), userDTO.getPassword())
//        );
//        SecurityContextHolder.getContext().setAuthentication(auth);
//
//        String token  = tokenService.generateJwt(auth);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        return "redirect:/";
//    }

    //logout route
    @PostMapping("/logout")
    public String logout() {
        return "redirect:/auth/login?logout";
    }
}

