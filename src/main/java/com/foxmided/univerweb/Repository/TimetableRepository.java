package com.foxmided.univerweb.Repository;

import com.foxmided.univerweb.Models.Group;
import com.foxmided.univerweb.Models.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Integer> {
    @Query(value = "SELECT c.* FROM timetable c WHERE groupid = :groupid AND dayTime = :dayTime", nativeQuery = true)
    List<Timetable> searchTimetableByGroupIdAndDay(@Param("groupid") Integer groupid, @Param("dayTime") String dayTime);

    @Query(value = "SELECT c.* FROM timetable c WHERE teacherid = :teacherid AND dayTime = :dayTime", nativeQuery = true)
    List<Timetable> searchTimetableByTeacherIdAndDay(@Param("teacherid") Integer teacherid,@Param("dayTime") String dayTime);

    @Query(value = "SELECT v FROM Timetable v WHERE v.groupIdFromTimetable = ?1")
    List<Timetable> showStudentDayTimetableByStudentGroup(@Param("group") Group group);

    @Query(value = "SELECT v.* FROM timetable v WHERE teacherid = :teacherid",nativeQuery = true)
    List<Timetable> showTeacherDayTimetableByTeacherId(@Param("teacherid") Integer teacherid);

}