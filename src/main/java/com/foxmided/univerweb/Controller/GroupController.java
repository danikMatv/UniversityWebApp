package com.foxmided.univerweb.Controller;

import com.foxmided.univerweb.Models.Group;
import com.foxmided.univerweb.Service.ModelService.GroupService;
import com.foxmided.univerweb.Service.ModelService.StudentService;
import com.foxmided.univerweb.Service.ModelService.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/groups")

public class GroupController {
    private final GroupService groupService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public GroupController(GroupService groupService, StudentService studentService, TeacherService teacherService) {
        this.groupService = groupService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Group> homePage(Model model) {
        List<Group> group = groupService.getAll();
        model.addAttribute("groups", group);
        return group;
    }

    @GetMapping("/addGroup/{groupName}")
    String addGroup(@PathVariable("groupName") String groupName) {
        Group group = new Group(groupName);
        groupService.save(group);
        return "succesful";
    }
}
