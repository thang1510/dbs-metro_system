USE dbs_metro_system;

INSERT INTO `passenger` (`passenger_id`, `fullname`, `address`, `join_date`)
VALUES (1,'Takanashi Kiara','1234 Random st','2020-01-03 11:43:00'),
(2,'Gawr Gura','HololiveEN st','2020-01-04 12:27:00'),
(3,'Ninomae Ina\'nis','Takobell boulevard','2021-01-05 19:45:00'),
(4,'Le Thanh Thao','61 Sheridan st','2019-01-05 19:41:00'),
(5,'Nguyen Duc Nghia','75 West st','2021-01-06 12:45:00');

INSERT INTO `train` (`train_id`, `seat_number`, `train_name`, `train_status`)
VALUES (1,100,'Blue',1),(2,100,'Yellow',1),(3,100,'Green',0),(4,104,'Red',1),(5,1000,'Violet',1);

INSERT INTO `ticket` (`ticket_id`, `train_id`, `station_depart`, `station_arrive`, `time_depart`, `time_arrive`)
VALUES (1,5,'Ben Thanh','Mien Dong','2022-01-03 13:23:00','2022-01-03 14:23:00'),
(2,3,'Ba Queo','Thu Thiem','2022-01-04 14:21:00','2022-01-04 15:26:00'),
(3,2,'Tan Kien','Go Vap','2022-01-05 17:23:00','2022-01-05 19:00:00'),
(4,4,'Can Guoc','Dam Sen','2022-01-06 10:23:00','2022-01-06 12:45:00'),
(5,1,'Tan Son Nhat','Tham Luong','2022-01-07 08:12:00','2022-01-07 10:16:00');

INSERT INTO `reservation` (`reservation_id`, `passenger_id`, `ticket_id`, `reservation_status`, `reservation_date`)
VALUES (1,1,1,1,'2022-01-03 10:33:00'),(2,2,2,1,'2022-01-04 10:21:00'),
(3,3,3,1,'2022-01-05 09:34:00'),(4,4,4,1,'2022-01-05 17:03:00'),(5,5,5,1,'2022-01-06 10:19:00');

INSERT INTO `payment` (`payment_id`, `reservation_id`, `payment_date`, `amount`)
VALUES (1,1,'2022-01-03 13:23:00',50000),(2,2,'2022-01-04 14:21:00',20000),
(3,3,'2022-01-05 17:23:00',33000),(4,4,'2022-01-06 10:23:00',40000),(5,5,'2022-01-07 08:12:00',55000);
