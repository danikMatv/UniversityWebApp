package com.foxmided.univerweb.Service.ModelService;

import com.foxmided.univerweb.Models.Timetable;
import com.foxmided.univerweb.Repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TeacherServiceTest
{
    @Mock
    TeacherRepository teacherRepository;
    @InjectMocks
    TeacherService teacherService;
    @BeforeEach
    void setUp() throws SQLException {
        Timetable timetable = new Timetable();
        Mockito.when(teacherService.showTeacherDayGroupByTeacherId(1)).thenReturn(List.of(timetable));
    }
    @Test
    void showTeacherDayGroupByTeacherId() throws SQLException {
        int teacherId = 1;
        List<Timetable> dayTimetable = teacherService.showTeacherDayGroupByTeacherId(1);
        assertEquals(1,dayTimetable.get(0).getGroupId());
    }
}