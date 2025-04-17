//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.service;

import hkmu.wadd.model.Lecture;
import hkmu.wadd.repository.LectureRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public Lecture saveLecture(Lecture lecture) {
        return (Lecture)this.lectureRepository.save(lecture);
    }

    public Optional<Lecture> getLectureById(Long id) {
        return this.lectureRepository.findById(id);
    }

    public List<Lecture> getAllLectures() {
        return this.lectureRepository.findAll();
    }
}
