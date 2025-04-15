package main.java.hkmu.wadd.service;

import hkmu.wadd.model.Comment;
import hkmu.wadd.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> getCommentsByLecture(Lecture lecture) {
        return commentRepository.findByLecture(lecture);
    }
}