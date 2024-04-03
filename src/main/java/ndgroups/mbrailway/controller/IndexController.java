package ndgroups.mbrailway.controller;

import ndgroups.mbrailway.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class IndexController {
    @Autowired
    private ReservationService reservationService;

//    @GetMapping
//    public String getHome(Model model){
//        return "index";
//    }
    @GetMapping("/contact")
    public String getContact() {
        return "pages/contact";
    }
    @PostMapping("/contact")
    public String createMessage(Model model) {
        model.addAttribute("greeting", "message sent successfully");
        return "pages/contact";
    }
    @GetMapping("/about")
    public String getAbout() {
        return  "pages/about";
    }
    @GetMapping("/faq")
    public String getFAQ() {
        return  "pages/FAQ";
    }
    @GetMapping("/timetable")
    public String getTrainTimetable() {
        return "pages/trainTimetable";
    }
    @GetMapping("/terms")
    public String getTeamsPage() {
        return  "pages/termsAndConditions";
    }
    @GetMapping("/privacy")
    public String getPrivacyPolicy() {
        return  "pages/privacyPolicy";
    }
    @GetMapping("/cookies")
    public String getCookiesPage() {
        return  "pages/cookies";
    }
    @GetMapping("/disclaimer")
    public String getDisclaimerPage() {
        return  "pages/disclaimer";
    }
    @GetMapping("/blog")
    public String getBlogPage() {
        return  "pages/blog";
    }

}
