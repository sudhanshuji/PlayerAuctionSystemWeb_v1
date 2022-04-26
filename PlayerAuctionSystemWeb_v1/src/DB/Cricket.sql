Create Database Cricket;

use Cricket;


Create table Team(
Team_Id int Primary key,
Team_Name varchar (255) NOT NULL
);

Create table Player(
Player_No int primary key AUTO_INCREMENT,
Player_Name varchar(255) Not Null,
Category varchar(255) Not Null,
Highest_Score int Not Null,
Best_Figure varchar(255) Not Null
);


create table team_player(
Player_No int primary key,
Team_Id int,
Foreign Key (Player_No) References Player(Player_No),
Foreign Key (Team_Id) References Team(Team_Id)
);


insert into Team (Team_Id, Team_Name)values
(1, 'Delhi Capitals'),
(2, 'Rajasthan Royals'),
(3, 'Chennai Super Kings'),
(4,'Mumbai Indians'),
(5, 'Bangalore Challengers');