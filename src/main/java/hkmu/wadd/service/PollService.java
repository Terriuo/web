package main.java.hkmu.wadd.service;

import hkmu.wadd.model.Poll;
import hkmu.wadd.repository.PollRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {
    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll savePoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public Optional<Poll> getPollById(Long id) {
        return pollRepository.findById(id);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }
}