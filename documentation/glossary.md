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

1. **passenger_makes_payment** 

It is a one-to-many relation between `passenger` and `payment`, meaning a passenger can make many payments for a trip. 
```
Maxima: one-many
Minima: one-zero
```

2. **passenger_makes_reservation**

It is a one-to-many (optional) relation between `passenger` and `reservation`. This relationship indicates passengers can make one or more bookings to reserve their seats.
```
Maxima: one-many
Minima: one-zero
```

3. **reservation_finalizes_ticket**

It is a one-to-one relation between `reservation` and `ticket`. It means that only reservations correspond with one ticket to confirm that the passenger has completed their booking.
```
Maxima: one-one
Minima: one-one
```

4. **ticket_indicates_train**

It is a many-to-one relation between `ticket` and `train`, in which one ticket corresponds with one train, but the train can include more than one ticket. 
```
Maxima: many-one
Minima: zero-one
```

## Attributes

1. **passenger** 

passenger_id 1-1 (1);
fullname M-1 (1);
address M-M (0);
join_date M-1 (1)

2. **reservation** 

reservation_id 1-1 (1);
passenger_id 1-1 (1);
ticket_id 1-1 (1);
reservation_status M-1 (1);
reservation_date M-1 (1)
user_id M-M (1);

3. **payment** 

payment_id 1-1 (1); 
reservation_id 1-1(1); 
ticket_id 1-1 (1); 
payment_date M-1 (1); 
amount M-1 (1)

4. **train** 

train_id 1-1 (1); 
seat_number M-1 (1); 
train_name 1-1 (0); 
train_status M-1 (1)

5. **ticket** 

ticket_id 1-1 (1);
station_depart M-1 (1); 
station_arrive M-1 (1); 
time_depart M-1 (1); 
time_arrive M-1 (1)

## Dependent entities and dependency relationships

- passenger: independent entity
- passenger-makes-reservation:  dependency relationship
- reservation-contains-payment: dependency relationship
- reservation-finalizes-ticket:  dependency relationship

## Supertypes, subtypes, and partitions

We do not have that 

## Cascade and restrict actions for dependency relationships

### Cascade
- reservation relects change to payment 
- reservation relects change to ticket 
### Restrict 
- Cannot remove passenger if reservation is using it
- Cannot remove reservation if payment is using it
- Cannot remove reservation if ticket is using it

## Cascade and restrict rules on foreign keys that implement dependency relationships

### Cascade
- `passenger_id` reflects change onto access from `passenger`
- `ticket_id` reflects change onto access from `payment` and `ticket`
### Restrict 
- Cannot remove the foreign key `passenger_id` while being used by `passenger`
- Cannot remove the foreign key `ticket_id` while being used by `payment` and `ticket`

## Implementing attribute types



