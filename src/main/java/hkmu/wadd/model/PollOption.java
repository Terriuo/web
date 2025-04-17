//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PollOption {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String optionText;
    private int voteCount;
    @ManyToOne
    private Poll poll;

    public PollOption() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionText() {
        return this.optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public int getVoteCount() {
        return this.voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public Poll getPoll() {
        return this.poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }
}
