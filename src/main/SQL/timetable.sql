CREATE TABLE timetable
(
    timetableId SERIAL,
    groupId INTEGER,
    teacherId INTEGER,
    teachingId INTEGER,
    day varchar(256),
    FOREIGN KEY (groupId) REFERENCES groups(groupId),
    FOREIGN KEY (teacherId) REFERENCES Teacher(teacherId),
    FOREIGN KEY (teachingId) REFERENCES teaching(teachingId)
);