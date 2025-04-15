package main.java.hkmu.wadd.controller;

import hkmu.wadd.model.Poll;
import hkmu.wadd.model.PollOption;
import hkmu.wadd.service.PollService;
import hkmu.wadd.service.PollOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PollController {
    private final PollService pollService;
    private final PollOptionService pollOptionService;

    @Autowired
    public PollController(PollService pollService, PollOptionService pollOptionService) {
        this.pollService = pollService;
        this.pollOptionService = pollOptionService;
    }

    @GetMapping("/poll/{id}")
    public String showPoll(@PathVariable Long id, Model model) {
        pollService.getPollById(id).ifPresent(poll -> {
            model.addAttribute("poll", poll);
            model.addAttribute("options", poll.getOptions());
            model.addAttribute("comments", poll.getComments());
        });
        return "poll-page";
    }

    @PostMapping("/vote")
    public String vote(@RequestParam Long pollId, @RequestParam Long selectedOptionId, RedirectAttributes redirectAttributes) {
        pollService.getPollById(pollId).ifPresent(poll -> {
            pollOptionService.getPollOptionById(selectedOptionId).ifPresent(option -> {
                option.setVoteCount(option.getVoteCount() + 1);
                pollOptionService.savePollOption(option);
            });
        });
        redirectAttributes.addAttribute("pollId", pollId);
        return "redirect:/poll/{pollId}";
    }
}