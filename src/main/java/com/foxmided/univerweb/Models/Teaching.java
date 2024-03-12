package com.foxmided.univerweb.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teaching")
public class Teaching {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teachingid")
    private Integer teachingId;

    @Column(name = "teachingname")
    private String teachingName;

    @Column(name = "teacherid")
    private Integer teacherId;

    public Teaching() {
    }

    public Teaching(String teachingName, int teacherId) {
        this.teachingName = teachingName;
        this.teacherId = teacherId;
    }


    public int getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(int teachingId) {
        this.teachingId = teachingId;
    }

    public String getTeachingName() {
        return teachingName;
    }

    public void setTeachingName(String teachingName) {
        this.teachingName = teachingName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}

