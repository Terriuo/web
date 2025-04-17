//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(
        name = "lecture_id"
    )
    private Lecture lecture;
    @ManyToOne
    @JoinColumn(
        name = "poll_id"
    )
    private Poll poll;
    @ManyToOne
    @JoinColumn(
        name = "user_id"
    )
    private UsersEntry user;

    public Comment() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Lecture getLecture() {
        return this.lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Poll getPoll() {
        return this.poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public UsersEntry getUser() {
        return this.user;
    }

    public void setUser(UsersEntry user) {
        this.user = user;
    }
}
