package com.foxmided.univerweb.Repository;

import com.foxmided.univerweb.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{
    @Query(value = "SELECT c.* FROM Student c WHERE studentId = :studentId",nativeQuery = true)
    Optional<Student> searchStudentByStudentId(@Param("studentId") Integer studentId) throws SQLException;

    void deleteStudentByStudentId(Integer studentId);

    Optional<Student> searchStudentByStudentFirstName(String studentFirstName);
    @Query(value = "SELECT c FROM Student c")
    List<Student> findAll();
}
