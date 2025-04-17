//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.service;

import hkmu.wadd.model.Poll;
import hkmu.wadd.repository.PollRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PollService {
    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll savePoll(Poll poll) {
        return (Poll)this.pollRepository.save(poll);
    }

    public Optional<Poll> getPollById(Long id) {
        return this.pollRepository.findById(id);
    }

    public List<Poll> getAllPolls() {
        return this.pollRepository.findAll();
    }
}
