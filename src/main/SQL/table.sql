CREATE TABLE Student
(
    studentId SERIAL primary key,
    groupId INTEGER,
    studentFirstName varchar(256) NOT NULL,
    studentLastName varchar(256) NOT NULL,
    FOREIGN KEY (groupId) REFERENCES groups(groupId)
);
CREATE TABLE Teacher
(
    teacherId SERIAL primary key,
    teacherFirstName varchar(256) NOT NULL,
    teacherLastName varchar(256) NOT NULL
);
CREATE TABLE groups
(
    groupId SERIAL primary key,
    groupName varchar(256) NOT NULL
);
CREATE TABLE teaching
(
    teachingId SERIAL primary key,
    teachingName varchar(256) NOT NULL,
    teacherId INTEGER,
    FOREIGN KEY (teacherId) REFERENCES Teacher(teacherId)
);
