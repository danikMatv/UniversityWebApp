package com.foxmided.univerweb.Models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentid")
    private Integer studentId;

    @Column(name = "groupid")
    private Integer groupIdFromStudent;

    @Column(name = "studentfirstname")
    private String studentFirstName;

    @Column(name = "studentlastname")
    private String studentLastName;

    public Student(){}

    public Student(Integer groupIdFromStudent,String studentFirstName,String studentLastName)
    {
        this.groupIdFromStudent = groupIdFromStudent;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
    }

    public Integer getGroupId() {
        return groupIdFromStudent;
    }

    public void setGroupId(Integer groupId) {
        this.groupIdFromStudent = groupIdFromStudent;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
