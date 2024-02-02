CREATE DATABASE university;
USE university;

DROP TABLE if exists student cascade;

create table student(
studentId int(6),
studentName varchar(50),
studentCourse varchar(50)
);

INSERT INTO student(studentId, studentName, studentCourse)
VALUES (1, "Naveed", "C++");

INSERT INTO student(studentId, studentName, studentCourse)
VALUES(2, "JACK", "JAVA");

INSERT INTO student(studentId, studentName, studentCourse)
VALUES (3, "Islay", "Python");

INSERT INTO student(studentId, studentName, studentCourse)
VALUES(4, "Mylee", "Python");

INSERT INTO student(studentId, studentName, studentCourse)
VALUES (5, "Sarah", "JAVA");

commit;

