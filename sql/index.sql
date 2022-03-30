CREATE INDEX passengerName ON dbs_metro_system.passenger(fullname); 
CREATE INDEX amount ON dbs_metro_system.payment(amount);
CREATE INDEX reservationStatus ON dbs_metro_system.reservation(reservation_status);
CREATE INDEX stationDepart ON dbs_metro_system.ticket(station_depart);
CREATE INDEX trainName ON dbs_metro_system.train(train_name);
