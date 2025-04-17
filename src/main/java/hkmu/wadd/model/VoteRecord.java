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
import jakarta.persistence.Table;

@Entity
@Table(
    name = "vote_records"
)
public class VoteRecord {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne
    @JoinColumn(
        name = "user_id"
    )
    private UsersEntry user;
    @ManyToOne
    @JoinColumn(
        name = "poll_option_id"
    )
    private PollOption pollOption;

    public VoteRecord() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsersEntry getUser() {
        return this.user;
    }

    public void setUser(UsersEntry user) {
        this.user = user;
    }

    public PollOption getPollOption() {
        return this.pollOption;
    }

    public void setPollOption(PollOption pollOption) {
        this.pollOption = pollOption;
    }
}
