package com.foxmided.univerweb.Service.ModelService;

import com.foxmided.univerweb.Models.Student;
import com.foxmided.univerweb.Models.Timetable;
import com.foxmided.univerweb.Repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    static StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;
    @BeforeEach
    void setup() throws SQLException
    {
        Student testStudent = new Student(1, "Evan", "Smit");
        Mockito.when(studentRepository.searchStudentByStudentId(1)).thenReturn(Optional.of(testStudent));
    }
    @Test
    void searchStudentByStudentId() throws SQLException
    {
        int studenId = 1;
        Optional<Student> studentOptional = studentService.searchStudentByStudentId(1);
        assertEquals(studentOptional.get().getStudentFirstName(),"Jon");
    }

    @Test
    void updateStudentByStudent()
    {
        int groupId = 2;
        String name = "Mickel";
        String surName = "Tomson";
        Student student = new Student(groupId,name,surName);
        studentService.save(student);
    }

    @Test
    void deleteStudentByStudentId()
    {
        studentService.deleteStudentByStudentId(1);
    }
    /*@BeforeEach
    void setUp() throws SQLException
    {
        Timetable timetable = new Timetable();
        Mockito.when(studentService.showStudentDayTimetableByStudentGroup(G));
    @Test
    void showStudentDayTimetableByStudentGroup() throws SQLException {
        List<String> timetable = studentService.showStudentDayTimetableByStudentGroup(1);
        //assertEquals(timetable.size(),4);
        assertEquals(timetable.get(1),"Monday");
    }
    }*/
}