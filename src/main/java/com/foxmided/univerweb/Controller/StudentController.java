package com.foxmided.univerweb.Controller;

import com.foxmided.univerweb.Models.Group;
import com.foxmided.univerweb.Models.Student;
import com.foxmided.univerweb.Models.Timetable;
import com.foxmided.univerweb.Service.ModelService.GroupService;
import com.foxmided.univerweb.Service.ModelService.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final GroupService groupService;

    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping
    public List<Student> homePage(Model model) {
        List<Student> student = studentService.getAll();
        model.addAttribute("students", student);
        return student;
    }

    @GetMapping("/deleteStudent/{studentId}")
    String deleteTeacher(@PathVariable("studentId") Integer studentId) throws SQLException {
        Optional<Student> student = studentService.searchStudentByStudentId(studentId);
        if (student.isPresent()) {
            studentService.deleteStudentByStudentId(studentId);
            return "succesful";
        } else return "error";
    }

    @GetMapping("/info/{studentId}")
    String searchStudentByStudentId(@PathVariable("studentId") Integer studentId, Model model) throws SQLException {
        Optional<Student> student = studentService.searchStudentByStudentId(studentId);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
            return "student-void";
        } else return "students";
    }

    @GetMapping("/showTimetable/{groupId}")
    String showStudentDayTimetableByStudentGroup(@PathVariable("groupId") Integer id, Model model) throws SQLException {
        Optional<Group> groupById = groupService.findGroupById(id);
        if (groupById.isPresent()) {
            Group group = groupById.get();
            List<Timetable> timetables = studentService.showStudentDayTimetableByStudentGroup(group);
            if (!timetables.isEmpty()) {
                model.addAttribute("timetables", timetables);
                return "student-timetable";
            }
        }

        return "error";
    }
}
