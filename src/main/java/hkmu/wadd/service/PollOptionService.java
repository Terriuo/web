package main.java.hkmu.wadd.service;

import hkmu.wadd.model.PollOption;
import hkmu.wadd.repository.PollOptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollOptionService {
    private final PollOptionRepository pollOptionRepository;

    public PollOptionService(PollOptionRepository pollOptionRepository) {
        this.pollOptionRepository = pollOptionRepository;
    }

    public PollOption savePollOption(PollOption pollOption) {
        return pollOptionRepository.save(pollOption);
    }

    public Optional<PollOption> getPollOptionById(Long id) {
        return pollOptionRepository.findById(id);
    }

    public List<PollOption> getPollOptionsByPoll(Poll poll) {
        return pollOptionRepository.findByPoll(poll);
    }
}