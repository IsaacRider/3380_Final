DROP DATABASE IF EXISTS Formula1;
CREATE DATABASE IF NOT EXISTS Formula1;
USE Formula1;

-- RACER table
CREATE TABLE IF NOT EXISTS RACER (
    Driver_no INT NOT NULL,
    Fname VARCHAR(50) NOT NULL,
    Lname VARCHAR(50) NOT NULL,
    Team VARCHAR(50),
    Current_wins INT,
    Current_losses INT,
    PRIMARY KEY (Driver_no),
    CONSTRAINT chk_driver_no CHECK (Driver_no > 0)
);
-- TRACK table
CREATE TABLE IF NOT EXISTS TRACK (
    Name VARCHAR(100) NOT NULL,
    Location VARCHAR(100) NOT NULL,
    PRIMARY KEY (Name, Location)
);
-- RACE_CAR table
CREATE TABLE IF NOT EXISTS RACE_CAR (
    Vin VARCHAR(17) NOT NULL,
    Brand VARCHAR(50),
    Driver_no INT,
    PRIMARY KEY (Vin),
    CONSTRAINT fk_race_car_driver_no FOREIGN KEY (Driver_no) REFERENCES RACER(Driver_no)
);
-- EVENT table
CREATE TABLE IF NOT EXISTS EVENT (
    Name VARCHAR(100) NOT NULL,
    Location VARCHAR(100) NOT NULL,
    Date DATE NOT NULL,
    PRIMARY KEY (Name)
);
-- FAN table
CREATE TABLE IF NOT EXISTS FAN (
    Driver_no INT NOT NULL,
    Name VARCHAR(100) NOT NULL,
    Fan_of VARCHAR(50),
    PRIMARY KEY (Name, Driver_no),
    CONSTRAINT fk_fan_driver_no FOREIGN KEY (Driver_no) REFERENCES RACER(Driver_no)
);
-- RACES_IN table
CREATE TABLE IF NOT EXISTS RACES_IN (
    Driver_no INT NOT NULL,
    Event_name VARCHAR(100) NOT NULL,
    primary key (Driver_no, Event_name),
    CONSTRAINT fk_races_in_driver_no FOREIGN KEY (Driver_no) REFERENCES RACER(Driver_no),
    CONSTRAINT fk_races_in_event_name FOREIGN KEY (Event_name) REFERENCES EVENT(Name)
);
-- PAST_EVENTS table
CREATE TABLE IF NOT EXISTS PAST_EVENTS (
    Track_name VARCHAR(100) NOT NULL,
    Event_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (Track_name, Event_name),
    CONSTRAINT fk_past_events_track_name FOREIGN KEY (Track_name) REFERENCES TRACK(Name),
    CONSTRAINT fk_past_events_event_name FOREIGN KEY (Event_name) REFERENCES EVENT(Name)
);
-- RACING_STYLE table
CREATE TABLE IF NOT EXISTS RACING_STYLE (
    Driver_no INT NOT NULL,
    Style VARCHAR(100) NOT NULL,
    PRIMARY KEY (Driver_no),
    CONSTRAINT fk_racing_style_driver_no FOREIGN KEY (Driver_no) REFERENCES RACER(Driver_no)
);
-- DRIVER_RECORDS table
CREATE TABLE IF NOT EXISTS DRIVER_RECORDS (
    Driver_no INT NOT NULL,
    Season INT NOT NULL,
    Current_season_wins INT,
    Current_season_losses INT,
    PRIMARY KEY (Driver_no),
    CONSTRAINT fk_driver_records_driver_no FOREIGN KEY (Driver_no) REFERENCES RACER(Driver_no)
);


-- TRUNCATE TABLE RACER;
-- TRUNCATE TABLE TRACK;
-- TRUNCATE TABLE RACE_CAR;
-- TRUNCATE TABLE EVENT;
-- TRUNCATE TABLE FAN;
-- TRUNCATE TABLE RACES_IN;
-- TRUNCATE TABLE PAST_EVENTS;
-- TRUNCATE TABLE RACING_STYLE;
-- TRUNCATE TABLE DRIVER_RECORDS;


-- RACER table
INSERT INTO RACER (Driver_no, Fname, Lname, Team, Current_wins, Current_losses) 
VALUES
    (1, 'Lewis', 'Hamilton', 'Mercedes', 7, 2),
    (2, 'Max', 'Verstappen', 'Red Bull Racing', 5, 4),
    (3, 'Valtteri', 'Bottas', 'Mercedes', 3, 6),
    (4, 'Charles', 'Leclerc', 'Ferrari', 2, 7),
    (5, 'Daniel', 'Ricciardo', 'McLaren', 4, 5),
    (6, 'Sebastian', 'Vettel', 'Aston Martin', 1, 8),
    (7, 'Lando', 'Norris', 'McLaren', 6, 3),
    (8, 'Fernando', 'Alonso', 'Alpine', 3, 6),
    (9, 'Sergio', 'Perez', 'Red Bull Racing', 5, 4),
    (10, 'Carlos', 'Sainz', 'Ferrari', 2, 7);

-- TRACK table
INSERT INTO TRACK (Name, Location) 
VALUES
    ('Circuit de Spa-Francorchamps', 'Belgium'),
    ('Autodromo Nazionale Monza', 'Italy'),
    ('Suzuka Circuit', 'Japan'),
    ('Circuit of the Americas', 'USA'),
    ('Silverstone Circuit', 'UK'),
    ('Hungaroring', 'Hungary'),
    ('Sochi Autodrom', 'Russia'),
    ('Bahrain International Circuit', 'Bahrain'),
    ('Yas Marina Circuit', 'UAE'),
    ('Circuit Gilles Villeneuve', 'Canada');

