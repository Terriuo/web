package main.java.hkmu.wadd.controller;

import hkmu.wadd.model.Lecture;
import hkmu.wadd.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LectureController {
    private final LectureService lectureService;

    @Autowired
    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping("/lecture/{id}")
    public String showLecture(@PathVariable Long id, Model model) {
        lectureService.getLectureById(id).ifPresent(lecture -> {
            model.addAttribute("lecture", lecture);
            model.addAttribute("comments", lecture.getComments());
        });
        return "lecture-material-page";
    }
}