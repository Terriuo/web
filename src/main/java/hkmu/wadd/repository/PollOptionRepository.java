//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.repository;

import hkmu.wadd.model.Poll;
import hkmu.wadd.model.PollOption;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollOptionRepository extends JpaRepository<PollOption, Long> {
    List<PollOption> findByPoll(Poll poll);
}
