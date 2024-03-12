package com.foxmided.univerweb.Service.ModelService;


import com.foxmided.univerweb.Models.Teacher;
import com.foxmided.univerweb.Models.Timetable;
import com.foxmided.univerweb.Repository.TeacherRepository;
import com.foxmided.univerweb.Repository.TimetableRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TimetableRepository timetableRepository;

    public TeacherService(TeacherRepository teacherRepository, TimetableRepository timetableRepository) {
        this.teacherRepository = teacherRepository;
        this.timetableRepository = timetableRepository;
    }

    @Transactional
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Transactional
    public void deleteTeacherByTeacherId(Integer teacherId)
    {
        teacherRepository.deleteTeacherByTeacherId(teacherId);
    }

    public List<Timetable> showTeacherDayGroupByTeacherId(@Param("teacherID") Integer teacherID) throws SQLException
    {
        return teacherRepository.showTeacherDayGroupByTeacherId(teacherID);
    }
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public List<Timetable> showTeacherDayTimetableByTeacherId(@Param("teacherid") Integer teacherid) {
        return timetableRepository.showTeacherDayTimetableByTeacherId(teacherid);
    }
    public void updateTeacherByTeacherFirstNameAndTeacherFirstName(
            @Param("teachernewfirstname") String teachernewfirstname, @Param("teachernewlastname") String teachernewlastname,
            @Param("teacheroldfirstname") String teacheroldfirstname, @Param("teacheroldlastname") String teacheroldlastname)
    {
        teacherRepository.updateTeacherByTeacherFirstNameAndTeacherFirstName(
                teachernewfirstname,teachernewlastname,teacheroldfirstname,teacheroldlastname);
    }

    public List<Teacher> findTeacherByTeacherId(Integer teacherId) {
        return teacherRepository.findTeacherByTeacherId(teacherId);
    }
}
