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

## Relationships

1. **reservation_contains_payment** 

It is a one-to-one relation between `reservation` and `payment`, meaning a reservation can contain one payment for a trip. 
```
Maxima: one-one
Minima: zero-one
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

3. **payment** 

payment_id 1-1 (1); 
reservation_id 1-1(1); 
payment_date M-1 (1); 
amount M-1 (1)

4. **train** 

train_id 1-1 (1); 
seat_number M-1 (1); 
train_name 1-1 (0); 
train_status M-1 (1)

5. **ticket** 

ticket_id 1-1 (1);
train_id 1-1 (1);
station_depart M-1 (1); 
station_arrive M-1 (1); 
time_depart M-1 (1); 
time_arrive M-1 (1)

## Dependent entities and dependency relationships

- passenger: independent entity
- passenger_makes_reservation:  dependency relationship
- reservation_contains_payment: dependency relationship
- reservation_finalizes_ticket:  dependency relationship

## Supertypes, subtypes, and partitions

We do not have that.  

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


1. **passenger** 
```
+ passenger_id (PK) INT NOT NULL
passenger_id describes the entry identification of the passenger, and its type is an integer. 
+ fullname VARCHAR(50) NOT NULL
fullname is the passenger's name, and its type is a string that can hold up to 50 characters. 
+ address VARCHAR(50)
address is the passenger's address, and its type is a string that can hold up to 50 characters. 
+ join_date DATETIME NOT NULL
join_date is used for the date-time attribute, which identifies the passenger joins.
```

2. **reservation** 
```
+ reservation_id (PK) INT NOT NULL
reservation_id describes the entry identification of the booking reservation, and its type is an integer. 
+ passenger_id (FK) INT NOT NULL
passenger_id describes the entry identification of the passenger, and its type is an integer. 
+ ticket_id (FK) INT NOT NULL
ticket_id describes the entry identification of the ticket that the passenger confirms, and its type is an integer. 
+ reservation_status BOOLEAN NOT NULL
reservation_status indicates the status of the reservation. There is two status: (1) True - hold successfully, (2) False - fail to hold.
+ reservation_date DATETIME NOT NULL
reservation_date is used for the date-time attribute, which identifies the passengers who reserve their seats.
```

3. **payment** 
```
+ payment_id (PK) INT NOT NULL
payment_id describes the entry identification of the payment, and its type is an integer. 
+ reservation_id (FK) INT NOT NULL
reservation_id describes the entry identification of the booking reservation, and its type is an integer. 
+ payment_date DATETIME NOT NULL
payment_date is used for the date-time attribute, which identifies the passengers paid. 
+ amount M-1 DECIMAL(10,2) NOT NULL
amount indicates the amount of money that the passengers paid. Its type is decimal, and its unit is Vietnam's national currency (VND).
```

4. **train** 
```
+ train_id (PK) INT NOT NULL 
train_id describes the entry identification of the payment, and its type is an integer. 
+ seat_number INT NOT NULL 
seat_number indicates the passenger capacity of the train. Its type is an integer.
+ train_name VARCHAR(20) 
train_name indicates train's name, and its type is a string that can hold up to 20 characters. E.g., Yellow, Green, Violet.  
+ train_status BOOLEAN NOT NULL
train_status describes the status of the train. There is two status: (1) True - good and (2) False - maintained

```

5. **ticket** 
```
+ ticket_id (PK) INT NOT NULL
ticket_id describes the entry identification of the ticket that the passenger confirms, and its type is an integer. 
+ train_id (FK) INT NOT NULL
train_id describes the entry identification of the payment, and its type is an integer.
+ station_depart VARCHAR(20) NOT NULL
station_depart indicates the location that the train departs. Its type is a string that can hold up to 20 characters.
+ station_arrive VARCHAR(20) NOT NULL
station_depart indicates the location that the train arrives. Its type is a string that can hold up to 20 characters.
+ time_depart DATETIME NOT NULL
time_depart is used for the date-time attribute, which identifies the train departs.
+ time_arrive DATETIME NOT NULL
time_arrive is used for the date-time attribute, which identifies the train arrives.
```

## Plural attributes

The plural attribute that we implemented is `address` in `passenger`. 
The plural attribute `address` moves to the new table `address_passenger`. 
The foreign key `passenger_id` references the initial table.
The primary key of the new table is the composite of plural attribute `(passenger_id, address)`.