-- RACE_CAR table
INSERT INTO RACE_CAR (Vin, Brand, Driver_no) 
VALUES
    ('WY9EQ Power', 'Mercedes', 1),
    ('RU16B', 'Red Bull Racing', 2),
    ('WI3EQ', 'Mercedes', 3),
    ('SI21', 'Ferrari', 4),
    ('MCL38', 'McLaren', 5),
    ('APR22', 'Aston Martin', 6),
    ('MVL36', 'McLaren', 7),
    ('AE22', 'Alpine', 8),
    ('RE16B', 'Red Bull Racing', 9),
    ('SRY21', 'Ferrari', 10);

-- EVENT table
INSERT INTO EVENT (Name, Location, Date) 
VALUES
    ('Belgian Grand Prix', 'Circuit de Spa-Francorchamps', '2024-08-25'),
    ('Italian Grand Prix', 'Autodromo Nazionale Monza', '2024-09-08'),
    ('Japanese Grand Prix', 'Suzuka Circuit', '2024-10-13'),
    ('United States Grand Prix', 'Circuit of the Americas', '2024-10-27'),
    ('British Grand Prix', 'Silverstone Circuit', '2024-07-14'),
    ('Hungarian Grand Prix', 'Hungaroring', '2024-08-04'),
    ('Russian Grand Prix', 'Sochi Autodrom', '2024-09-29'),
    ('Bahrain Grand Prix', 'Bahrain International Circuit', '2024-11-24'),
    ('Abu Dhabi Grand Prix', 'Yas Marina Circuit', '2024-12-01'),
    ('Canadian Grand Prix', 'Circuit Gilles Villeneuve', '2024-06-09');

-- FAN table
INSERT INTO FAN (Driver_no, Name, Fan_of) 
VALUES
    (1, 'John Smith', 'Lewis Hamilton'),
    (2, 'Emily Johnson', 'Max Verstappen'),
    (3, 'Michael Brown', 'Valtteri Bottas'),
    (4, 'Jessica Davis', 'Charles Leclerc'),
    (5, 'David Wilson', 'Daniel Ricciardo'),
    (6, 'Sarah Taylor', 'Sebastian Vettel'),
    (7, 'Christopher Martinez', 'Lando Norris'),
    (8, 'Amanda Anderson', 'Fernando Alonso'),
    (9, 'Matthew Thomas', 'Sergio Perez'),
    (10, 'Jennifer Garcia', 'Carlos Sainz');

-- RACES_IN table
INSERT INTO RACES_IN (Driver_no, Event_name) 
VALUES
    (1, 'Belgian Grand Prix'),
    (2, 'Italian Grand Prix'),
    (3, 'Japanese Grand Prix'),
    (4, 'United States Grand Prix'),
    (5, 'British Grand Prix'),
    (6, 'Hungarian Grand Prix'),
    (7, 'Russian Grand Prix'),
    (8, 'Bahrain Grand Prix'),
    (9, 'Abu Dhabi Grand Prix'),
    (10, 'Canadian Grand Prix');

-- PAST_EVENTS table
INSERT INTO PAST_EVENTS (Track_name, Event_name) 
VALUES
    ('Circuit de Spa-Francorchamps', 'Belgian Grand Prix'),
    ('Autodromo Nazionale Monza', 'Italian Grand Prix'),
    ('Suzuka Circuit', 'Japanese Grand Prix'),
    ('Circuit of the Americas', 'United States Grand Prix'),
    ('Silverstone Circuit', 'British Grand Prix'),
    ('Hungaroring', 'Hungarian Grand Prix'),
    ('Sochi Autodrom', 'Russian Grand Prix'),
    ('Bahrain International Circuit', 'Bahrain Grand Prix'),
    ('Yas Marina Circuit', 'Abu Dhabi Grand Prix'),
    ('Circuit Gilles Villeneuve', 'Canadian Grand Prix');

-- RACING_STYLE table
INSERT INTO RACING_STYLE (Driver_no, Style) 
VALUES
    (1, 'Aggressive'),
    (2, 'Tactical'),
    (3, 'Strategic'),
    (4, 'Consistent'),
    (5, 'Dynamic'),
    (6, 'Adaptive'),
    (7, 'Precision'),
    (8, 'Innovative'),
    (9, 'Bold'),
    (10, 'Dominant');

-- DRIVER_RECORDS table
INSERT INTO DRIVER_RECORDS (Driver_no, Season, Current_season_wins, Current_season_losses) 
VALUES
    (1, 2024, 5, 2),
    (2, 2024, 4, 3),
    (3, 2024, 3, 4),
    (4, 2024, 2, 5),
    (5, 2024, 4, 3),
    (6, 2024, 1, 6),
    (7, 2024, 6, 1),
    (8, 2024, 3, 4),
    (9, 2024, 5, 2),
    (10, 2024, 2, 5);


-- Retrieve all tuples from RACER table
SELECT *
FROM RACER;

-- Retrieve all tuples from TRACK table
SELECT *
FROM TRACK;

-- Retrieve all tuples from RACE_CAR table
SELECT *
FROM RACE_CAR;

-- Retrieve all tuples from EVENT table
SELECT *
FROM EVENT;

-- Retrieve all tuples from FAN table
SELECT *
FROM FAN;

-- Retrieve all tuples from RACES_IN table
SELECT *
FROM RACES_IN;

-- Retrieve all tuples from PAST_EVENTS table
SELECT *
FROM PAST_EVENTS;

-- Retrieve all tuples from RACING_STYLE table
SELECT *
FROM RACING_STYLE;

-- Retrieve all tuples from DRIVER_RECORDS table
SELECT *
FROM DRIVER_RECORDS;
