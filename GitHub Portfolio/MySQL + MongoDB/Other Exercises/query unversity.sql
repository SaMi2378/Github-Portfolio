CREATE DATABASE IF NOT EXISTS university;

USE university;

DROP TABLE if exists timetable cascade;
DROP TABLE if exists student cascade;
DROP TABLE if exists course_module cascade;
DROP TABLE if exists module cascade;
DROP TABLE if exists tutor cascade;
DROP TABLE if exists course cascade;

CREATE TABLE course(
course_name varchar(50) PRIMARY KEY,
duration numeric (2), 
cost float(6,2));

INSERT INTO course
VALUES ('C++', 18, 1750.50);
INSERT INTO course
VALUES ('Java', 20, 1950.50);
INSERT INTO course
VALUES ('Python', 15, 1800.00);
INSERT INTO course
VALUES ('R', 15, 2800.00);
INSERT INTO course
VALUES ('SQL', 12, 1600.00);

CREATE TABLE student(
studentId int(6) PRIMARY KEY,
studentName varchar(50),
studentCourse varchar(50),
FOREIGN KEY (studentCourse) REFERENCES course(course_name)
);

INSERT INTO student(studentId,studentName, studentCourse)
VALUES(1, 'Alex', 'C++');

INSERT INTO student(studentId,studentName, studentCourse)
VALUES(2, 'Jack', 'Java');

INSERT INTO student(studentId,studentName, studentCourse)
VALUES(3, 'Islay', 'Java');

INSERT INTO student(studentId,studentName, studentCourse)
VALUES(4, 'Maylee', 'Python');

INSERT INTO student(studentId,studentName, studentCourse)
VALUES(5, 'Sarah', 'Python');

CREATE TABLE Tutor(
tutorId numeric (3) PRIMARY KEY,
tutorFName varchar (15),
tutorLName varchar (30));

INSERT INTO Tutor
VALUES (001, 'Andrew', 'Holland');
INSERT INTO Tutor
VALUES (002, 'Helen', 'Martin');
INSERT INTO Tutor
VALUES (003, 'Abdul', 'Razak');

CREATE TABLE Module(
moduleid numeric (3) PRIMARY KEY,
modulename varchar (60),
Moduleleader numeric (3),
FOREIGN KEY (Moduleleader) REFERENCES Tutor(tutorId));

INSERT INTO Module
VALUES (201, 'Introduction to  Java', 003);
INSERT INTO Module
VALUES (202, 'Fundamentals of  SQL', 002);
INSERT INTO Module
VALUES (203, 'Basics of  C++', 001);

CREATE TABLE course_module(
registerid varchar (10) PRIMARY KEY,
moduleid numeric (3),
course_name varchar (50),
cohort char (1),
FOREIGN KEY (moduleid) REFERENCES module(moduleid),
FOREIGN KEY (course_name) REFERENCES course(course_name));

INSERT INTO course_module
VALUES ('JAV201', 201, 'Java', 'A');
INSERT INTO course_module
VALUES ('JAV202', 202, 'Java', 'A');
INSERT INTO course_module
VALUES ('C++203', 203, 'C++', 'B');
INSERT INTO course_module
VALUES ('PYT202', 202, 'Python', 'B');

CREATE TABLE timetable(
studentId int(6),
tutorId numeric (3),
startDate date,
`Day` varchar (9),
start_time time,
registerid varchar (10),
FOREIGN KEY (studentId) REFERENCES student(studentId),
FOREIGN KEY (tutorId) REFERENCES tutor(tutorId),
FOREIGN KEY (registerid) REFERENCES course_module(registerid),
PRIMARY KEY (studentId, registerid, startDate)
);

INSERT INTO timetable
VALUES (3, 002, '21-09-22', 'Monday', '10:00:00', 'JAV201' );
INSERT INTO timetable
VALUES (3, 002, '21-09-22', 'Monday', '13:00:00', 'JAV202' );


commit;



