package com.foxmided.univerweb.Service.ModelService;

import com.foxmided.univerweb.Models.Timetable;
import com.foxmided.univerweb.Repository.TimetableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {
    private final TimetableRepository timetableRepository;

    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    public List<Timetable> searchTimetableByGroupIdAndDay(Integer groupId, String day) {
        return timetableRepository.searchTimetableByGroupIdAndDay(groupId,day);
    }

    public List<Timetable> searchTimetableByTeacherIdAndDay(Integer teacherId, String day)
    {
        return timetableRepository.searchTimetableByTeacherIdAndDay(teacherId,day);
    }
}
