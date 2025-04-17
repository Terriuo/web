//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.controller;

import hkmu.wadd.dao.UsersRepository;
import hkmu.wadd.model.Comment;
import hkmu.wadd.model.VoteRecord;
import hkmu.wadd.repository.CommentRepository;
import hkmu.wadd.repository.VoteRecordRepository;
import hkmu.wadd.service.PollOptionService;
import hkmu.wadd.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PollController {
    private final PollService pollService;
    private final PollOptionService pollOptionService;
    @Autowired
    private VoteRecordRepository voteRecordRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    public PollController(PollService pollService, PollOptionService pollOptionService) {
        this.pollService = pollService;
        this.pollOptionService = pollOptionService;
    }

    @GetMapping({"/poll/{id}"})
    public String showPoll(@PathVariable Long id, Model model) {
        this.pollService.getPollById(id).ifPresent((poll) -> {
            model.addAttribute("poll", poll);
            model.addAttribute("options", poll.getOptions());
            model.addAttribute("comments", poll.getComments());
            model.addAttribute("comment", new Comment());
        });
        return "poll-page";
    }

    @PostMapping({"/vote"})
    public String vote(@RequestParam Long pollId, @RequestParam Long selectedOptionId, RedirectAttributes redirectAttributes, @AuthenticationPrincipal UserDetails userDetails) {
        this.pollService.getPollById(pollId).ifPresent((poll) -> this.pollOptionService.getPollOptionById(selectedOptionId).ifPresent((option) -> {
                option.setVoteCount(option.getVoteCount() + 1);
                this.pollOptionService.savePollOption(option);
                VoteRecord voteRecord = new VoteRecord();
                this.usersRepository.findByUsername(userDetails.getUsername()).ifPresent((user) -> {
                    voteRecord.setUser(user);
                    voteRecord.setPollOption(option);
                    this.voteRecordRepository.save(voteRecord);
                });
            }));
        redirectAttributes.addAttribute("pollId", pollId);
        return "redirect:/poll/{pollId}";
    }

    @GetMapping({"/poll/{id}/comment"})
    public String showCommentForm(@PathVariable Long id, Model model) {
        model.addAttribute("pollId", id);
        model.addAttribute("comment", new Comment());
        return "add-comment";
    }

    @PostMapping({"/poll/{id}/comment"})
    public String postComment(@PathVariable Long id, @ModelAttribute Comment comment, @AuthenticationPrincipal UserDetails userDetails) {
        this.pollService.getPollById(id).ifPresent((poll) -> {
            comment.setPoll(poll);
            this.usersRepository.findByUsername(userDetails.getUsername()).ifPresent((user) -> {
                comment.setUser(user);
                this.commentRepository.save(comment);
            });
        });
        return "redirect:/poll/{id}";
    }
}
