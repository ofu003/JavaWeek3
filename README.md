# _Hair Salon_

####  02 April 2017

### Author: Oliver Fu

## Description

### This Java App allows users to view, delete, and add stylists and clients in a hair salon. Clients can also be assigned to a stylist.

## Specifications

| Behavior |   Input   |   Output   |
|----------|:---------:|:----------:|
|Instantiates a main object|*stylist object added |stylist object displayed on proper page|
|Instantiates a member object|*client object added |client object displayed on proper page|
| Can add a client to a stylist | client details submitted | client is shown in stylist's client list |
|Can delete a client from a stylist |client is deleted|client no longer shown in stylist's list|
|Can update a client|"Sara Carter: wants hair dyed"->"Sara Carter: wants hair curled"|client details updated|
| Can add a stylist | stylist details submitted | stylist is shown on appropriated routed pages|
|Can delete a stylist |stylist is deleted|stylist no longer shown in list of stylists|
|Can update a stylist|"Ted Bard: saw 4 clients this week so far"->"Ted Bard: saw 9 clients this week so far"|stylist details updated|




## Setup and Installation Requirements

Clone this  [repository](https://github.com/ofu997/JavaWeek3) and navigate to it. This will be the first tab.  

In a second terminal window, run $postgres.

In a third tab, run $psql, then #CREATE DATABASE hair_salon.

In the first tab, type $psql hair_salon < hair_salon.sql

In the third tab type #\c hair_salon to connect to the database, then # CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon.

In the first tab enter "gradle run".

Go to "localhost:4567" in a browser.





### Known Bugs
*

## Technologies Used

* postgresql
* Java
* JUnit
* Spark


### Licensing and Copyright

#### MIT License Copyright (c) 2017 by Oliver Fu
