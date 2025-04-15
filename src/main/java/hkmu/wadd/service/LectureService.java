package main.java.hkmu.wadd.service;

import hkmu.wadd.model.Lecture;
import hkmu.wadd.repository.LectureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public Lecture saveLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    public Optional<Lecture> getLectureById(Long id) {
        return lectureRepository.findById(id);
    }

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }
}