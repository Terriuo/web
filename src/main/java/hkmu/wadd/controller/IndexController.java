//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    public IndexController() {
    }

    @GetMapping({"/"})
    public String index() {
        return "redirect:/indexpage/";
    }

    @GetMapping({"/login"})
    public String login() {
        return "login";
    }
}
