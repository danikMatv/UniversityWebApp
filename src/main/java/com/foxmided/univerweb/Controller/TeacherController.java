package com.foxmided.univerweb.Controller;

import com.foxmided.univerweb.Models.Teacher;
import com.foxmided.univerweb.Models.Timetable;
import com.foxmided.univerweb.Service.ModelService.TeacherService;
import com.foxmided.univerweb.Service.ModelService.TimetableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherSevice;
    private final TimetableService timetableService;

    public TeacherController(TeacherService teacherSevice, TimetableService timetableService) {
        this.teacherSevice = teacherSevice;
        this.timetableService = timetableService;
    }

    @GetMapping
    public List<Teacher> homePage(Model model) {
        List<Teacher> teacher = teacherSevice.findAll();
        model.addAttribute("teachers", teacher);
        return teacher;
    }
    @PostMapping(value = "/addTeacher")
    public String addTeacher(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Teacher teacher = new Teacher(firstName, lastName);
        teacherSevice.save(teacher);
        return "redirect:/teachers";
    }
    @GetMapping("/addTeacher")
    public  String addTeacherPage(){return "teachers-addTeacher";}
    @PostMapping("/upTeacher")
    public String upTeacher(@RequestParam("oldFirstName") String oldFirstName,
                            @RequestParam("oldLastName") String oldLastName,
                            @RequestParam("newFirstName") String newFirstName,
                            @RequestParam("newLastName") String newLastName){
        teacherSevice.updateTeacherByTeacherFirstNameAndTeacherFirstName(
                newFirstName,newLastName,oldFirstName,oldLastName);
        return "redirect:/teachers";
    }
    @GetMapping("/upTeacher")
    public String upTeacherPage(){return "teachers-upTeacher";}
    @GetMapping("/deleteTeacher/{teacherId}")
    String deleteTeacher(Model model, @PathVariable("teacherId") Integer teacherId) {
        List<Teacher> teacher = teacherSevice.findTeacherByTeacherId(teacherId);
        if (!teacher.isEmpty()) {
            teacherSevice.deleteTeacherByTeacherId(teacherId);
            return "succesful";
        } else {
            return "error";
        }
    }

    @GetMapping("/showTimetable/{teacherId}")
    String showTeacherTimetable(Model model, @PathVariable("teacherId") Integer teacherId) {
        List<Timetable> timetables = teacherSevice.showTeacherDayTimetableByTeacherId(teacherId);
        if (!timetables.isEmpty()) {
            model.addAttribute("timetables", timetables);
            return "teacher-timetables";
        } else {
            return "error";
        }
    }
}
