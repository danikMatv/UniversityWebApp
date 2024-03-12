package com.foxmided.univerweb.Repository;

import com.foxmided.univerweb.Models.Teacher;
import com.foxmided.univerweb.Models.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer>
{
    void deleteTeacherByTeacherId(Integer teacherId);
    @Query(value = "SELECT v.(groupId) FROM timetable v WHERE teacherID = :teacherID",nativeQuery = true)
    List<Timetable> showTeacherDayGroupByTeacherId(@Param("teacherID") Integer teacherID) throws SQLException;

    @Query(value = "SELECT c FROM Teacher c")
    List<Teacher> findAll();

    @Transactional
    @Modifying
    @Query("UPDATE Teacher c SET c.teacherFirstName = :teachernewfirstname,c.teacherLastName = :teachernewlastname" +
            " WHERE c.teacherFirstName = :teacheroldfirstname AND c.teacherLastName = :teacheroldlastname")
    void updateTeacherByTeacherFirstNameAndTeacherFirstName(
            @Param("teachernewfirstname") String teachernewfirstname,
            @Param("teachernewlastname") String teachernewlastname,
            @Param("teacheroldfirstname") String teacheroldfirstname,
            @Param("teacheroldlastname") String teacheroldlastname);
    List<Teacher> findTeacherByTeacherId(Integer teacherId);
}
