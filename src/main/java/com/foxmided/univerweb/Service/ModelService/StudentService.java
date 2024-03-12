package com.foxmided.univerweb.Service.ModelService;

import com.foxmided.univerweb.Models.Group;
import com.foxmided.univerweb.Models.Student;
import com.foxmided.univerweb.Models.Timetable;
import com.foxmided.univerweb.Repository.StudentRepository;
import com.foxmided.univerweb.Repository.TimetableRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    private final StudentRepository studentRepository;
    private final TimetableRepository timetableRepository;

    public StudentService(StudentRepository studentRepository,TimetableRepository timetableRepository){
        this.studentRepository = studentRepository;
        this.timetableRepository = timetableRepository;
    }
    public Optional<Student> searchStudentByStudentId(Integer studentId) throws SQLException {
        return studentRepository.searchStudentByStudentId(studentId);
    }

    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void deleteStudentByStudentId(Integer studentId) {
        studentRepository.deleteStudentByStudentId(studentId);
    }

    public List<Timetable> showStudentDayTimetableByStudentGroup(Group group) {
        return timetableRepository.showStudentDayTimetableByStudentGroup(group);
    }

    public Optional<Student> searchStudentByStudentFirstNameAndStudentLastName(String studentFirstName) {
        return searchStudentByStudentFirstNameAndStudentLastName(studentFirstName);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
