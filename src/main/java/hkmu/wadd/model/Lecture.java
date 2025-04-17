//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lecture {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String title;
    private String lectureNotesUrl;
    @OneToMany(
        mappedBy = "lecture"
    )
    private List<Comment> comments = new ArrayList();
    @ElementCollection
    @CollectionTable(
        name = "lecture_files",
        joinColumns = {@JoinColumn(
    name = "lecture_id"
)}
    )
    @Column(
        name = "file_url"
    )
    private List<String> fileUrls = new ArrayList();

    public Lecture() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLectureNotesUrl() {
        return this.lectureNotesUrl;
    }

    public void setLectureNotesUrl(String lectureNotesUrl) {
        this.lectureNotesUrl = lectureNotesUrl;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<String> getFileUrls() {
        return this.fileUrls;
    }

    public void setFileUrls(List<String> fileUrls) {
        this.fileUrls = fileUrls;
    }
}
