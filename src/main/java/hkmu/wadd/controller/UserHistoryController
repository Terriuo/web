//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.controller;

import hkmu.wadd.dao.UsersRepository;
import hkmu.wadd.repository.CommentRepository;
import hkmu.wadd.repository.VoteRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserHistoryController {
    @Autowired
    private VoteRecordRepository voteRecordRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UsersRepository usersRepository;

    public UserHistoryController() {
    }

    @GetMapping({"/user/voting-history"})
    public String showVotingHistory(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        this.usersRepository.findByUsername(userDetails.getUsername()).ifPresent((user) -> model.addAttribute("votes", this.voteRecordRepository.findByUserId(user.getId())));
        return "voting-history";
    }

    @GetMapping({"/user/comment-history"})
    public String showCommentHistory(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        this.usersRepository.findByUsername(userDetails.getUsername()).ifPresent((user) -> model.addAttribute("comments", this.commentRepository.findByUserId(user.getId())));
        return "comment-history";
    }
}
