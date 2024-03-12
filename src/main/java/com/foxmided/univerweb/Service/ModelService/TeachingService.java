package com.foxmided.univerweb.Service.ModelService;

import com.foxmided.univerweb.Models.Teaching;
import com.foxmided.univerweb.Repository.TeachingRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TeachingService {
    private final TeachingRepository teachingRepository;

    public TeachingService(TeachingRepository teachingRepository) {
        this.teachingRepository = teachingRepository;
    }

    @Transactional
    public Teaching save(Teaching teaching) {
        return teachingRepository.save(teaching);
    }

    @Transactional
    public void deleteTeachingByTeacherId(Integer teachingId) {
        teachingRepository.deleteTeachingByTeacherId(teachingId);
    }
}
