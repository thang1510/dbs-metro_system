CREATE DATABASE dbs_metro_system;
USE dbs_metro_system;

-- table: passenger
CREATE TABLE passenger (
	passenger_id int NOT NULL UNIQUE,
    fullname varchar(100) NOT NULL,
    address varchar(100),
    join_date datetime NOT NULL,
    PRIMARY KEY (passenger_id)
);

-- table: train
CREATE TABLE train (
	train_id int NOT NULL UNIQUE,
	seat_number int NOT NULL,
    train_name varchar(100) NOT NULL,
    train_status boolean NOT NULL,
    PRIMARY KEY (train_id)
);

-- table: ticket
CREATE TABLE ticket (
	ticket_id int NOT NULL UNIQUE,
	train_id int NOT NULL UNIQUE,
    station_depart VARCHAR(100) NOT NULL,
    station_arrive VARCHAR(100) NOT NULL,
    time_depart DATETIME NOT NULL,
    time_arrive DATETIME NOT NULL,
    PRIMARY KEY (ticket_id),
    FOREIGN KEY (train_id) REFERENCES train(train_id)
);


-- table: reservation
CREATE TABLE reservation (
	reservation_id int NOT NULL UNIQUE,
	passenger_id int NOT NULL UNIQUE,
    ticket_id int NOT NULL UNIQUE,
    reservation_status boolean NOT NULL,
    reservation_date DATETIME NOT NULL,
    PRIMARY KEY (passenger_id),
    FOREIGN KEY (passenger_id) REFERENCES passenger(passenger_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (ticket_id) REFERENCES ticket(ticket_id) ON DELETE RESTRICT
);

-- table: payment
CREATE TABLE payment (
	payment_id int NOT NULL UNIQUE,
    reservation_id int NOT NULL UNIQUE,
	payment_date datetime NOT NULL,
    amount DECIMAL NOT NULL,
    PRIMARY KEY (payment_id),
	FOREIGN KEY (reservation_id) REFERENCES reservation(reservation_id) ON DELETE RESTRICT ON UPDATE CASCADE
);


CREATE TABLE user
(  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);


CREATE TABLE entity1 
(  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);