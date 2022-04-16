use  dbs_metro_system;

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

INSERT INTO `passenger` (`passenger_id`, `fullname`, `address`, `join_date`)
VALUES  (1,'Luong Viet Thang','1234 Random st','2020-01-03 11:43:00'),
        (2,'Tran Duc Tai','HololiveEN st','2020-01-04 12:27:00'),
        (3,'Tran Thanh Thien','Takobell boulevard','2021-01-05 19:45:00'),
        (4,'Le Thanh Thao','661 West Sheridan st','2019-01-05 19:41:00'),
        (5,'Nguyen Duc Nghia','75 West st','2021-01-06 12:45:00');

INSERT INTO `train` (`train_id`, `seat_number`, `train_name`, `train_status`)
VALUES  (1,100,'Blue',true),
        (2,100,'Yellow',true),
        (3,100,'Green',false),
        (4,104,'Red',false),
        (5,1000,'Violet',true);

INSERT INTO `ticket` (`ticket_id`, `train_id`, `station_depart`, `station_arrive`, `time_depart`, `time_arrive`)
VALUES  (1,5,'Ben Thanh','Mien Dong','2022-01-03 13:23:00','2022-01-03 14:23:00'),
        (2,3,'Ba Queo','Thu Thiem','2022-01-04 14:21:00','2022-01-04 15:26:00'),
        (3,2,'Tan Kien','Go Vap','2022-01-05 17:23:00','2022-01-05 19:00:00'),
        (4,4,'Can Guoc','Dam Sen','2022-01-06 10:23:00','2022-01-06 12:45:00'),
        (5,1,'Tan Son Nhat','Tham Luong','2022-01-07 08:12:00','2022-01-07 10:16:00');

INSERT INTO `reservation` (`reservation_id`, `passenger_id`, `ticket_id`, `reservation_status`, `reservation_date`)
VALUES  (1,1,1,true,'2022-01-03 10:33:00'),
        (2,2,2,true,'2022-01-04 10:21:00'),
        (3,3,3,true,'2022-01-05 09:34:00'),
        (4,4,4,true,'2022-01-05 17:03:00'),
        (5,5,5,true,'2022-01-06 10:19:00');

INSERT INTO `payment` (`payment_id`, `reservation_id`, `payment_date`, `amount`)
VALUES  (1,1,'2022-01-03 13:23:00',50000),
        (2,2,'2022-01-04 14:21:00',20000),
        (3,3,'2022-01-05 17:23:00',33000),
        (4,4,'2022-01-06 10:23:00',40000),
        (5,5,'2022-01-07 08:12:00',55000);