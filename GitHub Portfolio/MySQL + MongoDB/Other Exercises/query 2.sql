/* Task 1 */
DROP DATABASE IF exists Cluedo;
CREATE DATABASE Cluedo;
USE Cluedo;

DROP TABLE IF EXISTS Victim cascade;
CREATE TABLE Victim(
victimId int(6),
victimTitle varchar(10),
victimName varchar(20),
victimRoom varchar(20), 
deathTime time,
weapon varchar(20)
);

INSERT INTO Victim(victimId, victimTitle, victimName, victimRoom, deathTime, weapon)
VALUES(1, "Miss", "Scarlet", "Library", "10:45:00", "candlestick");

INSERT INTO Victim(victimId, victimTitle, victimName, victimRoom, deathTime, weapon)
VALUES(2, "Professor", "Plum", "Dining Room", "09:20", "revolver");

Select * FROM Victim;

DROP TABLE Victim;


CREATE TABLE Victim(
victimId int(6),
victimTitle varchar(10),
victimName varchar(20),
victimRoom varchar(20), 
deathTime time not null,
weapon varchar(20),
suspect varchar (6) default 'TRUE'
);


INSERT INTO Victim(victimId, victimTitle, victimName, victimRoom, deathTime, weapon, suspect)
VALUES(1, "Miss", "Scarlet", "Library", "10:45:00", "candlestick", default);

INSERT INTO Victim(victimId, victimTitle, victimName, victimRoom, deathTime, weapon, suspect)
VALUES(2, "Professor", "Plum", "Dining Room", "09:20:00", "revolver",default);


alter TABLE Victim
add column suspect varchar (6) DEFAULT 'True';

alter TABLE Victim
MODIFY time_death time NOT NULL;


INSERT INTO victim
values (3, 'Mrs', 'White', 'pantry', '12:40:00', 'rope', 'false');


INSERT INTO victim
values (6, 'Colonel', 'Mustard', 'Billiard Room', '18:00:00', 'knife', 'false');


INSERT INTO victim (id, title, name, room)
values (4, 'Reverand', 'Green', 'Kitchen');

delete from victim
where id = 4;

INSERT INTO victim
values (4, 'Reverand', 'Green', 'kitchen', '12:40:00', 'lead piping', default);


SELECT * from victim;

commit;