package hkmu.wadd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "redirect:/indexpage/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
