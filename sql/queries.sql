-- SIMPLE QUERIES
CREATE VIEW passenger_view AS
SELECT * FROM dbs_metro_system.passenger
WHERE join_date <= '2020-01-05 00:00:00'
ORDER BY join_date;

CREATE VIEW ticket_view AS
SELECT * FROM dbs_metro_system.ticket
WHERE time_depart >= '2022-01-03 13:23:00' and time_arrive <= '2022-01-05 19:00:00' 
ORDER BY station_depart DESC;

-- AGGREGATE QUERIES
CREATE VIEW train_aggregate AS
SELECT * FROM dbs_metro_system.train
WHERE seat_number < 
    (
        SELECT AVG(seat_number) 
        FROM dbs_metro_system.train
    )
    and LENGTH(train_name) > 3;

CREATE VIEW payment_aggregate AS
SELECT * FROM dbs_metro_system.payment
WHERE amount < 
	(
		SELECT AVG(amount) 
		FROM dbs_metro_system.payment
	)
    AND payment_date >= '2022-01-04 14:21:00';

-- COMPLEX QUERIES
CREATE VIEW passenger_complex AS
SELECT passenger.passenger_id, fullname, amount 
FROM dbs_metro_system.passenger 
INNER JOIN dbs_metro_system.reservation 
INNER JOIN dbs_metro_system.payment 
WHERE passenger.passenger_id = reservation.passenger_id and payment.reservation_id = reservation.reservation_id 
    AND amount > 
    ( 
        SELECT AVG(amount) 
        FROM dbs_metro_system.payment
    ) 
    AND year(passenger.join_date) > 2020;

CREATE VIEW payment_reservation_complex AS
SELECT  payment.payment_id, payment.reservation_id, reservation.ticket_id
FROM dbs_metro_system.payment
JOIN dbs_metro_system.reservation
WHERE EXISTS 
    (
        SELECT payment_id 
        FROM payment
    ) 
    AND payment.amount > 50000;