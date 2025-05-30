package hkmu.wadd.controller;

import hkmu.wadd.dao.GuestBookEntryRepository;
import hkmu.wadd.model.GuestBookEntry;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;

@Controller
@RequestMapping("/indexpage")
public class GuestBookController {
    @Resource
    private GuestBookEntryRepository gbeRepo;

    @GetMapping({"", "/"})
    public String index(ModelMap model) {
        model.addAttribute("entries", gbeRepo.findAll());
        return "IndexPage";
    }

    @GetMapping("/add")
    public ModelAndView addCommentForm() {
        return new ModelAndView("AddComment", "entry", new GuestBookEntry());
    }

    @PostMapping("/add")
    public View addCommentHandle(@ModelAttribute("entry") GuestBookEntry gbEntry) {
        gbEntry.setDate(new Date());
        gbeRepo.save(gbEntry);
        return new RedirectView("."); // One way to redirect in Spring MVC
    }

    @GetMapping("/edit/{id}")
    public String editCommentForm(@PathVariable("id") long entryId, ModelMap model) {
        GuestBookEntry entry = gbeRepo.findById(entryId).orElse(null);
        if (entry == null) {
            return "redirect:/indexpage";
        }
        model.addAttribute("entry", entry);
        return "EditComment";
    }

    @PostMapping("/edit/{id}")
    public String editCommentHandle(@PathVariable("id") long entryId, @ModelAttribute("entry") GuestBookEntry gbEntry) {
        if (gbEntry.getId() == entryId) {
            gbEntry.setDate(new Date());
            gbeRepo.save(gbEntry);
        }
        return "redirect:.."; // Another way to redirect in Spring MVC
    }

    @GetMapping("/delete/{id}")
    public String deleteEntry(@PathVariable("id") long entryId) {
        GuestBookEntry entry = gbeRepo.findById(entryId).orElse(null);
        if (entry == null) {
            return "redirect:/indexpage";
        }
        gbeRepo.deleteById(entryId);
        return "redirect:/";
    }


}
