//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.service;

import hkmu.wadd.model.Poll;
import hkmu.wadd.model.PollOption;
import hkmu.wadd.repository.PollOptionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PollOptionService {
    private final PollOptionRepository pollOptionRepository;

    public PollOptionService(PollOptionRepository pollOptionRepository) {
        this.pollOptionRepository = pollOptionRepository;
    }

    public PollOption savePollOption(PollOption pollOption) {
        return (PollOption)this.pollOptionRepository.save(pollOption);
    }

    public Optional<PollOption> getPollOptionById(Long id) {
        return this.pollOptionRepository.findById(id);
    }

    public List<PollOption> getPollOptionsByPoll(Poll poll) {
        return this.pollOptionRepository.findByPoll(poll);
    }
}
