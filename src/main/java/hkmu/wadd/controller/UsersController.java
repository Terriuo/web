//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.controller;

import hkmu.wadd.dao.UsersRepository;
import hkmu.wadd.model.UsersEntry;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping({"/login"})
public class UsersController {
    @Resource
    private UsersRepository usRepo;

    public UsersController() {
    }

    @GetMapping({"/register"})
    public ModelAndView signUpForm() {
        return new ModelAndView("SignUp", "entry", new UsersEntry());
    }

    @PostMapping({"/register"})
    public View signUpForm(@ModelAttribute("entry") UsersEntry usEntry) {
        this.usRepo.save(usEntry);
        return new RedirectView("/Project/login");
    }
}
