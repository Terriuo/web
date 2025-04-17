//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.service;

import hkmu.wadd.model.Comment;
import hkmu.wadd.model.Lecture;
import hkmu.wadd.repository.CommentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment) {
        return (Comment)this.commentRepository.save(comment);
    }

    public Optional<Comment> getCommentById(Long id) {
        return this.commentRepository.findById(id);
    }

    public List<Comment> getCommentsByLecture(Lecture lecture) {
        return this.commentRepository.findByLecture(lecture);
    }
}
