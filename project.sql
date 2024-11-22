create database airlinemanagementsystem;
use airlinemanagementsystem;
create table login(username varchar(30), password varchar(20));
insert into login values("AirIndia2024", "Air2024");
select * from login;
create table passenger (f_name varchar(30), l_name varchar(30),nationality varchar(15), 
phone varchar(12), address varchar(15), aadhar varchar(15), gender varchar(15));
insert into passenger values("Diksha", "Chhabra" , "Indian" , 9138453225 , "Sonipat", 423561478956, "Female"); 
select * from passenger;
create table flight(f_code varchar(20), f_name varchar(20), f_source varchar(40), f_destination varchar(40), f_amt varchar(10));
describe flight;
insert into flight values("1001", "AI-1212", "Delhi", "Mumbai", "6,532");
insert into flight values("1002", "AI-1453", "Delhi", "Goa", "5,869");
insert into flight values("1003", "AI-1112", "Mumbai", "Chennai", "3,641");
insert into flight values("1004", "AI-3222", "Delhi", "Amritsar", "2815");
insert into flight values("1005", "AI-1201", "Delhi", "Ayodhya", "2300");
insert into flight values("1006", "AI-1780", "Delhi", "Shimla", "3042");
select * from flight;
drop table flight;
create table reservation (PNR varchar(15), ticket varchar(15), aadhar varchar(15), f_name varchar(30), 
l_name varchar(30),nationality varchar(15), flightname varchar(20), flightcode varchar(20), flightamt varchar(10), src varchar (20),
 dest varchar(20), SEAT_NO varchar (100),date varchar(30),flightclass varchar(20), flightpym varchar(15) );
 drop table reservation;
 select * from reservation;

 
 create table cancel(pnr varchar(20), f_name varchar(20), l_name varchar(20), cancelno varchar(20), fcode varchar(20), date varchar(20));
 select * from cancel;
 