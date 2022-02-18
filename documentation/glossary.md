# Glossary for database

## Entities

**passenger**

1. Name: passenger
2. Synonyms: traveler, commuter, customer
3. Description: A passenger train indicates transport people along a metro line. Passenger trains travel between stations, where passengers may depart and arrive.

**reservation**

1. Name: reservation
2. Synonyms: booking 
3. Description: Reservation indicates seat reservations for trains, and if the seats are available, people can make reservations.  

**payment**

1. Name: payment
2. Synonyms: fee
3. Description: Payment is a payment platform or network that allows transport people pays money to a metro system. It also helps people confirm their reservations on a specific trip. 

**train**

1. Name: train
2. Synonyms: capacity
3. Description: The train is train information that indicates train capacity, such as the number of seats or train status.

**ticket**

1. Name: ticket
2. Synonyms: pass 
3. Description: Ticket shows information about the station depart and arrive and the time of depart and disembark.

**user_login**

1. Name: user_login
2. Synonyms: user
3. Description: User_login takes a role of administration. He/she can controls information about payment and reservation. 


## Relationships

**passenger_makes_payment** 
It is a one-to-many relation between passenger and payment, meaning a passenger can make many payments for a trip. 

**passenger_makes_reservation**
It is a one-to-many (optional) relation between passenger and reservation. This relationship indicates passengers can make one or more bookings to reserve their seats.

**reservation_finalizes_ticket**
It is a one-to-one relation between reservation and ticket. It means that only reservations correspond with one ticket to confirm that the passenger has completed their booking.


**ticket_indicates_train**
It is a many-to-one relation between ticket and train, in which one ticket corresponds with one train, but the train can include more than one ticket. 

**login_user_controls_payment**
It is a one-to-many relation between login_user and payment that helps administrators control passengers' payment making. 

**login_user_controls_reservation**
Similar to login_user_controls_payment relation, it is a one-to-many relation between login_user and reservation that helps administrators can control passenger reservations. 

## Attributes

1. **passenger:** 
passenger_id 1-1 (1)
fullname M-1 (1)
address M-M (0) 
join_date 1-1 (1)

2. **reservation:** 
reservation_id 1-1 (1)
passenger_id M-1 (1)
ticket_id 1-1 (1)
reservation_status 1-1 (1)
reservation_date 1-1 (1)
user_id M-M (1)

3. **payment:** 
payment_id 1-1 (1)
passenger_id 1-1 (1)
user_id M-M (1)
ticket_id 1-1 (1)
payment_date 1-1 (1)
amount 1-1 (1)

4. **train:** 
train_id 1-1 (1)
seat_number 1-1 (1)
train_name 1-1 (0)
train_status 1-1 (1)

5. **ticket:** 
ticket_id 1-1 (1)  
station_depart 1-1 (1)
station_arrive 1-1 (1)
time_depart 1-1 (1)
time_arrive 1-1 (1) 

6. **user_login:** 
user_id 1-1 (1)      
user_name 1-1 (1)
user_password 1-1 (1)

