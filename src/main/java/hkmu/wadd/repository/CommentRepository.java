//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.repository;

import hkmu.wadd.model.Comment;
import hkmu.wadd.model.Lecture;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByUserId(UUID userId);

    List<Comment> findByLecture(Lecture lecture);
}
