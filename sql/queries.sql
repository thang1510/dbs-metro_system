SELECT * FROM dbs_metro_system.passenger
WHERE join_date <= '2020-01-05 00:00:00'
ORDER BY join_date;

SELECT * FROM dbs_metro_system.train
WHERE seat_number < (SELECT AVG(seat_number) FROM dbs_metro_system.train)
and LENGTH(train_name) > 3;

SELECT fullname, amount
FROM dbs_metro_system.passenger INNER JOIN dbs_metro_system.reservation INNER JOIN dbs_metro_system.payment
WHERE passenger.passenger_id = reservation.passenger_id and payment.reservation_id = reservation.reservation_id
	and amount > (SELECT AVG(amount) FROM dbs_metro_system.payment)
    and year(passenger.join_date) > 2020
group by fullname;