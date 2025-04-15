package hkmu.wadd.controller;

import hkmu.wadd.dao.UsersRepository;
import hkmu.wadd.model.GuestBookEntry;
import hkmu.wadd.model.UsersEntry;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/login")
public class UsersController {
    @Resource
    private UsersRepository usRepo;

    @GetMapping("/register")
    public ModelAndView signUpForm() {
        return new ModelAndView("SignUp", "entry", new UsersEntry());
    }

    @PostMapping("/register")
    public View signUpForm(@ModelAttribute("entry") UsersEntry usEntry) {
        usRepo.save(usEntry);
        return new RedirectView("/Project/login"); // One way to redirect in Spring MVC
    }
}
