package com.foxmided.univerweb.Models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "timetable")
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timetableid")
    private Integer timetableId;

    @ManyToOne
    @JoinColumn(name = "groupid")
    private Group groupIdFromTimetable;

    @ManyToOne
    @JoinColumn(name = "teacherid")
    private Teacher teacherId;

    @ManyToOne
    @JoinColumn(name = "teachingid")
    private Teaching teachingId;

    @Column(name = "day")
    private String day;


    public Timetable() {
    }

    public Timetable(Group groupIdFromTimetable, Teacher teacherId, Teaching teachingId, String day) {
        this.groupIdFromTimetable = groupIdFromTimetable;
        this.teacherId = teacherId;
        this.teachingId = teachingId;
        this.day = day;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Group getGroupId() {
        return groupIdFromTimetable;
    }

    public void setGroupId(Group groupId) {
        this.groupIdFromTimetable = groupIdFromTimetable;
    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    public Teaching getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(Teaching teachingId) {
        this.teachingId = teachingId;
    }

    public Integer getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(Integer timetableId) {
        this.timetableId = timetableId;
    }
}
